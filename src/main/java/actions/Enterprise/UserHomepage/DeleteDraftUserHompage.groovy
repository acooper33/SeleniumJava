package actions.Enterprise.UserHomepage;

import actions.selenium.Click

class DeleteDraftUserHompage{
    public void run(def params){
        
    	Click.run(ID:"//*[contains(@class,'fractal-secondary-ideas-view-grid')]/*[contains(@class,'ideaboard-card') and @data-title='${params."Draft Name"}']//DIV[@class='f-idea-scores']//BUTTON[contains(.,'Delete')]")
        Click.run(ID:"//*[@class='wrapper-inner']//*[@class='fractal-modal-footer ']/BUTTON[.='${params.Action}']")    
    	sleep(3000)
    }    
}