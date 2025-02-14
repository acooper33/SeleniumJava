package actions.Webstorm;

import actions.selenium.Exists
import actions.selenium.SetFocus
import actions.selenium.utils.Elements
import actions.selenium.utils.VerifyUniqueItems
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.WaitForElement
import actions.selenium.utils.VerifyMatchingItems
import actions.selenium.Click
import actions.selenium.Refresh

class VerifyVisualParticipantWidgetonHomepage{
    public void run(def params){
        //wait until widget loads
		WaitForElement.run(ID:"//*[@class='fractal-visual-participants']//*[@class='visual-stats-wrapper']/SPAN", "Timeout In Seconds":"60")
        if(params."Topic Views"){
            assert Exists.run(ID:"//*[@class='fractal-visual-participants-loaded']/*[@class='visual-stats-wrapper']/SPAN[contains(.,'${params."Topic Views"}')]")==1,"Incorrect Topic View Count"
        }
        if(params."Submitted Solutions"){
            assert Exists.run(ID:"//*[@class='fractal-visual-participants-loaded']//A[@data-tooltip-id='visual-participants-submissions' and contains(.,'${params."Submitted Solutions"}')]")==1,"Incorrect Submitted Solutions Count"
        }
        //per Rob Goldstein, there is no paritcular order we display the users in 
        // verify that the actual usernames unique and match the expected usernames in any order
        if(params."Users"){
            if (params."Users"=="EMPTY"){
                assert Exists.run(ID:"//*[@class='visual-photo-wrapper']/DIV")==0,"Participants List not empty"
            } else {
                WebElement[] userPics = Elements.findAll(ID:"//*[@class='visual-photo-wrapper']/DIV",Browser.Driver)//actual user pics from UI
                String[] userNames = new String[userPics.length] 													//number of user pics from UI
                userPics.eachWithIndex{userPic, x ->
                	SetFocus.run(ID:"//*[@class='visual-photo-wrapper']/DIV[${x+1}]")
                    WebElement element = Elements.find(ID:"//*[@class='visual-photo-wrapper']/DIV[${x+1}]//UL[@id='flyover-info']/LI/A",Browser.Driver)
                    userNames[x] = element.getText()
                    sleep(500)
                }
                String unexpectedUsernameError = VerifyMatchingItems.run(expected:params."Users".split(","), actual:userNames, contains:true)
                assert VerifyUniqueItems.run(Items: userNames)==true, "Error - duplicate user names"	//verify each actual username from UI shows up only once
                assert unexpectedUsernameError==null, "Error - ${unexpectedUsernameError}"				//verify each actual username matches all the expected
            }
        }
        if(params."Ninth Circle Count"){
            assert Exists.run(ID:"//*[@class='visual-photo-counter']/SPAN[contains(.,'${params."Ninth Circle Count"}')]")==1,"Incorrect Topic View Count"
        }
        Refresh.run()
        if(params."Users engaged with the challenge"){
            if (params."Users engaged with the challenge"=="EMPTY"){
                assert Exists.run(ID:"//*[@class='visual-participants-wrapper']//A")==0,"Participants List not empty"
            } else {
                WebElement[] usersEngaged = Elements.findAll(ID:"//*[@class='visual-participants-wrapper']//A",Browser.Driver) //actual users from UI
                String[] usersEngagedNames = new String[usersEngaged.length] //usernames of enaged users
                usersEngaged.eachWithIndex{user, y ->
                    usersEngagedNames[y] = user.getText()
                    println("Engaged user from UI ${y}: ${usersEngagedNames[y]}")
                }
                String unexpectedEngagedUsernameError = VerifyMatchingItems.run(expected:params."Users engaged with the challenge".split(","), actual:usersEngagedNames, contains:true)
                assert VerifyUniqueItems.run(Items: usersEngagedNames)==true, "Error - Duplicate Enaged Usersnames"	//verify each actual username from UI shows up only once
                assert unexpectedEngagedUsernameError==null, "Error - ${unexpectedEngagedUsernameError}"			//verify each actual username exists in the expected  
            }
        }
        if(params."Additional Count of Users engaged with the Challenge"){
            assert Exists.run(ID:"//*[@class='visual-participants-wrapper']//A[contains(.,'${params."Additional Count of Users engaged with the Challenge"}')]")==1,"Additional Count of Users engaged with the Challenge incorrect"  
        }
        if(params."Click on"){
            if(params."Click on"=="First engaged user"){
            	//Click.run(ID:"//*[@class='fractal-visual-participants']//A[contains(.,'${params."Click on"}') and not(contains(@data-test,'flyover-user-link'))]")
            	Click.run(ID:"//*[@class='fractal-visual-participants']//*[contains(@class,'visual-participants-wrapper')]//A[1]")
        	}
            else {
            	Click.run(ID:"//*[@class='fractal-visual-participants']//A[contains(.,'${params."Click on"}') and not(contains(@data-test,'flyover-user-link'))]")
            }
        }
    }
}
