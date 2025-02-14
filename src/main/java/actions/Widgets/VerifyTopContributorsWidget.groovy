package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyTopContributorsWidget{
    public void run(def params){
        def verify = [:]
        verify.Table = "//*[contains(@class,'top_contributors_widget')]//tbody"
        verify.ID = "//*[contains(@class,'top_contributors_widget')]//*[contains(text(),'${params."User"}')]"        
        verify.IDChildren = []
        if(params."Points"){verify.IDChildren << "./../*[contains(text(),'${params."Points"}')]"}
        if(params."Rank"){verify.IDChildren << "./..//*[@align='center' and text()='${params."Rank"}']"}
        if(params."User Image"!=null){
            def img
            if(params."User Image"){img = "//*[contains(@href,'ct_profile.php')]/IMG[contains(@src,'getfile.php')]"}
            else {img = "//*[contains(@href,'ct_profile.php')]/IMG[contains(@src,'images/profile')]"}
            verify.IDChildren << "./..${img}"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)  
        
        if(params."Click on link"){
            Click.run(ID:"//*[contains(@class,'top_contributors_widget')]//*[contains(text(),'${params."User"}')]/..//A[text()='${params."Click on link"}']")
        }             
    }
}
