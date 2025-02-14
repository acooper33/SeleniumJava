package actions.Memo;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyMemoCardinUserhomepage{
    public void run(def params){
        
        def verify = [:]
        verify.ID = "//*[@class='f-memo-thumbnail-title' and starts-with(text(),'${params."Memo Title"}')]"
        verify.IDChildren = []
        if(params."Memo Icon Type"){
            if(params."Memo Icon Type"=="Brightidea"){
                verify.IDChildren << "./../..//*[contains(@class,'f-icon-null')]"
            } else if(params."Memo Icon Type"=="Google"){
                verify.IDChildren << "./../..//*[contains(@class,'f-icon-google_api_drive_item')]"
            } else {
                verify.IDChildren << "./../..//*[contains(@class,'f-icon-microsoft_graph_drive_item')]"
            }
        }
        if(params."Date"){verify.IDChildren << "./..//*[@class='f-memo-thumbnail-date' and contains(text(),'${params."Date"}')]"}
        if(params."User Name"){verify.IDChildren << "./..//*[@class='f-memo-thumbnail-date']//A[text()='${params."User Name"}']"}
        if(params."Status"){
            if(params."Status"=="Private"){
               verify.IDChildren << "./..//*[contains(@class,'f-memo-tag-private') and contains(.,'${params."Status"}')]" 
            } else {verify.IDChildren << "./..//*[contains(@class,'-status-indicator-outline') and contains(text(),'${params."Status"}')]"}
        }
        if(params."Thumbnail Image Displayed"==true){verify.IDChildren << "./../../../..//*[contains(@class,'f-memo-thumbnail-image') and contains(@style,'/thumbnail.png')]"}
        if(params."Placement Number") {
            verify.ID="//*[@class='f-memos-grid']/A[${params."Placement Number"}]//*[@class='f-memo-thumbnail-title' and starts-with(text(),'${params."Memo Title"}')]"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}
