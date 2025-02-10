package actions.PipelineSetup;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyLicenseTypeofUserinFields{
    public void run(def params){
        
        //Map all values that will be used for verification for that instance
        def verify = [:]
        sleep(2000)
        verify.ID = "//*[@class='f-user-role-row']//*[text()='${params."Field"}']"        
        verify.IDChildren = []

        if(params."License Type"){
            def path = "/..//following-sibling::*[contains(@class,'f-member-typeahead')][1]"
            switch(params."License Type"){
                case "Brightidea User":
                    verify.IDChildren << "./${path}//*[contains(@class,'f-brightidea-user')]//*[text()='${params."User"}']"
                    break
                case "Brightidea Administrator":
                    verify.IDChildren << "./${path}//*[contains(@class,'f-admin')]//*[contains(text(),'${params."User"}')]"
                    break
                case "Ideabox Manager":
        		    verify.IDChildren << "./${path}//*[contains(@class,'f-idea-box-bg-color')]//*[text()='${params."User"}']"
                    break
                case "No License":
        		    verify.IDChildren << "./${path}//*[normalize-space(@class)='react-tags__tag f-tag-wrapper']//*[contains(text(),'${params."User"}')]"
                    break
            }
        }
 
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)      
    }
}