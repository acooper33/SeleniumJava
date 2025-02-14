package actions.Rules;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyErrorFieldinRulesModal{
    public void run(def params){
        def verify = [:]
        verify.IDChildren = []
        verify.ID = "//*[contains(@class,'f-modal-body')]//*[contains(@class,'warning-border') or contains(@class,'error')]"
       
        if(params."Placeholder Text of Empty Field"){
            verify.IDChildren << "./../..//INPUT[contains(@placeholder,'${params."Placeholder Text of Empty Field"}')]"
        }
        if(params."Number of Error Fields"){verify."Number of Matches" = params."Number of Error Fields".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}