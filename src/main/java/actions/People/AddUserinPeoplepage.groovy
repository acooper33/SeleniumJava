package actions.People;

import actions.common.PeopleCommon
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.SelectItem

class AddUserinPeoplepage{
    public void run(def params){
        PeopleCommon.NavigateTab(Tab:"Users")
        
        Click.run(ID:"//*[@id='button-container']/DIV[1]/BUTTON[2]")
        Click.run(ID:"//*[@id='button-container']//LI[@class='user-add']")
        SetText.run(ID:"//*[@id='email-address-input']",Text:params."Email Address")
        SetText.run(ID:"//*[@id='first-name-input']",Text:params."First Name")
        SetText.run(ID:"//*[@id='last-name-input']",Text:params."Last Name")
        SetText.run(ID:"//*[@id='screen-name-input']",Text:params."Screen Name")
        SetCheckBox.run(ID:"//*[@id='is-admin-input']",Check:params."Administrator")
        Click.run(ID:"//*[@id='top-forms-container']/DIV[6]/DIV[1]/DIV[1]/A[1]/SPAN[1]")
        sleep(1000)
        SetText.run(ID:"//*[@id='child-view-container']/DIV[1]/DIV[1]/INPUT[1]",Text:params."Job Title")
        SelectItem.run(ID:"//*[@id='child-view-container']/DIV[2]/DIV[1]/SELECT[1]","Visible Text":params."Department")
        SelectItem.run(ID:"//*[@id='child-view-container']/DIV[3]/DIV[1]/SELECT[1]","Visible Text":params."Location")
        SetCheckBox.run(ID:"//*[@id='send-email-to-user-checkbox']",Check:params."Invite Email")
        Click.run(ID:"//*[@id='invite-email-header']/DIV[1]/DIV[1]/DIV[1]/A[1]/SPAN[1]")
        sleep(1000)
        SetText.run(ID:"//*[@id='email-subject-input']",Text:params."Subject")
        SetText.run(ID:"//*[@id='email-body-textarea']",Text:params."Body")
        SetCheckBox.run(ID:"//*[@id='add-another-user']",Check:params."Add Another User")
        if(params.Action){
            if(params.Action=="Back"){Click.run(ID:"//*[@id='cancel-button']")}
            else if(params.Action=="Add User"){Click.run(ID:"//*[@id='save-user-btn']")}
            else{Click.run(ID:"//*[@id='save-send-button']")}
            sleep(5000)
        }
    }
}