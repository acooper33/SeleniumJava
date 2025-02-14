package actions.ActionItems;

import actions.selenium.*
import actions.common.ActionItems

class AccessActionIteminMyActionItemsActionItemsManagertable{
    public void run(def params){
        ActionItems.SwitchToItemList(List:params."Access in Which List")
        
        def set = [:]
        set.IDChildren = []
        if(params."Access in Which List"=="My Action Items"){
            set.ID= "//*[@class='body_table']//TD[2]/A[text()='${params."Title"}']"
            if(params."Pipeline"){set.IDChildren << "./../../TD[contains(@class,'pipeline')]/A[text()='${params."Pipeline"}']"}
            if(params."Step"){set.IDChildren << "./../../TD[contains(@class,'step')]/A[text()='${params."Step"}']"}
            if(params."Type"){set.IDChildren << "./../../TD[contains(@class,'type')]/A[text()='${params."Type"}']"}
        }
        else{
            set.ID= "//*[@class='body_table']//TD[3]/A[text()='${params."Title"}']"
            if(params."Pipeline"){set.IDChildren << "./../../TTD[contains(@class,'pipeline')]/A[text()='${params."Pipeline"}']"}
            if(params."Step"){set.IDChildren << "./../../TD[contains(@class,'step')]/A[text()='${params."Step"}']"}
            if(params."Type"){set.IDChildren << "./../../TD[contains(@class,'type')]/A[text()='${params."Type"}']"}
            if(params."Assignee"){set.IDChildren << "./../../TD[contains(@class,'assignee')]/A[text()='${params."Assignee"}']"}
        }
        Click.run(set)
        sleep(2000)
    }
}