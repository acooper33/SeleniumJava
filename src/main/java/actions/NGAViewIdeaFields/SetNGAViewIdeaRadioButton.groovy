package actions.NGAViewIdeaFields;

import actions.common.NGAViewIdeaCommon
import actions.selenium.Click

class SetNGAViewIdeaRadioButton{
    public static void run(def params){
        //NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        //NGAViewIdeaCommon.SubmissionFormFieldEnableEdit(params)
        NGAViewIdeaCommon.DescriptionEnableEdit(params)
        if(params."Field Value"){
            println("here: ${params."Field Value"}")
        	Click.run(ID:"//*[starts-with(text(),'${params."Field Name"}')]/../..//input[starts-with(@value,'${params."Field Value"}')]")    
        }
        NGAViewIdeaCommon.DescriptionAction(params)
        sleep(2000)
    }
}