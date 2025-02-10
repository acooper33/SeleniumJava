package actions.WebstormHomepage.HackathonOnboarding;

import actions.selenium.Click

class SetActionInHackathonOnboardingMenu{
    public static run(def params){
        
        if(params."Action"){
        	if(params."Action"!="Close"){
            		Click.run(ID:"//*[contains(@class,'f-modal-body')]//*[contains(@class,'-footer')]/BUTTON[contains(@class,'f-btn-') and .=\"${params."Action"}\"]")
        	} else {
           		Click.run(ID:"//*[contains(@class,'fractal-modal-header')]//*[contains(@data-tooltip-id,'modal-close')]") 
        	}
        }
    }
}