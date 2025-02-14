package actions.Enterprise.UserHomepage;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyIdeainMyIdeasList{
    public void run(def params){
        def verify = [:]
        def title = "//*[@class='fractal-table-cell f-sparks-table-title']//*[contains(.,'${params."Title"}')]"
        verify.ID= "${title}"        
        verify.IDChildren = []
        if(params."Thumbnail"!=null){
            def img
            if(params."Thumbnail"=="Image"){img = "/IMG[contains(@src,'/ct/getfile.php')]"}
            else{img = "/IMG[contains(@src,'default-idea-image.jpg')]"}
            verify.IDChildren << "./..${img}"
        }
        if(params."Created"){verify.IDChildren << "./../..//*[@class='fractal-table-cell f-sparks-table-created']/*[text()='${params."Created"}']"}
        if(params."Row Number") {
            verify.ID="//*[@class='fractal-table-row f-sparks-row delete-icon-on-right'][${params."Row Number"}]//*[@class='fractal-table-cell f-sparks-table-title']/..${title}"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}