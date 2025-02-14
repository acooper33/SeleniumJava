package actions.WebstormHomepage.HackathonOnboarding


import actions.selenium.Browser
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

class SetFlowAforHackathonOnboarding{
    public void run(def params){
        
        SelectFirstFlowOptionForHackathonOnboarding.run("Flow Option Title":"I have one or more ideas.")
        SetActionInHackathonOnboardingMenu.run("Action":params."Action on Get Started Screen")
        SetExpertiseforJoiningParticipantInOnboardingHackathonModal.run("I am available to join teams":params."I am available to join teams","Expertise":params."Expertise","Add or Remove Expertise":params."Add or Remove Expertise")
        SetActionInHackathonOnboardingMenu.run("Action":params."Register and add expertise Action")
        SetActionInHackathonOnboardingMenu.run("Action":params."Action on Time to submit your project")
        if(params."Wait for Post Idea Page to Load"==true){
            (new WebDriverWait(Browser.Driver,100)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='f-loading-bar']")))
        }
    }
}