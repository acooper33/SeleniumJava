package actions.ViewIdea;
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyFindTeammatesinViewIdeaPage{
    public void run(def params){

        if(Exists.run(ID:"//*[@id='find-teammates-overlay-content']")==0){
            Click.run(ID:"//*[@id='find-teammates-btn']")
            sleep(3000)
        }

        def verify = [:]
        verify.ID = "//*[@class='find-teammates-card-wrapper']//*[@class='find-teammates-card-name' and text()='${params."User"}']"
        if(params."Placement Number"){
            verify.ID = "//*[@class='find-teammates-card-wrapper'][${params."Placement Number"}]//*[@class='find-teammates-card-name' and text()='${params."User"}']"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
    }
}