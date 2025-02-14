package actions.MTS;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches

class TeamsiteVerifyActionItems{
    public void run(def params){
        def verify = [:]
        verify.IDChildren = []
        if(params."Action Item Title"){
            //verify.ID = "//DIV[contains(@class, 'action-items-container')]//*[contains(@data-class,'f-rnw-web-text') and contains(.,'${params."Action Item Title"}')]"
            verify.ID = "//*[contains(@class, 'action-items-container')]//*[contains(@data-test,'action-item-title') and contains(.,'${params."Action Item Title"}')]"
        }
        if(params."Action Item Type"){
            verify.IDChildren << "./preceding-sibling::*[contains(@data-test,'action-item-type') and contains(.,'${params."Action Item Type"}')]"
            //verify.IDChildren << "./../*[contains(@data-test,'action-item-type') and contains(.,'${params."Action Item Type"}')]"

        }
        if(params."Initiative Title"){
            verify.IDChildren << "./../../..//*[contains(@data-test,'action-item-pipeline-name') and contains(.,'${params."Initiative Title"}')]"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
        
        if(params."Click on it?"==true)Click.run(ID:verify.ID)
    }
}