package actions.People;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*
import actions.common.PeopleCommon

class VerifyUsersUnderAdminswithUnlimited{
    public void run(def params){
        
        if(params."Expand License Breakdown"== true || params."Expand License Breakdown"== null){
            PeopleCommon.ExpandLicenseBreakdown(License:"Whiteboard License Type")
        }  
        def verify = [:]
        verify.ID = "//*[@class='f-wb-col f-wb-unlimited']//following-sibling::LI//*[@class='f-wb-col' and text()='${params."User Name"}']"
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}        
        VerifyNumberOfMatches.run(verify) 
        
        if(params."Click on the User Name"){
            Click.run(verify)
        }
    }
}