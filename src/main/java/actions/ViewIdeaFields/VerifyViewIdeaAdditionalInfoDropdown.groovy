package actions.ViewIdeaFields;

import actions.common.ViewIdeaCommon
import actions.selenium.VerifySelectedItem

class VerifyViewIdeaAdditionalInfoDropdown{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Additional Info")
        
        VerifySelectedItem.run(ID:"//*[text()='${params."Field Name"}']/..//select","Item Label":params."Field Value")
    }
}