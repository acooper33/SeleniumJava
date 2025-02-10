package actions.common;

import actions.selenium.*

class NGAViewIdeaCommon{
    public static void NavigateTab(def params){
        //Tab (required) = Description, Votes, Additional Info, Attachments

        //Scroll to top first because top Bright idea bar might interfere with navigation
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        switch(params.Tab){
            case "Description":
            	Click.run(ID:"//*[@id='desc']")
           		break
            case "Votes":
            	Click.run(ID:"//*[@id='history']")
            	break
            case "Additional Info":
            	Click.run(ID:"//*[@id='info']","Type of Click":"Javascript")
            	break
            case "Details":
            	Click.run(ID:"//*[@id='details']","Type of Click":"Javascript")
            	break
            case "Attachments":
            	Click.run(ID:"//*[@id='attachment']","Type of Click":"Javascript")
            	break
            case "Evaluations":
            	Click.run(ID:"//*[@id='evaluation']","Type of Click":"Javascript")
            	break
        }
    }
    public static void DescriptionEnableEdit(def params){
        def id
        if(params."Field Name"=="Description"){id = "//*[@id='inline-edit-icon-idea-description']"}
        else if(params."Field Name"=="Title"){id = "//*[@id='inline-edit-icon-idea-title']"}
        else{id = "//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/following-sibling::A"}
        Click.run(ID:id,"Type of Click":"Javascript")
    }
    public static void DescriptionAction(def params){
        if(params."Action"){
            def idSave
            def idCancel
            idSave="//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV//DIV[contains(@class,'submit-icon')]"
            idCancel="//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV//DIV[contains(@class,'cancel-icon')]"
            if(params."Action"=="Save"){Click.run(ID:idSave)}
            if(params."Action"=="Cancel"){Click.run(ID:idCancel)}
        }
    }
    
} 
