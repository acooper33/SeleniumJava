package actions.ActionItems;

import actions.selenium.*
import actions.common.ActionItems
import actions.selenium.ExecuteJavascript


class SortMyActionItemsActionItemsManagertable{
    public void run(def params){
        if(params."Sort Which List"){ActionItems.SwitchToItemList(List:params."Sort Which List")}
        
        int i = 0
        while(Exists.run(ID:"//TR[1]/TH/A[text()='${params."Column Name"}']/parent::TH[contains(@class,'${params."Sort"}')]")==0){
            if(i==5){assert false,"Error - Failed to sort the column"}
            else{i++}
            Click.run(ID:"//TR[1]/TH/A[text()='${params."Column Name"}']", "Type of Click": "Javascript")
            sleep(2000)
        }
    }
}