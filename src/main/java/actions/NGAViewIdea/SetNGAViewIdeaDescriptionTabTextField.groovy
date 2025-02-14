package actions.NGAViewIdea;

import actions.selenium.SetText
import actions.common.*
import actions.selenium.SetFocus
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Exists

class SetNGAViewIdeaDescriptionTabTextField{
    public static void run(def params){
        NGAViewIdeaCommon.NavigateTab("Tab":"Description")
        NGAViewIdeaCommon.DescriptionEnableEdit(params)
        def id
        if(params."Field Name"=="Description"){
             id="//*[@id='description-body']"
            //Click on editable field first to be able to add/edit any text for it 
            Click.run(ID:id)
            SetText.run(Text:params."Field Value",ID:id,"Type of Clear":"Cut")
        }
        else if(params."Field Name"=="Title") {
            SetText.run(Text:params."Field Value",ID:"//*[@id='idea-title-edit']")
        }
        else if (Exists.run(ID:"//*[contains(text(),'${params."Field Name"}') and @class='question-title']/../..//INPUT[@type='text']", Timeout:10)>0){
            SetText.run(Text:params."Field Value",ID:"//*[contains(text(),'${params."Field Name"}') and @class='question-title']/../..//INPUT[@type='text']")
        }
        //if a text field editor
        else {
            id="//*[starts-with(text(),'${params."Field Name"}')]/../..//*[contains(@class,'redactor-styles redactor-in redactor-in')]"
            Click.run(ID:id)
            SetText.run(Text:params."Field Value",ID:id,"Type of Clear":"Cut")
        }        
        sleep(4000)
        ViewIdeaCommon.DescriptionAction(params)
    }
}
