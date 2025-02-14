package actions.SetupEnterpriseExports;

import actions.common.SetupCommon
import actions.selenium.Click


class DownloadGeneratedReportEnterpriseExports{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Exports",Section:params."Section")
        Click.run(ID:"//*[@id='generated-report-list']/A[.//*[contains(@class,'report-name') and starts-with(text(),'${params."Report Name Starts with"}')] and contains(@href,'download')][${params."Instance"}]")
        sleep(5000)
    }
}