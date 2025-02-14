package actions.ViewIdea30;

import actions.ViewIdea30.SetTabinViewIdea3
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class AcceptDeclineApplicantSendMessageonViewIdea3{
    public void run(def params){
        SetTabinViewIdea3.run(Tab:"Applicants")
        if(params."Applicant's Username"){
           Click.run(ID:"//*[contains(@class,'fractal-widget-gigApplicants')]/DIV[@class='f-gig-applicants-item']//A[text()='${params."Applicant's Username"}' and contains(@class,'user-name')]/../../../..//DIV[@class='f-gig-applicant-right-body']//A[contains(.,'${params."Accept or Reject or Send Message"}')]")
        }
        if(params."Message (optional)"){
            SetText.run(ID:"//TEXTAREA[@id='f-gig-app-decide-modal-contact-msg']", Text:params."Message (optional)")
        }
        if(params."Action"=="Accept" || params."Action"=="Reject"){
            Click.run(ID:"//*[@class='f-modal-body']/DIV[@class='f-gig-app-decide-modal']/../..//*[@data-test='modal-footer-submit']")
        }else if (params."Action"=="Cancel"){
            Click.run(ID:"//*[@class='f-modal-body']/DIV[@class='f-gig-app-decide-modal']/../..//*[@data-test='modal-footer-cancel']")
        }
    }
}