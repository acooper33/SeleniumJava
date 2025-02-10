package actions.WebstormHomepage;

import actions.selenium.Click
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.text.SimpleDateFormat;
import java.util.Date;
import actions.selenium.Browser
import actions.selenium.SetText
import actions.selenium.SetReactTags
import actions.WebstormHomepage.HackathonOnboarding.SetExpertiseforJoiningParticipantInOnboardingHackathonModal
import actions.WebstormHomepage.HackathonOnboarding.SetActionInHackathonOnboardingMenu

class SetJoinEventHackApp{
    public void run(def params){
        
        SetExpertiseforJoiningParticipantInOnboardingHackathonModal.run("I am available to join teams":params."I am available to join teams","Expertise":params."Expertise","Add or Remove Expertise":params."Add or Remove Expertise")
        SetActionInHackathonOnboardingMenu.run("Action":params."Action on Register and add expertise Screen")
        if(params."Action on Update or Leave Event"=="Join Event" | params."Action on Update or Leave Event"=="Update"){Click.run(ID:"//*[@id='f-modal-submit']")}
        else if (params."Action on Update or Leave Event"=="Leave Event") Click.run(ID:"//*[contains(@class,'f-footer')]//BUTTON[contains(@class,'f-btn-leave')]")
        sleep(1000)
    }
}