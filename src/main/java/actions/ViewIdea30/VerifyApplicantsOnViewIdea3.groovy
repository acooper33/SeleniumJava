package actions.ViewIdea30;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.ViewIdea30.SetTabinViewIdea3
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import actions.selenium.Browser
import actions.selenium.utils.Elements
import actions.selenium.utils.VerifyMatchingItems

class VerifyApplicantsOnViewIdea3{
    public void run(def params){
        def verify = [:]
        verify.IDChildren = []
        SetTabinViewIdea3.run(Tab:"Applicants")
        sleep(500)
        if(params."Applicant's Username"){
            verify.ID = "//*[contains(@class,'fractal-widget-gigApplicants')]/DIV[@class='f-gig-applicants-item']//A[text()='${params."Applicant's Username"}' and contains(@class,'user-name')]"
        }
        if(params."Applicant's Email"){
            verify.IDChildren << "./../A[@class='f-gig-applicant-email' and text()='${params."Applicant's Email"}']"
        }
        if(params."Applicant's Expertise"){
            if(params."Number of Matches"!="0"){
                WebElement expertiseText = Elements.find(ID:verify.ID+"/../../../..//SPAN[@class='f-gig-applicant-expertise']",Browser.Driver)
                println("Applicants xpath: ${verify.ID}/../../../..//SPAN[@class='f-gig-applicant-expertise']")
                println("Applicants expertise: ${expertiseText.getText()}")
                String[] actualExpertise = expertiseText.getText().replaceAll('\\s+',"").split(',')
                String unexpectedExpertise = VerifyMatchingItems.run(expected:params."Applicant's Expertise".replaceAll('\\s+',"").split(","), actual:actualExpertise, contains:false)
                assert unexpectedExpertise==null, "Error - Unxpected Expertise: ${unexpectedExpertise}"		
				//assert (expertiseText.getText().replaceAll('\\s+',"").equals(params."Applicant's Expertise".replaceAll("\\s+",""))), "Error - Unexpected Exprtise: ${expertiseText.getText().replaceAll('\\s+',"")}"
            }
        }
        if(params."Applicant's Message"){
            verify.IDChildren << "./../../../..//DIV[@class='f-gig-applicant-full-body']/*[@class='f-gig-applicant-message' and starts-with(text(),'${params."Applicant's Message"}')]"
        }
        if(params."Make Decision, Accepted or Rejected"=="Make Decision"){
            verify.IDChildren << "./../../../..//DIV[@class='f-gig-applicant-right-body']/DIV[@class='f-gig-applicant-make-decision']/A[starts-with(.,'Accept') or starts-with(.,'Reject')]"
        }else if (params."Make Decision, Accepted or Rejected"!=null){
            String xpathExpression = verify.ID+"/../../../..//DIV[@class='f-gig-applicant-right-body']/DIV[@class='f-gig-applicant-make-decision']/DIV/SPAN[starts-with(@class,'f-gig-applicant')]"
            WebElement element = Browser.Driver.findElement(By.xpath(xpathExpression));            
            if(params."Make Decision, Accepted or Rejected".contains("today")){
            	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String todayDate = dateFormat.format(new Date());
				params."Make Decision, Accepted or Rejected" = params."Make Decision, Accepted or Rejected".replace("today", todayDate);
            }
            println("After replacement expected: ${params."Make Decision, Accepted or Rejected".replace(" ","")}")
            println("After actual: ${element.getText().replace(" ","")}")
            assert (element.getText().replace(" ","").contains(params."Make Decision, Accepted or Rejected".replace(" ",""))), "Error - Invalid Decision ${element.getText()}"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}