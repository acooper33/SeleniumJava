package actions.SetupEnterpriseExports;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.Exists


class SetEnterpriseExportsforSubmissionstab{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Submissions")
        
        SelectItem.run(ID:"(//*[@id='report-type-select'])[2]", "Visible Text":params."Report Options")
                
        SetCheckBox.run(ID:"//*[@id='report-option-user-profile']", Check:params."Include user profile data")
        SetCheckBox.run(ID:"//*[@id='report-option-idea-comments']", Check:params."Include comments")
        SetCheckBox.run(ID:"//*[@id='report-option-voter-profile']", Check:params."Include voter profile data")
        SetCheckBox.run(ID:"//*[@id='report-option-commenter-profile']", Check:params."Include commenter profile data")
        SetCheckBox.run(ID:"//*[@id='report-option-vote']", Check:params."Include comment vote summary")
                
        SelectItem.run(ID:"//*[@id='green_button_ideas']/../..//select[@id='report-format-select']", "Visible Text":params."Format")
                
        Click.run(ID:"//*[@id='green_button_ideas']")
                       
        sleep(5000)
    }
}
