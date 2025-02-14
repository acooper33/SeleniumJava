package actions.ActionItemsManager;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.GridCommon
import actions.selenium.Exists
import actions.common.ActionItems

class VerifyCanceledtableforActionItemsManager{
    public void run(def params){

        if(params."Verify in Which List (optional)"){ActionItems.SwitchToItemList(List:params."Verify in Which List (optional)")}
        
        if(Exists.run(ID:"//*[@id='action_item_list_canceled' and @class='filter-btn active']")<=0){ 
            Click.run(ID:"//*[@id='action_item_list_canceled']")
            sleep(2000)
        }

        VerifyText.run(ID:"//*[@id='action_item_canceled_count']","Text":params."Canceled Tab Value")

        def verify = [:]
        verify.IDChildren = []
        verify.Table = "//DIV[1]/DIV[3]/TABLE[1]"
        verify.ID = "(//TABLE)[2]//TD[.='${params."Title"}']"

        if(params."Category"){verify.IDChildren << "./../TD[contains(@class,'category')][.='${params."Category"}']"}
        if(params."Due Date"){verify.IDChildren << "./../TD[contains(@class,'action-due-date')][.='${params."Due Date"}']"}
        if(params."Assignee"){verify.IDChildren << "./../TD[contains(@class,'assignee')][.='${params."Assignee"}']"}
        if(params."Pipeline"){verify.IDChildren << "./../TD[contains(@class,'pipeline')][.='${params."Pipeline"}']"}
        if(params."Status"){verify.IDChildren << "./../TD[contains(@class,'status')][.='${params."Status"}']"}
        if(params."Step"){verify.IDChildren << "./../TD[contains(@class,'step')][.='${params."Step"}']"}
        if(params."Date Assigned"){verify.IDChildren << "./../TD[11][.='${params."Date Assigned"}']"}
        if(params."Date Completed"){verify.IDChildren << "./../TD[12][.='${params."Date Completed"}']"}
        if(params."Tool Type"){verify.IDChildren << "./../TD[contains(@class,'type')][.='${params."Tool Type"}']"}
        if(params."Assigner"){verify.IDChildren << "./../TD[contains(@class,'assigner')][.='${params."Assigner"}']"}

        if(params."Row Number"){
            verify.ID = "//TD[.='${params."Title"}']"
            def rowNum = GridCommon.RowNumberForValues(verify).toString()
            assert rowNum==params."Row Number","Error - Expected value to be in Row Number ${params."Row Number"} but actual Row is ${rowNum}"
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        }
    }
}