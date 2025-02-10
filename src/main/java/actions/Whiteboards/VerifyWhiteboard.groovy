package actions.Whiteboards;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyWhiteboard{
    public void run(def params){
        
        def verify = [:]
        verify.ID = "//DIV[contains(@class,'f-canvas-card')]//*[@class='f-card-title' and .='${params."Whiteboard Name"}']"
        verify.IDChildren = []
        if(params."Last Edited Displayed"==true){verify.IDChildren << "./../P[@class='f-card-date' and string-length() > 12 and contains(text(),'Last edited')]"}
        if(params."Placement Number") {
            verify.ID="//DIV[contains(@class,'f-canvas-card')][${params."Placement Number"}]//*[@class='f-card-title' and .='${params."Whiteboard Name"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}