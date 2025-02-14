package actions.ViewIdeaFields;
import actions.common.ViewIdeaCommon
import actions.selenium.SelectItem

class SetViewIdeaDescriptionTabDropdown{
    public void run(def params){
        ViewIdeaCommon.NavigateTab("Tab":"Description")
        ViewIdeaCommon.DescriptionEnableEdit(params)
        SelectItem.run(ID:"//*[starts-with(text(),'${params."Field Name"}')]/parent::DIV/..//SELECT","Visible Text":params."Field Value")
        ViewIdeaCommon.DescriptionAction(params)    
    }
}