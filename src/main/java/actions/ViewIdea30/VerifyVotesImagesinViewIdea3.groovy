package actions.ViewIdea30;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyVotesImagesinViewIdea3{
    public void run(def params){
     
       def verify = [:]
       verify.ID = "//*[@class='f-idea-column f-idea-column-6 f-flex-bottom'][2]"
       if(params."Member Image"!=null){
            def img
            if(params."Member Image"){img = "/IMG[contains(@src,'/ct/getfile.php')]"}
            else{img = "/*[@class='member-initial']"}
        }
       if(params."Placement Number"){
            params."Number of Matches"=1
            verify.ID = "//*[@class='f-idea-column f-idea-column-6 f-flex-bottom'][2]//*[@class='f-vote-image'][${params."Placement Number"}]/${img}"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
        
        if(params."Access the Member Image"==true){
            Click.run(ID:"//*[@class='f-idea-column f-idea-column-6 f-flex-bottom'][2]//*[@class='f-vote-image'][${params."Placement Number"}]/${img}")
        }
    }
}