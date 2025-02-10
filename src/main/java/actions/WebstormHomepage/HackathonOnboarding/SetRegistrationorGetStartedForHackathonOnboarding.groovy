package actions.WebstormHomepage.HackathonOnboarding;

import actions.selenium.*

class SetRegistrationorGetStartedForHackathonOnboarding{
    public void run(def params){
        
        def xpath
        switch(params."Area Accessing The Menu From"){
            case "Widget":
                xpath = "//*[@id='join_event_widget']"
            	break
             case "Homepage Header":
                xpath = "//*[contains(@class,'f-homepage-hero')]/*[@class='side']"
            	break
            case "HTS Left Rail":
                xpath = "//*[contains(@class,'f-top-left-submit f-hack-onboard')]"
            	break
            case "Participants Page":
                xpath = "//*[contains(@class,'f-participant')]"
            	break
        }
        
        if(params."Onboarding Menu Option"){
            if(params."Onboarding Menu Option".contains("Registration") || params."Onboarding Menu Option"=="Get Started"){
                Click.run(ID:xpath+"//button[normalize-space()='${params."Onboarding Menu Option"}']")
            } else {
                Click.run(ID:xpath+"//*[contains(@class,'f-split-onboarding-btn')]//*[@data-test='f-test-dropdown']")
            }
        }
        if(params."Onboarding Menu Dropdown Option"){
            Click.run(ID:xpath+"//*[contains(@style,'display: block')]//*[text()='${params."Onboarding Menu Dropdown Option"}']") 
        }        
    }
}