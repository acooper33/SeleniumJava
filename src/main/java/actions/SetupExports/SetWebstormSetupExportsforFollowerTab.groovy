package actions.SetupExports;

import actions.selenium.Click
import actions.common.SetupCommon
import actions.selenium.SetCheckBox



class SetWebstormSetupExportsforFollowerTab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Follower")
        SetCheckBox.run(ID:"//*[@id='ao_report_follower_profile']", Check:params."Include User Profile Data")
        Click.run(ID:"//*[@id='rep_follower_content']/button[text()='Download Follower']")
    }
}