package actions.WebstormHomepage.HackathonOnboarding;

import actions.selenium.SetReactTags
import actions.selenium.Click

class SetExpertiseforJoiningParticipantInOnboardingHackathonModal{
    public static void run(def params){
        
        if(params."I am available to join teams"){
        	if(params."I am available to join teams"==true){
            	Click.run(ID:"//*[@id='f-check-availibility']/../../../../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//*[text()='I am available to join teams']/..", "Type of Click":"Move to Element")
        	} else if(params."I am available to join teams"==false){
            	Click.run(ID:"//*[@id='f-check-availibility']/../../../../DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//*[text()='I am available to join teams']/..", "Type of Click":"Move to Element")
            }
        }
        if (params."Expertise"){SetReactTags.setIdeaTagsOrExpertise("Tag Name":params."Expertise", "Tag Add or Remove":params."Add or Remove Expertise")}
        
    }
}