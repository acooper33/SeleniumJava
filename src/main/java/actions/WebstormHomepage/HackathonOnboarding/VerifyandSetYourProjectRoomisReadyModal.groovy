package actions.WebstormHomepage.HackathonOnboarding;

import actions.WebstormHomepage.HackathonOnboarding.SetActionInHackathonOnboardingMenu
import actions.selenium.Exists
import actions.selenium.Click

class VerifyandSetYourProjectRoomisReadyModal{
    public void run(def params){
        
        if(params."Click on KBA link"==true){
            Click.run(ID:"//*[contains(@class,'f-split-modal')]//A")
        }
        if(params."Verify the Text"==true){
            assert Exists.run(ID:"//*[@class='f-modal-body']//*[contains(@class,'f-split-modal') and contains(.,'Use this space to collaborate with your team on your Hackathon idea(s).Use our Whiteboard tool to brainstorm, and iteratively work through concepts.Track upcoming to-dos and action items with our Tasks functionality.Organize everything in one place, pulling in additional files, organize into folders, etc.When your team is ready, click submit to automatically pull in the team members and submit your project.')]")==1, "Error - Incorrect text on the modal" 
        }
        SetActionInHackathonOnboardingMenu.run("Action":params."Action on the Modal")
    }
}