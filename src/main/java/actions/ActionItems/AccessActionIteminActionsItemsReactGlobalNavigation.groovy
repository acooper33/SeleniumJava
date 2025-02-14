package actions.ActionItems;

import actions.selenium.Click
import actions.selenium.utils.VerifyNumberOfMatches

class AccessActionIteminActionsItemsReactGlobalNavigation{
    public void run(def params){
        Click.run(ID:"//*[contains(@class,'fractal-global-nav-action-items')]/../..")
        sleep(2000)
        def verify = [:]
        verify.ID = "//*[contains(@class,'fractal-global-nav-action-items')]/../..//*[starts-with(text(),'${params."Action Item"}')]"
        verify.IDChildren = []
        if(params."Message"){
            verify.IDChildren << "./../..//*[contains(.,'${params."Message"}')]"
        }
        if(params."Pipeline Name"){
            verify.IDChildren << "./../../..//*[text()='${params."Pipeline Name"}']"
        }
        if(params."Placement Number"){
            verify.ID = "//*[contains(@class,'f-item f-unread')][${params."Placement Number"}]//*[starts-with(text(),'${params."Action Item"}')]"
            VerifyNumberOfMatches.run(verify)
        }else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
        if(params."Click on Action Item"== true || params."Click on Action Item"== null){
             Click.run(ID:verify.ID)
        	 sleep(2000)
        }       
    }
}