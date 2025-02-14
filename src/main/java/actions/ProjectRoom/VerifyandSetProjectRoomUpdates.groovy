package actions.ProjectRoom;

import actions.selenium.Click
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import actions.selenium.Exists
import actions.selenium.MouseOver
import actions.selenium.SetFocus
class VerifyandSetProjectRoomUpdates{
    public void run(def params){
        
        if(params."Project Description"){
            assert Exists.run(ID:"//*[contains(@class,'f-rooms-description-container')]//*[text()='${params."Project Description"}']")==1, "Error - 'Incorrect project description"
        }
        if(params."Click on Settings under Description?"==true){
            Click.run(ID:"//*[contains(@class,'f-rooms-description-container')]//button")
        }
        if(params."All Project Room Members"){
            params."All Project Room Members".split(",").eachWithIndex{ member, x ->
            def shouldMemberBeDisplayed = params."Should Project Room Member be Displayed".split(",")
               	if(shouldMemberBeDisplayed[x]=="True"){
                     Click.run(ID:"//*[contains(@data-tooltip-content,'Update project description in Room Settings')]")
//                     SetFocus.run(ID:"//*[contains(@class,'team-member-container') and text()='${member}']")
//                     MouseOver.run(ID:"//*[contains(@class,'team-member-container') and text()='${member}']")
                     assert Exists.run(ID:"//*[contains(@class,'team-member-container') and text()='${member}']")==1, "Error - ${member} Member not displayed"
                } else {
                    assert Exists.run(ID:"//*[contains(@class,'team-member-container') and text()='${member}']")==0, "Error - ${member} Member displayed when it should be not be displayed"
                }               
                if(params."Profile Picture Displayed for Members"){
                    def shouldProfilePictureBeDisplayed = params."Profile Picture Displayed for Members".split(",")
                    sleep(2000)
                    if(shouldProfilePictureBeDisplayed[x]=="True"){
                         assert Exists.run(ID:"//*[contains(@class,'team-member-container') and text()='${member}']//*[contains(@class,'member-img')]")==1, "Error - Member picture not displayed for ${member}"   
                         } else {
                         assert Exists.run(ID:"//*[contains(@class,'team-member-container') and text()='${member}']//*[contains(@class,'member-initial')]")==1, "Error - Member icon not displayed for ${member}"   
                         }
                     }
                }
        }            
        if(params."Project Room Owner Name"){
            assert Exists.run(ID:"//*[contains(@class,'team-member-container') and text()='${params."Project Room Owner Name"}'][1]//*[contains(@class,'fa fa-key team-owner')]")==1, "Error - Incorrect owner name"
        }
         if(params."Click on Share Project Room"==true){
            Click.run(ID:"//*[contains(@class,'f-rooms-updates-header')]//BUTTON[.='Share Project Room']")
        }
    }
}