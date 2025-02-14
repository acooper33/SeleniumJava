package actions.ViewIdeaFields;

import actions.selenium.Click
import actions.common.ViewIdeaCommon

class SetViewIdeaDescriptionTabRadiobutton{
    public void run(def params){
        ViewIdeaCommon.NavigateTab("Tab":"Description")
        ViewIdeaCommon.DescriptionEnableEdit(params)
        if(params."Field Value"){
        	Click.run(ID:"//*[starts-with(text(),'${params."Field Name"}')]/parent::DIV/..//INPUT[starts-with(@value,'${params."Field Value"}')]")            
        }
        ViewIdeaCommon.DescriptionAction(params)    
    }
}