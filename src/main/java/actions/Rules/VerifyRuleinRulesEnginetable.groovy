package actions.Rules;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.GridCommon

class VerifyRuleinRulesEnginetable{
    public void run(def params){
        def verify = [:]
        verify.Table = "//*[@id='rule-grid']/DIV[1]/DIV[2]/TABLE[1]"
        verify.ID = "//TD[4]/A[text()='${params."Rule Name"}']"
        verify.IDChildren = []
        if(params."Event"){verify.IDChildren << "./../../TD[5]/*[text()='${params."Event"}']"}
        if(params."Last Run"){verify.IDChildren << "./../../TD[6][contains(text(),'${params."Last Run"}')]"}
        if(params."Status"){verify.IDChildren << "./../../TD[7]//*[text()='${params."Status"}']"}
        if(params."Description"){verify.IDChildren << "./../../TD[8][text()='${params."Description"}']"}
        
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}