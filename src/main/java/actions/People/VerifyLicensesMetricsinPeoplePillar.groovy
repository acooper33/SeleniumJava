package actions.People;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.PeopleCommon

class VerifyLicensesMetricsinPeoplePillar{
    public void run(def params){
        
        PeopleCommon.NavigateTab(Tab:"Licenses")
        def verify = [:]
        if(params."License Type"=="Brightidea Administrator License Type"){
            verify.ID= "//*[contains(@class,'admin-license-container')]"            
        } else if(params."License Type"=="Idea Box Manager License Type"){
            verify.ID= "//*[contains(@class,'idea-box-manager-license-container')]"  
        }else if(params."License Type"=="Brightidea Moderator Licenses"){ 
            verify.ID= "//*[contains(@class,'moderator-license-container')]"
        } else {
            verify.ID= "//*[contains(@class,'whiteboard-license-container')]"
        }
        verify.IDChildren = []
        if(params."Metric Value"){verify.IDChildren << ".//*[@class='metric-box-val' and text()='${params."Metric Value"}']/following-sibling::SPAN[@class='metric-box-text' and text()='${params."Metric Text"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
        
    }
}