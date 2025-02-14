package actions.Enterprise.UserHomepage;

import actions.selenium.*

class SetSubmissionsfromMyIdea{
    public void run(def params){

        Click.run(ID:"//*[@id='f-sparks-create-submission']")
        Click.run(ID:"//*[contains(@class,'f-combobox-dropdown-button')]")
        sleep(2000)
        Click.run(ID:"//*[@id='f-combobox-list']")
        Click.run(ID:"//*[@id='f-combobox-list']//*[text()='${params."Select Initiative"}']", "Type of Click":"Javascript")
        if(params.Action=="Create Submission"){
            Click.run(ID:"//*[@id='create-submission-button']")
        } else {Click.run(ID:"//*[@id='create-submission-cancel']")}

    }
}