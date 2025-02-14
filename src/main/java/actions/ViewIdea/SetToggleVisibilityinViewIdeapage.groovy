package actions.ViewIdea;

import actions.selenium.Click
import actions.selenium.SelectItem

class SetToggleVisibilityinViewIdeapage{
    public void run(def params){
        Click.run(ID:"//*[@id='toggle-idea-visibility']")
        SelectItem.run(ID:"//*[@id='toggle-option-dropdown']","Visible Text":params."Change Visibility")
        if(params."Action"=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary']")}
        else{Click.run(ID:"//*[@class='green_btn_center']")}
    }
}