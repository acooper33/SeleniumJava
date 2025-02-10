package actions.WebstormHomepage.HackathonOnboarding;

import actions.selenium.Click

class SelectFirstFlowOptionForHackathonOnboarding{
    public static void run(def params){
        
        if(params."Flow Option Title"){
             Click.run(ID:"//*[contains(@class,'f-cards')]//*[contains(@class,'f-card-title') and text()='${params."Flow Option Title"}']")
        }       
    }
}