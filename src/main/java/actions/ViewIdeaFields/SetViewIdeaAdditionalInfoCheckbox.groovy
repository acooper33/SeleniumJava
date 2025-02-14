package actions.ViewIdeaFields;

import actions.common.ViewIdeaCommon
import actions.selenium.SetCheckBox

class SetViewIdeaAdditionalInfoCheckbox{
    public void run(def params){
        if(params."Check"!=null){
            ViewIdeaCommon.NavigateTab(Tab:"Additional Info")

            SetCheckBox.run(ID:"//*[text()='${params."Field Name"}']/..//input",Check:params.Check.toBoolean())
        }
    }
}