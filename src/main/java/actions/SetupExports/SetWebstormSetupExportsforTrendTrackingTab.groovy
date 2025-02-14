package actions.SetupExports;

import actions.common.SetupCommon
import actions.selenium.SelectItem
import actions.selenium.SetCheckBox
import actions.selenium.Click


class SetWebstormSetupExportsforTrendTrackingTab{
    public void run(def params){
       	SetupCommon.NavigateTab(Tab:"Exports",Section:"Trend Tracking")
        println("In the action")
        println(params."Report Options")
        
       	SelectItem.run(ID:"(//*[@id='report-type-select'])[7]", "Visible Text":params."Report Options") 
        println(params."Report Options")
        SetCheckBox.run(ID:"(//*[@id='report-option-profile'])[6]", Check:params."Include User Profile Data") //available only for Adoption Report
        SelectItem.run(ID:"//*[@id='async-wsstats-tab']//*[@id='report-format-select' and contains(@style,'width')]","Visible Text":params."Format")
        SelectItem.run(ID:"//*[@id='ws_stats_period_type_asynch']","Visible Text":params."Period Type")
        //SelectItem.run(ID:"//*[@id='report_base_date']","Visible Text":params."Report Base Date")

        sleep(2000)
                
        Click.run(ID:"//*[@id='green_button' and contains(@style, 'block')]")
        
        
    }
}