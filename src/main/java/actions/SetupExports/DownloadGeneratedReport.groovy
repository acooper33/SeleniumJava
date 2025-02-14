package actions.SetupExports;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.ExplicitWait


class DownloadGeneratedReport{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Exports",Section:params."Section")
        ExplicitWait.run(ID:"//*[@id='generated-report-list']/A[.//*[contains(@class,'report-name') and starts-with(text(),'${params."Report Name Starts with"}')] and contains(@href,'download')][${params."Instance"}]") 
        //SetupCommon.NavigateTab(Tab:"Exports",Section:"Submissions")
        Click.run(ID:"//*[@id='generated-report-list']/A[.//*[contains(@class,'report-name') and starts-with(text(),'${params."Report Name Starts with"}')] and contains(@href,'download')][${params."Instance"}]")
        sleep(8000)
    }
}