package actions.ActionItemsManager;
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.Exists

class SetActionsDropdownintheActionItemsManager{
    public void run(def params){

        if(params."List"!="Initiative Action Items Manager"){
         if(Exists.run(ID:"//*[@id='action_item_header_breadcrumb' and contains(text(),'My Action Items')]")>0){ 
            Click.run(ID:"//*[@id='action_item_manager']/A")
         }  
        }
        sleep(5000)
            
        if(params."Tool Type"){
            params."Select Ideas".split(",").eachWithIndex{ idea, x ->
                SetCheckBox.run(ID:"//TD[contains(@class,'title-cell') and .='${idea}']/..//TD[contains(@class,'type-cell') and .='${params."Tool Type".split(",")[x]}']/..//INPUT",Check:params.Check.split(",")[x].toBoolean())
            }
        } else if(params."Assignee"){
            params."Select Ideas".split(",").eachWithIndex{ idea, x ->
                SetCheckBox.run(ID:"//TD[contains(@class,'title-cell') and .='${idea}']/..//TD[contains(@class,'assignee-cell') and .='${params."Assignee".split(",")[x]}']/..//INPUT",Check:params.Check.split(",")[x].toBoolean())
            }
        } else {
            params."Select Ideas".split(",").eachWithIndex{ idea, x ->
                SetCheckBox.run(ID:"//TD[contains(@class,'title-cell') and .='${idea}']/..//INPUT",Check:params.Check.split(",")[x].toBoolean())
            }
        }
        Click.run(ID:"//*[@id='actions_dropdown']")
        if(params."Action"){
            if(params."Action"=="Delete"){
                Click.run(ID:"//*[@id='action-delete']")}
            else if(params."Action"=="Cancel"){Click.run(ID:"//*[@id='action-cancel']")}
            else {Click.run(ID:"//*[@id='action-reopen']")}
        }
        if(params."Sub Action") {
            if(params."Sub Action"=="Cancel") {
                Click.run(ID:"//*[@class='bimodal-footer']//*[text()='Cancel']") 
            } else if(params."Sub Action"=="Close") {Click.run(ID:"//*[@id='bimodal-close-label']")}
            else {Click.run(ID:".//*[@id='bi-modal-button']/SPAN[text()='${params."Sub Action"}']")}
        }
    }
}