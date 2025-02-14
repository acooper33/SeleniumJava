package actions.Enterprise.UserHomepage;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.GetText
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class VerifyUserMetricsonUserHomepage{
    public void run(def params){
        if(params."Ideas - Expected Value"){
            assert GetText.run(ID:"//UL[@class='f-kpis']/LI//*[@data-test='KeyPerformanceIndexValueFor-MY_IDEAS']")==params."Ideas - Expected Value", "Error - Unexpected Ideas Value"
            
        }
         if(params."Submissions - Expected Value"){
            assert GetText.run(ID:"//UL[@class='f-kpis']/LI//*[@data-test='KeyPerformanceIndexValueFor-SUBMISSIONS']")==params."Submissions - Expected Value", "Error - Unexpected Submissions Value"
            
        }
        if(params."Submissions - Exp Value More Than (for import auto bug)"){
            def textValue = GetText.run(ID:"//UL[@class='f-kpis']/LI//*[@data-test='KeyPerformanceIndexValueFor-SUBMISSIONS']").toInteger()
            assert textValue>=params."Submissions - Exp Value More Than (for import auto bug)".toInteger(), "Error - Unexpected Submissions Value"
        }
        if(params."Activities - Expected Value"){
        	assert GetText.run(ID:"//UL[@class='f-kpis']/LI//*[@data-test='KeyPerformanceIndexValueFor-ACTIVITIES']")==params."Activities - Expected Value", "Error - Unexpected Activities Value"

        }
        if(params."Submission Views - Expected Value"){
        	assert GetText.run(ID:"//UL[@class='f-kpis']/LI//*[@data-test='KeyPerformanceIndexValueFor-SUBMISSION_VIEWS']")==params."Submission Views - Expected Value", "Error - Unexpected Submission Views"

        }
        if(params."Collaborators - Expected Value"){
        	assert GetText.run(ID:"//UL[@class='f-kpis']/LI//*[@data-test='KeyPerformanceIndexValueFor-COLLABORATORS']")==params."Collaborators - Expected Value", "Error - Unexpected Collaborators"

        }
        if(params."Projects - Expected Value"){
        	assert GetText.run(ID:"//UL[@class='f-kpis']/LI//*[@data-test='KeyPerformanceIndexValueFor-PROJECTS']")==params."Projects - Expected Value", "Error - Unexpected Projects"

        }
        if(params."Business Impact - Expected Value"){
            assert GetText.run(ID:"//UL[@class='f-kpis']/LI//*[@data-test='KeyPerformanceIndexValueFor-BUSINESS_IMPACT']").equalsIgnoreCase(params."Business Impact - Expected Value"), "Error - Unexpected Business Impact"

        }
    }
}