package actions.Widgets;

import actions.selenium.SetCheckBox
import actions.selenium.Click

class SetVisualWebstormListLarge{
    public void run(def params){
        Click.run(ID:"//*[@class='widget_title']//*[text()='${params."Widget Name"}']/../..//A[@class='widget_edit_icon']","Type of Click":"Javascript")
        SetCheckBox.run(ID:"//*[@id='show-phase-checkbox']",Check:params."Show Phases")
        if (params."WebStorms from List"){
            params."WebStorms from List".split(",").eachWithIndex{ pipeline, x ->
                SetCheckBox.run(ID:"//*[@class='vwl-edit-view-ws-title' and text()='${pipeline}']/..//DIV/INPUT[@id='vwl-show-from-list-checkbox']",Check:params."WebStorm Checkbox Check".split(",")[x].toBoolean())
            }
        }
        Click.run(ID:"//INPUT[contains(@id,'title_edit') and @value='${params."Widget Name"}']/../../..//A[@class='widget_edit_icon']","Type of Click":"Javascript")
    }
}