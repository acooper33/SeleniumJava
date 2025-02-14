package actions.ViewIdeaFields;

import actions.selenium.SetText
import actions.common.ViewIdeaCommon
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Exists

class SetViewIdeaDescriptionTabTextField{
    public void run(def params){
        ViewIdeaCommon.NavigateTab("Tab":"Description")

        ViewIdeaCommon.DescriptionEnableEdit(params)
        def id
        if(params."Field Name"=="Description"){
            id="//*[text()='Description']/../..//DIV[@id='idea-description-edit-wrapper']//*[contains(@class,'redactor-styles redactor-in redactor-in')]"
            //Click on editable field first to be able to add/edit any text for it 
            Click.run(ID:id)
            SetText.run(Text:params."Field Value",ID:id,"Type of Clear":"Cut")
        }
        else if(params."Field Name"=="Title") {
            id="//*[@id='idea-title-edit']"
            SetText.run(Text:params."Field Value",ID:id)
        }
        else if (Exists.run(ID:"//*[contains(text(),'${params."Field Name"}') and @class='question-title']/../..//INPUT[@type='text']", Timeout:5)>0){
            id="//*[contains(text(),'${params."Field Name"}') and @class='question-title']/../..//INPUT[@type='text']"
            println("input element exists")
            SetText.run(Text:params."Field Value",ID:id)
        }
        //if a text field editor
        else {
            id="//*[starts-with(text(),'${params."Field Name"}')]/../..//*[contains(@class,'redactor-styles redactor-in redactor-in')]"
            println("iframe element exists")
            Click.run(ID:id)
            SetText.run(Text:params."Field Value",ID:id,"Type of Clear":"Cut")
        }
        sleep(2000)
        ViewIdeaCommon.DescriptionAction(params)
    }
}