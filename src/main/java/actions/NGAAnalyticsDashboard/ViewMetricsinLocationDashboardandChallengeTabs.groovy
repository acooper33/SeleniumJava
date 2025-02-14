package actions.NGAAnalyticsDashboard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Exists
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class ViewMetricsinLocationDashboardandChallengeTabs{
    public void run(def params){

        def verify = [:]
        verify.IDChildren = []
        //if verifying community dashboard
        if(Exists.run(ID:"//*[contains(@id,'metrics-table')]//*[text()='${params."Metric Label"}']")>0){
            println("@id='analytics-grid-metrics-table FOUND")
            verify.ID = "//*[contains(@id,'metrics-table')]/TBODY/TR/TD/*[normalize-space(.)='${params."Metric Label"}']"
            if(params."Value" && params."Metric Label".contains("Avg. Per Day")){verify.IDChildren << "./../DIV[translate(text(), '0123456789', '') != text()]"}
            else if(params."Value"){verify.IDChildren << "./../DIV[text()='${params."Value"}']"}
            if(params."Placement Number") {
                verify.ID = "//*[contains(@id,'metrics-table')]/TBODY/TR/TD[${params."Placement Number"}]/*[normalize-space(.)='${params."Metric Label"}']"
            	VerifyNumberOfMatches.run(verify)
        	}
        	else{
            	if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            	VerifyNumberOfMatches.run(verify)        
        	}
        //if verifying dashboard on teamsite
        }else{
            println("We are in teamsite dashboard part of the code")
            verify.ID = "//*[@class='f-summary-metrics-container']/DIV[@class='f-summary-metric']/SPAN[@class='f-summary-metric-title' and normalize-space(.)='${params."Metric Label"}']"
            if(params."Value" && params."Metric Label".contains("Avg. Per Day")){verify.IDChildren << "./../SPAN[@class='f-summary-metric-value' and matches(text(), '[0-9]+')]"}
            else if(params."Value"){verify.IDChildren << "./../SPAN[@class='f-summary-metric-value' and text()='${params."Value"}']"}
            if(params."Placement Number") {
            	verify.ID="//*[@class='f-summary-metrics-container']/DIV[@class='f-summary-metric' and position()=${params."Placement Number"}]/SPAN[@class='f-summary-metric-title' and normalize-space(.)='${params."Metric Label"}']"
            	VerifyNumberOfMatches.run(verify)
        	}
        	else{
            	if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            	VerifyNumberOfMatches.run(verify)        
        	}
        }
    }
}