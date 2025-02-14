package actions.ActionItems;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*
import actions.common.GridCommon

class VerifyNewEvaluationOrder{
    public void run(def params){
        
        def verify = [:]
        verify.IDChildren = []
        verify.Table = "//DIV[1]/DIV[3]/TABLE[1]"
        verify.ID = "(//TABLE)[2]//TD[contains(@class,'title-cell') and contains(.,'${params."Title"}')]"
        if(params."Order"){verify.IDChildren << "./../TD[contains(@class,'scorecard-order-cell')][text()='${params."Order"}']"}
        if(params."Completed"){
            def path
            if(params."Completed"==true){
                 path = "/TD[contains(@class,'scorecard-status-cell')]/*[contains(@class,'fa fa-check')]"
            } else{
                path = "/TD[contains(@class,'scorecard-status-cell') and not(*)]"
            }
            verify.IDChildren << "./..${path}"
        }            
        if(params."Row Number"){
            verify.ID = "//TD[contains(.,'${params."Title"}')]"
            def rowNum = GridCommon.RowNumberForValues(verify).toString()
            assert rowNum==params."Row Number","Error - Expected value to be in Row Number ${params."Row Number"} but actual Row is ${rowNum}"
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        }
    }
}