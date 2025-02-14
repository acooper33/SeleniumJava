package actions.PipelineDashBoard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.GridCommon

class VerifySubmissionintheSubmissionTableonBusinessImpacttab{
    public void run(def params){

        def verify = [:]
        verify.Table = "//*[@id='submission-table']/tbody"
        verify.ID = "//*[@class='idea-cell']/A[text()='${params."Idea"}']"
        verify.IDChildren = []
        if(params."Category"){verify.IDChildren << "./../../../../TD[2][.='${params."Category"}']"}
        if(params."Stage"){verify.IDChildren << "./../../../../TD[3][.='${params."Stage"}']"}
        if(params."Total Projected Benefits"){verify.IDChildren << "./../../../../TD[4][.='${params."Total Projected Benefits"}']"}
        if(params."Total Actual Benefits"){verify.IDChildren << "./../../../../TD[5][.='${params."Total Actual Benefits"}']"}
        if(params."Total Projected Costs"){verify.IDChildren << "./../../../../TD[6][.='${params."Total Projected Costs"}']"}
        if(params."Total Actual Costs"){verify.IDChildren << "./../../../../TD[7][.='${params."Total Actual Costs"}']"}

        if(params."Row Number"){
            def rowNum = GridCommon.RowNumberForValues(verify).toString()
            assert rowNum==params."Row Number","Error - Expected value to be in Row Number ${params."Row Number"} but actual Row is ${rowNum}"
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        }
    }
}