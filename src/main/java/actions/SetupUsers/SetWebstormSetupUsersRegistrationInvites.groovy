package actions.SetupUsers;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SelectItem

class SetWebstormSetupUsersRegistrationInvites{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Users",Section:"Registration Invites")
        if(params."Create New Registration Email"){
            Click.run(ID:"//*[@id='register_screen_2']//BUTTON[contains(@class,'setup-primary-btn')]")
        }
        if(params."Subject"){
            SetText.run(ID:"//INPUT[@id='register_email_subject']", Text:params."Subject")
        }
        if(params."Send To"){
            SetText.run(ID:"//INPUT[@id='register_to_email']", Text:params."Send To")
        }
        if(params."Group (optional)"){
            SelectItem.run(ID:"//SELECT[@id='register_user_group']", "Visible Text": params."Group (optional)")
        }
        if(params."Body (optional)"){
            SetText.run(ID:"//TEXTAREA[@id='register_email_bod']", Text:params."Body (optional)")
        }
        if(params."Send Invites"){
            Click.run(ID:"//*[@id='register_screen_1']//BUTTON[contains(.,'Send Invites')]")
        }
    }
}