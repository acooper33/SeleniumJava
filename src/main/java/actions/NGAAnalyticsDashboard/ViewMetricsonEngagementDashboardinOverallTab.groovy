package actions.NGAAnalyticsDashboard;

import actions.selenium.utils.VerifyNumberOfMatches

class ViewMetricsonEngagementDashboardinOverallTab{
    public void run(def params){

        def verify = [:]
        verify.ID = "//*[@id='overall-metrics']//*[@class='metrics-label' and text()='${params."Metric Label"}']"
        verify.IDChildren = []
        
		if(params."Count" && params."Metric Label".contains("Avg.")){verify.IDChildren << "./../DIV[translate(text(), '0123456789', '') != text()]"}
        else if(params."Count"){verify.IDChildren << "./../DIV[text()='${params."Count"}']"}
        
        if(params."Placement Number") {
            verify.ID="//TD[${params."Placement Number"}]/*[@class='metrics-label' and text()='${params."Metric Label"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}