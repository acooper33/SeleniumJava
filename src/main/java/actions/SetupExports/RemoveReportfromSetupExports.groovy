package actions.SetupExports;

import actions.common.SetupCommon
import actions.selenium.Exists
import actions.selenium.Click

class RemoveReportfromSetupExports{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Exports",Section:params."Section")
        //SetupCommon.NavigateTab(Tab:"Exports",Section:"Submissions")
        if(params.Instance){
         	Click.run(ID:"//*[@id='generated-report-list']/A[@class='report-list-item'][${params.Instance}]//*[contains(@class, 'report-name') and starts-with(text(),'${params."Report Name Starts with"}')]/../..//*[@class='report-delete']")   
        }
        //confirm remove report
        if (params."Action"=="Delete Report"){
        	Click.run(ID:"//button[@id='f-modal-submit']//span[contains(text(),'Delete Report')]")
            sleep(5000)
    	}
        //cancel remove report
        if (params."Action"=="Cancel"){
        	Click.run(ID:"//*[contains(@class, 'bimodal-secondary') and contains(text(), 'Cancel')]")
            sleep(5000)
    	}
   	}
}