package actions.SetupSite;

import actions.selenium.ExecuteJavascript
import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click

class SetDesignTabinSystemSetup{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Site",Section:"Design")
        SetText.run(ID:"//*[@id='userhome_page_bg_input']",Text:params."Userhomepage Page Background")
        SetText.run(ID:"//*[@id='userhome_sidebar_bg_input']",Text:params."User Homepage Sidebar Background")
        SetText.run(ID:"//*[@id='userhome_menu_text_input']",Text:params."User Homepage Menu Text")
        SetText.run(ID:"//*[@id='userhome_menu_selected_input']",Text:params."User Homepage Menu Selected")
        SetText.run(ID:"//*[@id='ent-design-custom-css']",Text:params."Custom CSS","Type of Clear":"None")
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        Click.run(ID:"//*[@class='ent-design-save-button']")
        sleep(2000) 
        
    }
}