package actions.SetupUsers;

import actions.common.SetupCommon
import screens.SystemSetup.GroupCreationLocators 
import actions.selenium.utils.VerifyNumberOfMatches
import org.openqa.selenium.By

class VerifyGroupsintheList{
    public void run(def params){
        
        GroupCreationLocators.run(params)
        if(params."Navigate to Groups Tab"){
            if(params."Navigate to Groups Tab"==true){
                if(params."Enterprise or Site"=="Site"){
                    SetupCommon.NavigateTab(Tab:"Users",Section:"Groups")
                } else {
                    SetupCommon.NavigateTab(Tab:"Users",Section:"EnterpriseSetupGroups")
                }                
            }
        }
     	def verify = [:] 
        verify.ID = GroupCreationLocators.groupList
        verify.IDChildren = []
        // Handle the Placement Number condition
        if(params."Placement Number") {
            // Create a dynamic XPath using the Placement Number
            verify.ID = GroupCreationLocators.groupListWithPlacementNumber.toString().replace("By.xpath: ", "")
        } else {
            verify.ID = GroupCreationLocators.groupList.toString().replace("By.xpath: ", "")
        }  
       // Debugging output
        if (params."Number of Matches") {
            verify."Number of Matches" = params."Number of Matches".toInteger()
        }
        
        // Verify number of matches
        VerifyNumberOfMatches.run(verify)
    }
}
