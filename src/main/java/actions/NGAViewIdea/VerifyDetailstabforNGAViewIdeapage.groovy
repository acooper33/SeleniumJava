package actions.NGAViewIdea;

import actions.common.NGAViewIdeaCommon
import actions.selenium.*

class VerifyDetailstabforNGAViewIdeapage{
    public void run(def params){
        NGAViewIdeaCommon.NavigateTab(Tab:"Details")
        
        sleep(5000)
        
        VerifyText.run(ID:"//*[@id='details-container-1']/UL[2]/LI[1]",Text:params."Points")
        VerifyText.run(ID:"//*[@id='details-container-1']/UL[2]/LI[2]",Text:params."Votes")
        VerifyText.run(ID:"//*[@id='details-container-1']/UL[2]/LI[3]",Text:params."Unique Views")
        VerifyText.run(ID:"//*[@id='details-container-2']/UL[2]/LI[1]",Text:params."Total Views")
        VerifyText.run(ID:"//*[@id='details-container-2']/UL[2]/LI[2]",Text:params."Comments")
        VerifyText.run(ID:"//*[@id='details-container-2']/UL[2]/LI[3]",Text:params."Favorited")
    }
}