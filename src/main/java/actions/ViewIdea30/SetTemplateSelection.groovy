package actions.ViewIdea30;

import actions.selenium.Click

class SetTemplateSelection{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-admin-icon']")
        Click.run(ID:"//*[@class='f-widget-admin-link']")
        Click.run(ID:"//*[contains(@class,'f-template-modal-column-radios')]//*[@aria-label='${params."Template"}']/DIV[1]")
        
        if(params."Action"){
            if(params."Action" == "Change Template") {
               Click.run(ID:"//*[@data-test='modal-footer-submit']") 
            } else {Click.run(ID:"//*[@data-test='modal-footer-cancel']")}
        }
        
    }
}