package actions.ViewIdea30;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class SetandVerifyProjectRoomInViewIdea3{
    public void run(def params){
        
        def verify = [:]
        if(params."Placement Number") {verify.ID = "//*[contains(@class,'f-project-room-widget')]//*[@class='f-project-room'][${params."Placement Number"}]//*[text()='${params."Project Room Title"}']"}
        else {verify.ID = "//*[contains(@class,'f-project-room-widget')]//*[@class='f-project-room']//*[text()='${params."Project Room Title"}']"}
          
        verify.IDChildren = []        
        if(params."Project Room Icon Color"){verify.IDChildren << "./../..//*[contains(@class,'f-project-room-icon') and contains(@style,'${params."Project Room Icon Color"}')]"}    	
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
        if(params."Access the Project Room"==true){
            Click.run(ID:verify.ID)
        }
        if(params."Remove Project Room"==true){
            Click.run(ID:verify.ID+"/../..//*[contains(@class,'f-project-room-icon')]", "Type of Click":"Move to Element")
            if(params."Remove Project Room Action"){
            	if(params."Remove Project Room Action"=="Remove"){
                	Click.run(ID:"//BUTTON[@id='clickToConfirmOkButton']")
            	} else if(params."Remove Project Room Action"=="Cancel"){
                	Click.run(ID:"//BUTTON[@id='clickToConfirmCancelButton']")
                }
            }
        }
    }
}