package actions.ViewIdea.GigEnhancementsApplyApplicants;

import actions.selenium.utils.Elements
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Browser
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.GetText
import actions.common.ViewIdeaCommon
import org.openqa.selenium.WebElement
import actions.selenium.Browser

class VerifyApplicantsTabinViewIdea{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Applicants")
		def applicants = Elements.findAll(ID:"//*[contains(@class,'fractal-widget-gigApplicants')]//DIV[@class='f-gig-app-tab-applicant-item']", Browser.Driver)
        if(params."Number of Applicants"){
            assert Exists.run(ID:"//*[@id='view-idea-horizontal-tabs']/A[@id='applicants-tab' and text()='Applicants (${params."Number of Applicants"})']")==1, "Error - Tab Header is incorrect"
           	assert applicants.size()==params."Number of Applicants".toInteger(), "Error - Unexpected Number of Applicants"
        }
        if(params."Applicant's Username"){
            def verify = [:]
            verify.ID="//*[contains(@class,'fractal-widget-gigApplicants')]//DIV[@class='f-gig-app-tab-applicant-item']//A[text()='${params."Applicant's Username"}']"
            verify.IDChildren = []
            if(params."Applied"){verify.IDChildren << "./../../../*[@class='f-gig-app-tab-applicant-date-submitted']/span[text()='${params."Applied"}']"}
            if(params."Email"){verify.IDChildren << "./../../../*[@class='f-gig-app-tab-applicant-email']/A[text()='${params."Email"}']"}
            if(params."Message"){verify.IDChildren << "./../../../*[@class='f-gig-app-tab-applicant-message' and text()='${params."Message"}']"}
            if(params."Expertise"){
                params."Expertise".split(",").each{expertise ->
                    verify.IDChildren << "./../../..//*[@class='f-gig-app-tab-applicant-expertise' and contains(normalize-space(),'${expertise}')]"
                }
            }
            if(params."Status"){verify.IDChildren << "./../../*[@class='f-gig-app-tab-applicant-make-decision']//*[text()='${params."Status"}']"}
            
            verify."Number of Matches" = 1
            VerifyNumberOfMatches.run(verify) 
        }
    }
}