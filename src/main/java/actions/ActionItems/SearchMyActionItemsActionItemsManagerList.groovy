package actions.ActionItems;

import actions.selenium.*
import actions.common.ActionItems
    
class SearchMyActionItemsActionItemsManagerList{
    public void run(def params){
        if(params."Search Which List"){ActionItems.SwitchToItemList(List:params."Search Which List")}
        
        if(params."Clear Search"==true){
            Click.run(ID:"//*[@id='action_item_search']//A[1]")
            sleep(3000)
        }
        if(params."Search Field"){
            SetText.run(ID:"//*[@id='action_item_search']//INPUT[1]",Text:params."Search Field")
            SendKeys.run(ID:"//*[@id='action_item_search']//INPUT[1]",Key:"ENTER")
            sleep(3000)
        }
    }
}