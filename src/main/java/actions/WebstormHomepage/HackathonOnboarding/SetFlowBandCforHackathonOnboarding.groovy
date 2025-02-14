package actions.WebstormHomepage.HackathonOnboarding


import actions.selenium.SetReactTags
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Browser
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

class SetFlowBandCforHackathonOnboarding{
    public void run(def params){
     
        SelectFirstFlowOptionForHackathonOnboarding.run("Flow Option Title":params."Flow Option Title")
        SetActionInHackathonOnboardingMenu.run("Action":params."Action on Get Started Screen")
        SetExpertiseforJoiningParticipantInOnboardingHackathonModal.run("I am available to join teams":params."I am available to join teams","Expertise":params."Expertise","Add or Remove Expertise":params."Add or Remove Expertise")
        SetActionInHackathonOnboardingMenu.run("Action":params."Register and add expertise Action")
        if(params."Find Teammates"){
            params."Find Teammates".split(",").eachWithIndex{ user, x ->
                def action = params."Teammates Add or Remove".split(",")
                SetReactTags.setMemberTagsWithAddRemoveWithMultipleInputFieldsLabelsSidebySide("Field Name":"Find Teammates",User:user,"Add or Remove":action[x])
            }
        }
        if(params."Invite users that are not registered for event"){
        	if(params."Invite users that are not registered for event"==true){
            	Click.run(ID:"//*[@class='f-teammates-right']/../../../../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//*[text()='Invite users that are not registered for event']/..", "Type of Click":"Move to Element")
        	} else if(params."Invite users that are not registered for event"==false){
            	Click.run(ID:"//*[@class='f-teammates-right']/../../../../DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//*[text()='Invite users that are not registered for event']/..", "Type of Click":"Move to Element")
            }
        }   
       SetActionInHackathonOnboardingMenu.run("Action":params."Action on Add teammates to your project") 
       SetText.run(ID:"//*[contains(@class,'f-teamname-input')]",Text:params."Team Name")
       SetActionInHackathonOnboardingMenu.run("Action":params."Give your team a name Screen Action") 
       SelectFirstFlowOptionForHackathonOnboarding.run("Flow Option Title":params."Get Started Screen Menu") 
       SetActionInHackathonOnboardingMenu.run("Action":params."Action on Get Started with Screen")  
       SetActionInHackathonOnboardingMenu.run("Action":params."Action on Time to submit your project...")         
        if(params."Wait for loading to disappear"==true){
            (new WebDriverWait(Browser.Driver,180)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='f-loading-bar']")))
        }
    }
}