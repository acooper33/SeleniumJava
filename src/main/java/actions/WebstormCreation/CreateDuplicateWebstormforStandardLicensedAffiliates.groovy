package actions.WebstormCreation;

import actions.selenium.SetText
import actions.common.AppsCommon
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.ExplicitWait

class CreateDuplicateWebstormforStandardLicensedAffiliates{
    public void run(def params){
   
        if(Exists.run(ID:"//*[@class='title' and text()='Duplicate Initiative']")==0){ 
            Click.run(ID:"//SPAN[@class='app-card-name' and text()='Duplicate']")
        }  
        
        if(params."Initiative to Duplicate"){
            Click.run(ID:"//*[@data-tooltip-id='f-combobox-input-tooltip-pipeList']//I")
            sleep(2000)
            Click.run(ID:"//*[contains(@class,'f-combobox-list') and contains(@style,'display: flex')]//*[text()='${params."Initiative to Duplicate"}']/..")
        }
        
        if(params."Is this a new memo team site or will it be added to a existing team site?"){
            Click.run(ID:"//*[@ID='memo-radios']//*[text()='${params."Is this a new memo team site or will it be added to a existing team site?"}']/..//*[@class='f-radio-outer']")
        }
        
        if(params."Select existing team site"){
            Click.run(ID:"//*[@id='siteList']//I")
            sleep(2000)
            Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]//*[text()='${params."Select existing team site"}']/..")
        }

        SetText.run(ID:"//*[@id='memoNewUrl']",Text:params."Vanity URL")
        SetText.run(ID:"//*[@placeholder='My New Initiative']",Text:params."Name")
        SetText.run(ID:"//*[@id='description']",Text:params."Description")
       
       AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":params."Admin Field Name",User:params."Administrators","Add or Remove":params."Administrators Add or Remove")
       AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"Pipeline Moderators",User:params."Moderators","Add or Remove":params."Moderators Add or Remove")
       AppsCommon.NewUserPickerAddRemoveInDuplicateNewModal("Field Name":"General Access", User:params."General Access Users","Add or Remove":params."General Access Users Add or Remove")
        
        if(params."Action"){
            if(params."Action"=="Cancel"){
                Click.run(ID:"//*[@data-test='modal-footer-cancel']")
            }
            else{
                Click.run(ID:"//*[@data-test='modal-footer-submit']")
                sleep(10000)
            }
        }
        if(params."Should Admin Wait for Pipeline to be Created" == true){
        ExplicitWait.run(ID:"//*[@id='sidebar-pipelines']//*[text()='${params."Name"}']")
        }
    }
}