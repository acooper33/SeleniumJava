package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.SetCheckBox
import actions.selenium.Click

class SetSiteSetupIdeasforTopIdeas{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Top Ideas")
        
        SetCheckBox.run(ID:"//*[@id='CB_BEST_IDEA_UI']",Check:params."Top Ideas by Category")
        
        Click.run(ID:"//*[@id='best-idea-wins-save-button']")
    }
}