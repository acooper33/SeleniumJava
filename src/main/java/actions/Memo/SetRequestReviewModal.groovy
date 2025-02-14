package actions.Memo;
import actions.selenium.SetText
import actions.selenium.SetReactTags
import actions.selenium.SetCheckBox
import actions.common.AppsCommon
import actions.selenium.Click

class SetRequestReviewModal{
    public void run(def params){
        
        if(params."Round Configuration"==true){
             Click.run(ID:"//*[@class='f-round-config']")
        }
        if(params."Select Reviewers"){
            SetReactTags.setMemberWhiteboardMemoModalTags("Field Name":"",User:params."Select Reviewers","Add or Remove":params."Select Reviewers Add or Remove")
            //AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":"",User:params."Select Reviewers","Add or Remove":params."Select Reviewers Add or Remove")
        } 
       SetText.run(Text:params."Note to Reviewer",ID:"//*[contains(@class,'fractal-textarea')]/TEXTAREA") 
       SetCheckBox.run(ID:"//*[contains(text(),'Send email alert')]/../..//INPUT",Check:params."Send email alert")
        if(params."Click on Advanced Settings"==true || "Click on Advanced Settings"==null){
            Click.run(ID:"//A[text()='View Advanced Settings']")
            sleep(3000)
        }
       SetText.run(Text:params."Round Name",ID:"//*[contains(@class,'f-review-round-name')]") 
       if(params."Click on Template Editor"==true){
           Click.run(ID:"//*[contains(@class,'f-review-template-container')]//A")
        }
        if(params."Review Template"){
            println("testing")
            Click.run(ID:"//*[@id='f-select-template']")
            sleep(2000)
            Click.run(ID:"//*[@id='f-combobox-list']//*[text()='${params."Review Template"}']")
        }
        SetText.run(Text:params."Due Date",ID:"//*[contains(@class,'f-review-due-date-container')]//INPUT") 
        SetCheckBox.run(ID:"//*[contains(@class,'f-review-remind-container')]//INPUT[@type='checkbox']",Check:params."Send email")
        SetText.run(Text:params."days of inactivity",ID:"//*[contains(@class,'f-review-remind-container')]//INPUT[@type='number']") 
        if(params.Action){
            Click.run(ID:"//*[contains(@class,'footer')]//*[text()='${params.Action}']")
            sleep(2000)
            if(params."Action"=="Delete Round"){
                if(params."Delete Action"=="Delete"){
                  Click.run(ID:"//*[@id='clickToConfirmOkButton']")  
                } else {Click.run(ID:"//*[@id='clickToConfirmCancelButton']")}
            }
        }
    }
}