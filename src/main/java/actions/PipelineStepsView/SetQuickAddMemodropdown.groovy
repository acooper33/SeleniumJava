package actions.PipelineStepsView;

import actions.selenium.MouseOver
import actions.selenium.Click

class SetQuickAddMemodropdown{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'fractal-dropdown f-quick-add-more-options')]/*[@data-test='f-test-dropdown']")
        Click.run(ID:"//*[contains(@class,'f-menu-item')]/*[text()='${params."Menu Item"}']")
    }
}