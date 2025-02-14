package actions.PostIdea;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifythepositionofField{
    public void run(def params){
        
        def verify = [:]
        if(params.Page == "Post Idea"){
            	verify.ID = "//*[@id='form']//fieldset[${params."Position of the Field"}][contains(.,'${params."Field Name"}')]"
        } else {
            if(params."Is Field type Default" == false){
            	verify.ID = "//*[@id='additional-questions-container']/*[contains(@class,'question-wrapper')][${params."Position of the Field"}]//*[contains(@class,'question-title') and contains(text(),'${params."Field Name"}')]"
            } else {
                verify.ID = "//*[@class='tab-content-container-description']/DIV[${params."Position of the Field".toInteger()-1}]//*[contains(@class,'question-title') and contains(text(),'${params."Field Name"}')]"
            }
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}