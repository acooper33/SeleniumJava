package actions.Rules;

import actions.selenium.*

class SetActionDropdownforRules{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-canvas-card-options')]/DIV")
        sleep(2000)
        if(params."Action Menu Option"=="Change Status"){
            MouseOver.run(ID:"//*[contains(@class,'f-dropdown-options')]/LI//*[contains(text(),'${params."Action Menu Option"}')]")
            if(params."Change Status"){
                Click.run(ID:"//*[contains(@class,'f-dropdown-options-nested')]//*[text()='${params."Change Status"}']/..")   
            }
        } else {
             Click.run(ID:"//*[contains(@class,'f-dropdown-options')]/LI//*[contains(text(),'${params."Action Menu Option"}')]")           
        }
    }
}