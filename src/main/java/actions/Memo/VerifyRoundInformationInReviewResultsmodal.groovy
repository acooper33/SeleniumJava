package actions.Memo;

import actions.selenium.Exists
import actions.selenium.Click
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class VerifyRoundInformationInReviewResultsmodal{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-tab')]//*[text()='Round Information']")
        if(params."Progress Bar"){
            assert Exists.run(ID:"//*[@class='f-row-title' and text()='Progress']/..//*[contains(@class,'fractal-progress-bar')]//*[contains(@style,'${params."Progress Bar"}')]")==1, "Error - Incorrect progress bar width"
        }
        if(params."Completed"){
            assert Exists.run(ID:"//*[@class='f-row-title' and text()='Progress']/..//*[.='${params."Completed"}']")==1, "Error - completed count"
        }
        if(params."Due in"==true){
             WebElement element = Elements.find(ID:"//*[@class='f-progress-text']/SPAN",Browser.Driver)
        	def dueDateValue = element.getText()
			// Check if it's not empty and not zero
            if (dueDateValue && dueDateValue != "0") {
                assert Exists.run(ID:"//*[@class='f-progress-text']//*[contains(.,'${dueDateValue}')]")==1, "Error - Incorrect due in days"
            }
        } 
        if(params."Reviewers"){
            params."Reviewers".split(",").eachWithIndex{ reviewer, x -> 
                def score = params."Score".split(",")
                assert Exists.run(ID:"//*[@class='f-row-title f-reviewers-title']/..//*[@class='f-reviewer-info']//*[text()='${reviewer}']/..//*[@class='f-reviewer-score' and .='${score[x]}']")==1, "Incorrect score for the reviewer"
            }
        }
        if(params."Assigned by"){
            assert Exists.run(ID:"//*[@class='f-row-title' and text()='Assigned by']/..//*[text()='${params."Assigned by"}']")==1, "Error - Incorrect Assigned by"
        }
        if(params."Round name"){
            assert Exists.run(ID:"//*[@class='f-row-title' and text()='Round name']/..//*[text()='${params."Round name"}']")==1, "Error - Incorrect round name"
        }
         if(params."Template"){
            assert Exists.run(ID:"//*[@class='f-row-title' and text()='Template']/..//*[text()='${params."Template"}']")==1, "Error - Incorrect template"
        }

        if(params."Assign date"){
            assert Exists.run(ID:"//*[@class='f-row-title' and text()='Assign date']/..//*[.='${params."Assign date"}']")==1, "Error - Incorrect assign date"
        } 
        
        if(params."Click on Remind"){
            Click.run(ID:"//*[@class='f-results-info-container']//*[contains(@class,'f-btn-xs f-btn-standard f-remind-kpi')]")
            sleep(2000)
            Click.run(ID:"//*[@class='f-remind-popup-container']//*[contains(@class,'f-btn-xs f-btn-primary')]")
        }
    }
}