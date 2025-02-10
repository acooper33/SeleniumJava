package actions.Whiteboards;

import actions.selenium.utils.VerifyNumberOfMatches

class WhiteboardVerifyTemplateTile{
    public void run(def params){
        def verify = [:]
        verify.ID = "//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Template Title"}']"
        verify.IDChildren = []
        if(params."Unpinned"){
            verify.IDChildren << "./../..//DIV[contains(@class,'f-thumbnail')]/../DIV[contains(@class,'f-btn-pinned-container')]/BUTTON[contains(@class,'btn-pinned') and not(contains(@class,'f-btn-pinned-selected'))]"
        }
        if(params."Pinned"){
            verify.IDChildren << "/../..//DIV[contains(@class,'f-thumbnail')]/../DIV[contains(@class,'f-btn-pinned-container')]/BUTTON[contains(@class,'f-btn-pinned-selected')]"
        }
        if(params."Placement Number"){
            verify.ID = "//*[contains(@class,'f-template-item')][${params."Placement Number"}]//SPAN[@class='f-template-title' and .='${params."Template Title"}']"
            VerifyNumberOfMatches.run(verify)
        }else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}