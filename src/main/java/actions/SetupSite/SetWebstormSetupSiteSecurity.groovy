package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.selenium.SetCheckBox

class SetWebstormSetupSiteSecurity{
    public void run(def params){

        SetupCommon.NavigateTab(Tab:"Access")
        SelectItem.run(ID:"//*[@id='CB_PUBLIC_WS']", "Visible Text":params."What type of site do you want?")
        if(params."What type of site do you want?" == "Public"){
            Click.run(ID:"//*[@class='f-confirm-warning-model-checkbox']/DIV/DIV[1]")
            Click.run(ID:"//*[@data-test='modal-footer-submit']")
        }
        SelectItem.run(ID:"//*[@id='CB_CLOSED_REGISTRATION_WS']", "Visible Text":params."Which users do you want to allow to register?")   
        SetCheckBox.run(ID:"(//*[@id='CB_INVITE_WS'])", Check:params."Users can invite new users")
        //SetCheckBox.run(ID:"(//*[@id='CB_LIMIT_COLLAB_TO_MODERATORS_WS'])", Check:params."Limit Collaboration to Moderators")
        SetCheckBox.run(ID:"(//*[@id='CB_STRONG_PASSWORD_WS'])", Check:params."Enable Strong Password rules")
        SetCheckBox.run(ID:"(//*[@id='CB_DISABLE_JS_IN_WIDGETS'])", Check:params."Do not allow JavaScript in Text/HTML widgets")
        SetCheckBox.run(ID:"(//*[@id='CB_EXPIRE_EMAIL_INVITE'])", Check:params."Expire email invitation")
        SetText.run(ID:"//*[@id='email_invite_expiration']",Text:params."Expire email invitation within XX hours")
        SetText.run(ID:"//*[@id='session_timeout']",Text:params."Session Timeout Minutes")
        SetCheckBox.run(ID:"(//*[@id='CB_NO_FRAME_ENCAPSULATION'])", Check:params."Enable Frame Encapsulation Security")
        SetCheckBox.run(ID:"(//*[@id='CB_NO_SIMULTANEOUS_LOGINS'])", Check:params."Enable Simultaneous Login Security")
        SetCheckBox.run(ID:"(//*[@id='CB_DEFAULT_GROUP_REGISTRATION'])", Check:params."Default User Group for self registration")
        SelectItem.run(ID:"//*[@id='DROP_DEFAULT_USER_GROUP']","Visible Text":params."Select Default User Group for self registration")
        SetCheckBox.run(ID:"(//*[@id='CB_WS_DISABLE_USER_POINTS'])", Check:params."Hide user points from end users")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_USER_REG_TEAM_SUBMISSION']",Check:params."Allow end-users to invite non-registered participants")
        Click.run(ID:"//*[@id='security_save_button']")        
    }
}