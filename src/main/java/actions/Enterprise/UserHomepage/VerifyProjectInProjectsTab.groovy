package actions.Enterprise.UserHomepage;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyProjectInProjectsTab{
    public void run(def params){
        def verify = [:]
        if(params."Placement Number"){
            verify.ID = "//*[contains(@class,'f-project-card f-userhomepage-card') and position()='${params."Placement Number"}']//H2[contains(.,'${params."Title"}')]"
        }else{
            verify.ID = "//*[contains(@class,'f-project-card f-userhomepage-card')]//H2[contains(.,'${params."Title"}')]"
        }    
        verify.IDChildren = []
        if(params."Thumbnail"){
            def img
            if(params."Thumbnail"=="Image"){img = "/DIV[@class='f-card-image' and contains(@style,'/ct/getfile.php')]"}
            else{img = "/DIV[@class='f-card-image' and contains(@style,'default-idea-image.jpg')]"}
            verify.IDChildren << "./../..${img}"
        }
        if(params."Project Card Info Title"){verify.IDChildren << "./../../DIV[@class='f-card-info']//*[contains(.,'${params."Project Card Info Title"}')]"}
        if(params."Project Card Info"){verify.IDChildren << "./../../DIV[@class='f-card-info']//*[contains(.,'${params."Project Card Info"}')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
        if(params."Click on Project Card"){Click.run(ID:"//*[contains(@class,'f-project-card f-userhomepage-card')]//H2[contains(.,'${params."Title"}')]")}
    }
    
}