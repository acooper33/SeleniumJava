package actions.common;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyErrorFieldInModal{
    public void run(def params){
        def verify = [:]
        verify.IDChildren = []
        verify.ID = "//*[contains(@class,'f-modal-body')]//*[contains(@class,'error')]"
        if(params."Field Name (optional)"){
            verify.IDChildren << "./../..//*[starts-with(text(),'${params."Field Name (optional)"}')]"
        }
        if(params."Number of Error Fields"){verify."Number of Matches" = params."Number of Error Fields".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}