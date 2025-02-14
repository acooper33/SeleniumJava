package actions.ViewIdea30

import actions.selenium.*;

class ApplyOnViewIdea30{
    public void run(def params){
        Click.run(ID:"//*[@id='f-gig-app-btn-trigger-modal']") //works for Apply and Cancel
        def xpath = "//DIV[@class='f-modal-body']//DIV[contains(@class,'f-gig-expertise')]//../../../.."
        if(params."Message"){
            SetText.run(ID:xpath+"//textarea[@id='gig-application-message']", Text:params."Message")
        }
        if (params."Expertise"){SetReactTags.setIdeaTagsOrExpertise("Tag Name":params."Expertise", "Tag Add or Remove":params."Expertise Add or Remove", "Modal xpath":xpath)}
        if(params."Contact - Include my contact email"==true){
            Click.run(ID:"//INPUT[@id='f-gig-contact-email' and not(@checked)]/../../../..//DIV")
        }else if (params."Contact - Include my contact email"==false) {
            Click.run(ID:"//INPUT[@id='f-gig-contact-email' and @checked]/../../../..//DIV")
        }
        if(params."Action"=="Apply"){
            Click.run(ID:"//DIV[contains(@class,'f-footer')]//button[contains(@id,'f-modal-submit')]/SPAN[contains(.,'Apply') or contains(.,'Join') or contains(.,'Cancel Application')]")
        }else if(params."Action"=="Cancel"){
            Click.run(ID:"//DIV[contains(@class,'f-footer')]//button[contains(@id,'f-modal-submit')]/SPAN[contains(.,'Apply') or contains(.,'Join')]::preceding-sibling::button")
        }
    } 
}