package actions.ViewIdea.GigEnhancementsApplyApplicants;

import actions.common.ViewIdeaCommon
import actions.selenium.*

class AcceptApplicantinViewIdea{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Applicants")
        if(params."Applicant's Username"){
            Click.run(ID:"//*[contains(@class,'fractal-widget-gigApplicants')]//DIV[@class='f-gig-app-tab-applicant-item']//A[text()='${params."Applicant's Username"}']/../..//A[.='${params."Accept or Decline"}']")
		}
        if(params."Message (optional)"){
            SetText.run(ID:"//TEXTAREA[@id='f-gig-app-decide-modal-contact-msg']", Text:params."Message (optional)")
        }
        if(params."Action"=="Accept" || params."Action"=="Decline"){
            Click.run(ID:"//*[@data-test='modal-footer-submit']")
        }else if (params."Action"=="Cancel"){
            Click.run(ID:"//*[@data-test='modal-footer-cancel']")
        }
        //this comment was added at 5pm on November 13!
    }
}