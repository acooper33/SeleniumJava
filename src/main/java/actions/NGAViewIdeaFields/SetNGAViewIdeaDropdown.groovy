package actions.NGAViewIdeaFields;

import actions.common.NGAViewIdeaCommon
import actions.selenium.SelectItem
import actions.selenium.Click

class SetNGAViewIdeaDropdown{
    public static void run(def params){
        //NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        //NGAViewIdeaCommon.SubmissionFormFieldEnableEdit(params)
        NGAViewIdeaCommon.DescriptionEnableEdit(params)
        SelectItem.run(ID:"//*[starts-with(text(),'${params."Field Name"}')]/parent::DIV/..//SELECT","Visible Text":params."Field Value")
        NGAViewIdeaCommon.DescriptionAction(params)
    }
}