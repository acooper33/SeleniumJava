package actions.MTS;

import actions.selenium.*

class SetCreateMemoDropdown{
    public void run(def params){
        
        if(params."Source of Dropdown"=="Left Rail"){
            Click.run(ID:"//*[contains(@class,'f-nav-wrapper f-nav-sidebar-wrapper f-is-community')]//*[contains(@class,'f-userhome-create-memo')]//*[@data-test='f-test-dropdown']")
        } else if(params."Source of Dropdown"=="View Idea 3") {
        	Click.run(ID:"//*[contains(@class,'f-component f-idea-memo f-idea-memo-empty')]//*[@data-test='f-test-dropdown']")
        } else {
            Click.run(ID:"//*[contains(@class,'f-split-menu')]//*[@data-test='f-test-dropdown']")
        }
        Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]//*[text()='${params."Menu Option"}']")
    }
}