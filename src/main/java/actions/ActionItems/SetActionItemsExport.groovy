package actions.ActionItems;

import actions.selenium.*
import actions.common.ActionItems

class SetActionItemsExport{
    public void run(def params){
        if(params."List"){ActionItems.SwitchToItemList(List:params."List")}
        Click.run(ID:"//*[@id='action_item_export_report']")
    }
}