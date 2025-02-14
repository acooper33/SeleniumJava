package actions.Memo;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class VerifyReviewKPIinthereviewmodal{
    public void run(def params){
        
        def verify = [:]
        verify.ID = "//*[@class='f-kpi-title' and text()='${params."Title"}']"
        verify.IDChildren = []
        if(params."Value"==true){
             WebElement element = Elements.find(ID:verify.ID+"/..//*[contains(@class,'f-kpi-value')]",Browser.Driver)
        	def dueDateValue = element.getText()
            println(dueDateValue)
			// Check if it's not empty and not zero
            if (dueDateValue && dueDateValue != "0") {
                verify.IDChildren << "./..//*[contains(@class,'f-kpi-value') and .='${dueDateValue}']"
            }
        }            
        if(params."Placement Number") {
            verify.ID="//*[contains(@class,'f-kpi-box')][${params."Placement Number"}]//*[@class='f-kpi-title' and text()='${params."Title"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }        
    }
}