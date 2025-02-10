package actions.PipelineStepsView;

import actions.selenium.Click

class SetQuickAddDropdownforNonMemo{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-quick-add-wrapper')]//*[@data-test='f-test-dropdown']")
        Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//*[text()='${params."Option"}']")

    }
}