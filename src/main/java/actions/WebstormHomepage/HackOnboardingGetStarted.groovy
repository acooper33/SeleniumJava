package actions.WebstormHomepage;

import actions.selenium.Click

class HackOnboardingGetStarted{
    public void run(def params){
        Click.run(ID:"//BUTTON[contains(@class,'join-event-btn') and text()='Join Event']") 
    }
}