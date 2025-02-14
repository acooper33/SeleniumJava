package actions.NGAAnalyticsDashboard;

import actions.selenium.*
    
class NavigateToAnalyticsDashboardandTab{
    public void run(def params){
        if(params."Dashboard"){
            if(Exists.run(ID:"//*[contains(@class,'user-homepage')]")>0){
                Click.run(ID:"//*[contains(@class,'f-analytics-dashboards-lander')]//*[contains(@class,'f-title') and contains(.,'${params."Dashboard"}')]")
            } else {
                Click.run(ID:"//*[@class='analytic-action list-item-action']/button[contains(text(),'${params."Dashboard"}')]","Type of Click":"Javascript")
            }
        }
        if(params."Tab"){
            if(Exists.run(ID:"//*[contains(@class,'user-homepage')]")>0){
            	//Click.run(ID:"//*[contains(@class,'f-dashboards-header')]/..//*[contains(@class,'f-tabs-header')]//BUTTON[contains(@class,'f-tab') and contains(.,'${params."Tab"}')]")
            	Click.run(ID:"//*[contains(@class,'f-userhome-main')]//*[contains(@class,'dashboards-main')]//*[contains(@class,'f-tabs-header')]//BUTTON[contains(@class,'f-tab') and contains(.,'${params."Tab"}')]")
            } else {
                Click.run(ID:"//*[contains(@id,'analytics')]/LI[text()='${params."Tab"}']")
            }
        }
    }
}
