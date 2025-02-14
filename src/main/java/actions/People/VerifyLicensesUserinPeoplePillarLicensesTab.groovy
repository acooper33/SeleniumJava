package actions.People;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.PeopleCommon
import actions.selenium.Exists

class VerifyLicensesUserinPeoplePillarLicensesTab{
    public void run(def params){
     
    	PeopleCommon.NavigateTab(Tab:"Licenses")
        def verify = [:]
        def license
        if(params."License Type"=="Brightidea Administrator License Type"){
         license = "admin"        
        } else if (params."License Type"=="Brightidea Moderator Licenses"){
         license = "moderator"
        }else {
         license = "idea-box-manager"
        }
 
        if(params."Expand License Breakdown"== true || params."Expand License Breakdown"== null){
            PeopleCommon.ExpandLicenseBreakdown(License:params."License Type")
        }  
        
        def path ="[@class='admin-left-column' and text()='${params."User"}']/../*[@class='admin-right-column' and .='${params."Roles"}']"       
        verify.ID ="//*[contains(@class,'${license}-license-container')]//*${path}"
    
        if(params."Placement Number") {
            verify.ID="//*[contains(@class,'${license}-license-container')]//*[contains(@class,'admin-item')][${params."Placement Number"}]//*${path}"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }    
    }
}