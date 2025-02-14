package actions.PipelineTopIdeas;

//import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Exists
import actions.selenium.Click


class VerifyMyListInTopIdeas{
    public void run(def params){
        if(params."My List Name"){
            if(params."Should Exist" == true){
                assert Exists.run(ID:"//DIV[@class='f-list-container']/UL/LI[contains(@class,'f-list-item')]/SPAN[@class='f-list-item-name' and contains(.,'${params."My List Name"}')]")>0,"Error - Expected list was not found"
            }
            else if (params."Should Exist" == false){
                assert Exists.run(ID:"//DIV[@class='f-list-container']/UL/LI[contains(@class,'f-list-item')]/SPAN[@class='f-list-item-name' and contains(.,'${params."My List Name"}')]")==0,"Error - Unexpected list was found"
            }
            /*def verify = [:]
            verify.ID = "//DIV[@class='f-list-container']/UL/LI[contains(@class,'f-list-item')]/SPAN[@class='f-list-item-name' and contains(.,'${params."My List Name"}')]"
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        	verify.Timeout=15
        	VerifyNumberOfMatches.run(verify)*/
            if(params."Open List?"){
                Click.run(ID:"//DIV[@class='f-list-container']/UL/LI[contains(@class,'f-list-item')]/SPAN[@class='f-list-item-name' and contains(.,'${params."My List Name"}')]")
            }
        }
    }
}