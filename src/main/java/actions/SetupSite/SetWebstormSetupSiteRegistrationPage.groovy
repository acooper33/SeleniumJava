package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetWebstormSetupSiteRegistrationPage{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Access",Section:"Registration")
        SetCheckBox.run(ID:"//*[@id='CB_CLOSED_REGISTRATION_WS']",Check:params."Disable Self-Registration")
        SetCheckBox.run(ID:"//*[@id='CB_RESTRICT_REG_BY_EMAIL_DOMAIN']",Check:params."Restrict Self-Registration by Email Domain")

        if(params."Domain"){
            params."Domain".split(",").eachWithIndex{ name, x ->
                SetText.run(ID:"//*[@id='registration_add_domain_input']",Text:name)
                Click.run(ID:"//*[@id='registration_content']//*[contains(text(),'Add Domain')]")
            } 
        }
        if(params."All Domains"){
            params."All Domains".split(",").eachWithIndex{ name, x ->
                Click.run(ID:"//*[@id='registration_all_domains']//*[contains(text(),'${name}')]")
                Click.run(ID:"//*[@id='registration_content']//*[contains(text(),'Remove Domain')]")
            } 
        }
        Click.run(ID:"//*[@id='registration_save_button']")
    }
}