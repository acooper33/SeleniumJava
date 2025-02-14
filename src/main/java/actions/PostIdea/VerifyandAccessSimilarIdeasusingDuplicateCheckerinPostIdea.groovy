package actions.PostIdea;

import actions.selenium.*
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyandAccessSimilarIdeasusingDuplicateCheckerinPostIdea{
    public void run(def params){
        def verify = [:]
        verify.ID = "//*[@class='result-container visible']//*[@class='idea_meta']//strong[text()='${params."Title"}']" 
        verify.IDChildren = []
        if(params."Description"){verify.IDChildren << "./../../..//*[not(strong)][contains(.,'${params."Description"}')]"}
        if(params."Image" !=null){
            def img
            if(params."Image"){img = "/*[contains(@src,'/ct/getfile.php')]"}
            else {img = "/*[contains(@src, 'default-idea-image.jpg')]"}
            verify.IDChildren << "./../../../${img}"
        }
        if(params."Placement Number"){
            params."Number of Matches"=1
            verify.ID = "//*[@class='result-container visible']/*[@class='result'][${params."Placement Number"}]//*[@class='idea_meta']//strong[text()='${params."Title"}']"
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
        if(params."Access the Idea"==true){
            Click.run(ID:verify.ID)
        }
    }
}