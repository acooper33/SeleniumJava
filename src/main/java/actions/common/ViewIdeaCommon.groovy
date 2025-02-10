package actions.common;

import actions.selenium.Click
import actions.selenium.MouseOver
import actions.selenium.SetFocus
import actions.selenium.ExecuteJavascript

class ViewIdeaCommon{
    public static void NavigateTab(def params){
        //Tab (required) = Description, Votes, Additional Info, Attachments

        //Scroll to top first because top Bright idea bar might interfere with navigation
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        switch(params.Tab){
            case "Description":
            Click.run(ID:"//*[@id='desc-tab']")
            break
            case "Votes":
            Click.run(ID:"//*[@id='history-tab']")
            break
            case "Additional Info":
            Click.run(ID:"//*[@id='info-tab']")
            break
            case "Attachments":
            Click.run(ID:"//*[@id='attachment-tab']")
            break
            case "Evaluations":
            Click.run(ID:"//*[@id='evaluationTab-tab']")
            break
            case "Business Impact":
            Click.run(ID:"//*[contains(@id,'business')]")
            break
            case "History Tab":
            Click.run(ID:"//*[contains(@id,'actualHistory-tab')]")
            break
            case "Applicants":
            Click.run(ID:"//*[@id='applicants-tab']")
            break
        }
    }    

    //Description tab
    public static void DescriptionEnableEdit(def params){
        def id
        if(params."Field Name"=="Description"){id = "//*[@id='description-edit']"}
        else if(params."Field Name"=="Title"){id = "//*[@id='inline-edit-icon-idea-title']"}
        else{id = "//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/following-sibling::A"}
        Click.run(ID:id,"Type of Click":"Javascript")
    }
    public static void DescriptionAction(def params){
        if(params.Action){
            def idSave
            def idCancel
            if(params."Field Name"=="Description"){
                idSave = "//*[@id='idea-description-edit-save-btn']"
                idCancel = "//*[@id='idea-description-edit-cancel-btn']"
            }
            else if(params."Field Name"=="Title"){
                idSave = "//*[@id='submit-btn-title']"
                idCancel = "//*[@id='cancel-btn-title']"
            }
            else{
                idSave="//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV//DIV[contains(@class,'submit-icon')]"
                idCancel="//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV//DIV[contains(@class,'cancel-icon')]"
            }

            //if(params.Action=="Save"){Click.run(ID:idSave,"Type of Click":"Javascript")}
            if(params.Action=="Save"){Click.run(ID:idSave)}
            //else{Click.run(ID:idCancel,"Type of Click":"Javascript")}
            else{Click.run(ID:idCancel)}
        }
    }
}