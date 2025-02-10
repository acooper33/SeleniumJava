package actions.WebstormCreation;

import actions.common.AppsCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.selenium.DoubleClick
import actions.selenium.SendKeys
import actions.selenium.SetReactTags

class CreateMemoWebstorm{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@id,'memo')]//span[1]", "Type of Click":"Javascript")
        Click.run(ID:"//*[@id='phase-app-detail']//BUTTON[@class='btn btn-primary navigate']")

        AppsCommon.UserPickerAddRemove("Field Name":"Sponsor",User:params."Sponsor Name","Add or Remove":params."Sponsor Add or Remove")
        SetText.run(Text:params."Webstorm Title",ID:"//*[@id='name']")
        SetText.run(Text:params."Description",ID:"//*[@id='description']")
        //SelectItem.run(ID:"//*[@id='memo_community']","Visible Text":params."New or Existing Memo Team Site")
        if(params."New or Existing Memo Team Site"){
            SendKeys.run(ID:"//*[@id='memo_community']", Text:params."New or Existing Memo Team Site")
            SendKeys.run(ID:"//select[@id='memo_community']", Key:"ENTER")   
        }         
        SetText.run(Text:params."Vanity URL",ID:"//*[@id='site_alias']")
        Click.run(ID:"//BUTTON[text()='Continue']")
        
        AppsCommon.ChooseDesignTemplate(params)
        
        AppsCommon.UserPickerAddRemove("Field Name":"General Access",User:params."General Access","Add or Remove":params."General Access Add or Remove")
        if(params."Type of Licensing Model" == "Standard Licensing Model"){
             //AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":params."Admin Field Name",User:params."Pipeline Administrators","Add or Remove":params."Administrators Add or Remove")
            if(params."Pipeline Administrators") SetReactTags.setMemberTagsWithAddRemoveNewSetupWizard("Field Name":params."Admin Field Name",User:params."Pipeline Administrators","Add or Remove":params."Administrators Add or Remove")      
            if(params."Moderators") SetReactTags.setMemberTagsWithAddRemoveNewSetupWizard("Field Name":"Pipeline Moderators",User:params."Moderators","Add or Remove":params."Moderators Add or Remove")
        } else {
        	AppsCommon.UserPickerAddRemove("Field Name":"Roles",User:params."Pipeline Administrators","Add or Remove":params."Administrators Add or Remove")
        	AppsCommon.UserPickerAddRemove("Field Name":"Moderators",User:params."Moderators","Add or Remove":params."Moderators Add or Remove") 
        }
        
        AppsCommon.ImportUserGroup("Import User Group As":params."Import Group as","Import Group File":params."Import File","Add or Remove User Group":params."Add or Remove Group","Import User Group Action":params."Import Group Action","Check Complete Modal Action":params."Check Modal Action","Group Name":params."Group Name")
        
        if(params."Action"){
           sleep(5000)
            if(params."Action"=="Cancel"){
                Click.run(ID:"//*[@data-action='cancel']")
            }
            else if(params."Action"=="Back"){
                Click.run(ID:"//*[@data-action='back']")
            }
            else{
                Click.run(ID:"//*[@data-action='create']")
            }
        }
        sleep(5000)
    }
}
