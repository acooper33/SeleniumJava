package actions.ActionItems;
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SettheDensityandColumninActionItemspage{
    public void run(def params){

        Click.run(ID:"//*[@id='action_item_grid']//th[contains(@class,'image-header-cell')]/I")
        
        if(params."Columns"){
            params."Columns".split(",").eachWithIndex{ name, x ->
                SetCheckBox.run(ID:"//*[@class='action_item_menu_check' and contains(.,'${name}')]//input",Check:params."Check".split(",")[x].toBoolean())
            }
        }
        if (params."Display Density") {
            Click.run(ID:"//*[@class='action_item_menu_check' and contains(.,'${params."Display Density"}')]")
        }
    }
}