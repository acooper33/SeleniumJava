package actions.People;

import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SetCheckBox

class SetUserMenuInPeoplePillar{
    public void run(def params){
        
          if(params."Menu Option"){
            Click.run(ID:"//*[@data-test='f-test-user-pillar-dropdown']")
            sleep(500)
        	Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//*[text()='${params."Menu Option"}']")
        }
        
       SetCheckBox.run(ID:"//*[@id='f-delete-user-understand']",Check: params."Enable Checkbox")
        
        if(params."Action"){
            if(params.Action=="Cancel"){
            Click.run(ID:"//*[@data-test='modal-footer-cancel']")
            } else if(params.Action=="Close"){
            Click.run(ID:"//*[@data-tooltip-id='modal-close']")
            } else {
            Click.run(ID:"//*[@data-test='modal-footer-submit']/*[text()='${params."Action"}']")
            }
        }
    }
}