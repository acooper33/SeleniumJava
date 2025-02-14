package actions.Memo;

import actions.selenium.Click

class SetReviewResultsModalHeaderbuttons{
    public void run(def params){
        
         switch(params."Action"){
            case "Previous Round":
            	Click.run(ID:"//*[@class='f-title-container']//*[@data-tooltip-content='Previous Round']")
            	break
            case "Next Round":
            	Click.run(ID:"//*[@class='f-title-container']//*[@data-tooltip-content='Next Round']")
            	break
             case "Close":
            	Click.run(ID:"//*[contains(@class,'fractal-modal-header')]//*[@class='close-button']")
            	break
         }        
    }
}