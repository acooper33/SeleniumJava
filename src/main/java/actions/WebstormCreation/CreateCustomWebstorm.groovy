package actions.WebstormCreation;

import actions.common.AppsCommon
import actions.selenium.SetText
import actions.selenium.Exists
import actions.selenium.Click
import actions.selenium.SendKeys
import actions.selenium.ExplicitWait

class CreateCustomWebstorm{
    public void run(def params){
        
         if(Exists.run(ID:"//SPAN[@class='app-card-name' and text()='Custom']")>0){ 
             Click.run(ID:"//SPAN[@class='app-card-name' and text()='Custom']")
        }  
        
        SetText.run(Text:params."Webstorm Title",ID:"//*[@id='name']")
        SetText.run(Text:params."Description",ID:"//*[@id='description']")
        SetText.run(Text:params."Submission Name",ID:"//*[@id='submission_name']","Type of Clear":"Cut")
        SetText.run(Text:params."Submission Plural Name",ID:"//*[@id='submission_name_plural']","Type of Clear":"Cut")
        Click.run(ID:"//BUTTON[text()='Continue']")
        
        AppsCommon.ChooseDesignTemplate(params)
        AppsCommon.UserPickerAddRemove("Field Name":"General Access",User:params."General Access","Add or Remove":params."General Access Add or Remove")
        
        if(params."Type of Licensing Model" == "Standard Licensing Model"){
                  AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":params."Admin Field Name",User:params."Pipeline Administrators","Add or Remove":params."Administrators Add or Remove")
                  AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":"Pipeline Moderators",User:params."Moderators","Add or Remove":params."Moderators Add or Remove")
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