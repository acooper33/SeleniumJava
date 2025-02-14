package actions.SetupCommunityExports;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.Exists

class SetCommunitySetupExportsforSubmissionsTab{
    public void run(def params){
        
        def com = "//*[@id='report-type-select' and contains(.,'${params."Report Options"}')]"
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Submissions") 
        SelectItem.run(ID:"(//*[@id='report-type-select'])[2]", "Visible Text":params."Report Options")
        SetCheckBox.run(ID:"${com}/../..//*[@id='report-option-profile']", Check:params."Include user profile data")
        SetCheckBox.run(ID:"//*[@id='report-option-idea-comments']", Check:params."Include comments")
        SetCheckBox.run(ID:"//*[contains(@id,'voter')]", Check:params."Include voter profile data")
        SetCheckBox.run(ID:"//*[@id='report-option-profile-outcomes']", Check:params."Include outcome recorder profile data")
        SetCheckBox.run(ID:"//*[@id='report-option-profile-comment']", Check:params."Include commenter profile data")
        SetCheckBox.run(ID:"//*[@id='report-option-vote']", Check:params."Include comment vote summary")
        SelectItem.run(ID:"${com}/../..//select[@id='report-format-select']", "Visible Text":params."Format")
      	Click.run(ID:"${com}/../../..//*[@id='bi-modal-button-green']")
        sleep(5000)
    }
}
