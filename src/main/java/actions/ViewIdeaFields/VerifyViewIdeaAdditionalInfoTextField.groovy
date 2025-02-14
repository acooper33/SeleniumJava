package actions.ViewIdeaFields;

import actions.common.ViewIdeaCommon
import actions.selenium.VerifyText
import actions.selenium.Exists

class VerifyViewIdeaAdditionalInfoTextField{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Additional Info")
        if (Exists.run(ID:"//*[contains(text(),'${params."Field Name"}') and @class='label']/..//INPUT", Timeout:5)>0){
         	VerifyText.run("Input Field Text":params."Field Value",ID:"//*[contains(text(),'${params."Field Name"}')]/..//input[@class='answer']")   
        }
        else {
            VerifyText.run("Input Field Text":params."Field Value", ID:"//*[text()='${params."Field Name"}']/..//textarea")
        }
    }
}