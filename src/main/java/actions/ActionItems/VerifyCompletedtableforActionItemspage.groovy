package actions.ActionItems;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click
import actions.selenium.*
import actions.common.ActionItems
import actions.common.GridCommon
import actions.selenium.Exists

class VerifyCompletedtableforActionItemspage{
    public void run(def params){
        if(params."Verify in Which List (optional)"){ActionItems.SwitchToItemList(List:params."Verify in Which List (optional)")}

        if(Exists.run(ID:"//*[@id='action_item_list_complete' and @class='filter-btn active']")<=0){ 
            Click.run(ID:"//*[@id='action_item_list_complete']")
            sleep(2000)
        }

        VerifyText.run(ID:"//*[@id='action_item_complete_count']","Text":params."Completed Tab Value")

        def verify = [:]
        verify.IDChildren = []
        verify.Table = "//DIV[1]/DIV[3]/TABLE[1]"
        verify.ID = "(//TABLE)[2]//TD[contains(@class,'title-cell') and .='${params."Title"}']"
        if(params."Score"){verify.IDChildren << "./../TD[contains(@class,'score-cell')][text()='${params."Score"}']"}
        if(params."Rating"){verify.IDChildren << "./../TD[contains(@class,'rating-cell')][text()='${params."Rating"}']"}
        if(params."Submitter"){verify.IDChildren << "./../TD[contains(@class,'screen-name-cell')][text()='${params."Submitter"}']"}
        if(params."Answer"){verify.IDChildren << "./../TD[contains(@class,'answer-cell')][text()='${params."Answer"}']"}
        if(params."Type"){verify.IDChildren << "./../TD[contains(@class,'type')][.='${params."Type"}']"}
        if(params."Assignee"){verify.IDChildren << "./../TD[contains(@class,'assignee-cell')]/*[text()='${params."Assignee"}']"}

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