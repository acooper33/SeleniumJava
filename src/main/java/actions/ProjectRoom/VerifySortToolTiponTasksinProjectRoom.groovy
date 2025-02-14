package actions.ProjectRoom;

import actions.selenium.Exists
import actions.selenium.SetFocus
import actions.selenium.Click

class VerifySortToolTiponTasksinProjectRoom{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-tasks-actions-bar')]")
        SetFocus.run(ID:"//*[contains(@class,'f-sort-icon')]")
        assert Exists.run(ID:"//*[contains(@class,'react-tooltip__show') and .='${params."ToolTip"}']")==1, "Error - Incorrect ToolTip displayed. Expected is ${params."ToolTip"}"
        
    }
}