package actions.NGAViewIdea;

import actions.selenium.SelectItem
import actions.common.*
    
class SetNGAViewIdeaDescriptionTabDropdown{
    public void run(def params){
        NGAViewIdeaCommon.NavigateTab("Tab":"Description")
        NGAViewIdeaCommon.DescriptionEnableEdit(params)
        SelectItem.run(ID:"//*[starts-with(text(),'${params."Field Name"}')]/parent::DIV/..//SELECT","Visible Text":params."Field Value")
        ViewIdeaCommon.DescriptionAction(params)    
    }
}