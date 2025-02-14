package actions.Enterprise.UserHomepage;

import actions.selenium.Click
import actions.selenium.SelectItem

class CreateSubmissionfromMyIdea{
    public void run(def params){
        
        Click.run(ID:"//*[@id='f-sparks-create-submission']")
        SelectItem.run(ID:"//*[@id='financial-comparison']","Visible Text":params."Select Initiative")
        if(params."Action"=="Save"){
            Click.run(ID:"//*[@id='create-submission-button']")
        } else { Click.run(ID:"//*[@id='create-submission-cancel']")}
    }
}