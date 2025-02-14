package actions.ViewIdeaFields;

import actions.selenium.SelectItem
import actions.common.ViewIdeaCommon

class SetViewIdeaAdditionalInfoDropdown{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Additional Info")
        
        SelectItem.run(ID:"//*[text()='${params."Field Name"}']/..//select","Visible Text":params."Field Value")
    }
}