package actions.ViewIdea30;

import actions.selenium.Click

class SetDeleteIdeainViewIdea3Page{
    public void run(def params){
        
        if(params."Action"=="Delete"){
            Click.run(ID:"//*[@id='clickToConfirmOkButton']")
        } else if(params."Action"=="Close"){
            Click.run(ID:"//*[contains(@class,'f-btn-subtle f-close-button')]")
        } else {
            Click.run(ID:"//*[@id='clickToConfirmCancelButton']")
        }
    }
}