package actions.SetupExports;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.Exists
import actions.selenium.utils.*
import org.openqa.selenium.WebDriver
import actions.selenium.Browser


class SetWebstormSetupExportsforSubmissionstab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Exports",Section:"Submissions")
        
        SelectItem.run(ID:"//*[@id='report-type-select']", "Visible Text":params."Report Options")
        SetCheckBox.run(ID:"//*[@id='report-option-profile']", Check:params."Include user profile data")
        SetCheckBox.run(ID:"//*[@id='report-option-profile-outcomes']", Check:params."Include outcome recorder profile data")
        SetCheckBox.run(ID:"//*[@id='report-option-sub-form-data']", Check:params."Include submission form data")
        SetCheckBox.run(ID:"//*[@id='report-option-batch-name']", Check:params."Include batch name")
        SetCheckBox.run(ID:"//*[@id='report-option-hidden-questions']", Check:params."Include hidden submission form questions")
        SetCheckBox.run(ID:"//*[@id='report-option-comment']", Check:params."Include Comments")
        SelectItem.run(ID:"//*[@id='report-format-select']", "Visible Text":params."Format")
        
        Click.run(ID:"//*[contains(@class, 'green_btn') and text()='Generate']")        
    }
}