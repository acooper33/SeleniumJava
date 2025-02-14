package actions.ActionItems;

import actions.selenium.Click
import actions.selenium.SetCheckBox


class SetColumnsFromActionItemViewTable{
    public void run(def params){
        if(params."Column Title"){
            Click.run(ID:"//*[@id='action_item_grid']//*[contains(@class,'fa-cog')]", "Type of Click":"Javascript")
            sleep(1000)
            if(params.Check){
                SetCheckBox.run(ID:"//*[@id='action_item_list_menu']//DIV[@class='action_item_menu_check' and contains(.,'${params."Column Title"}')]//INPUT", Check:params.Check)
            }
        }
    }
}