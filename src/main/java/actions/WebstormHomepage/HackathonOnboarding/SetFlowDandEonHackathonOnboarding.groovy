package actions.WebstormHomepage.HackathonOnboarding;

import actions.WebstormHomepage.HackathonOnboarding.SelectFirstFlowOptionForHackathonOnboarding
import actions.WebstormHomepage.HackathonOnboarding.SetActionInHackathonOnboardingMenu
import actions.WebstormHomepage.HackathonOnboarding.SetExpertiseforJoiningParticipantInOnboardingHackathonModal

class SetFlowDandEonHackathonOnboarding{
    public void run(def params){
        
       SelectFirstFlowOptionForHackathonOnboarding.run("Flow Option Title":params."Flow Option Title")
       SetActionInHackathonOnboardingMenu.run("Action":params."Action on Get Started Screen")
       SetExpertiseforJoiningParticipantInOnboardingHackathonModal.run("I am available to join teams":params."I am available to join teams","Expertise":params."Expertise","Add or Remove Expertise":params."Add or Remove Expertise")
       SetActionInHackathonOnboardingMenu.run("Action":params."Register and add expertise Action")
       SelectFirstFlowOptionForHackathonOnboarding.run("Flow Option Title":params."Choose the best option for you") 
       SetActionInHackathonOnboardingMenu.run("Action":params."Action on Choose the best option for you")  
    }
}