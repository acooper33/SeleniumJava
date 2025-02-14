package actions.ViewIdeaFields;

import actions.common.ViewIdeaCommon
import actions.selenium.VerifyCheckBox

class VerifyViewIdeaAdditionalInfoCheckbox{
    public void run(def params){
        if(params."Check"!=null){
            ViewIdeaCommon.NavigateTab(Tab:"Additional Info")

            VerifyCheckBox.run(ID:"//*[text()='${params."Field Name"}']/..//input","Is Checked":params.Check.toBoolean())
        }
    }
}