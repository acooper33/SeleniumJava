package actions.NGAViewIdea;

import actions.common.*
import actions.selenium.VerifyCheckBox

class VerifyNGAViewIdeaAdditionalInfoCheckbox{
    public void run(def params){
        if(params."Check"!=null){
            NGAViewIdeaCommon.NavigateTab(Tab:"Additional Info")

            VerifyCheckBox.run(ID:"//*[text()='${params."Field Name"}']/../..//INPUT","Is Checked":params.Check.toBoolean())
        }
    }
}