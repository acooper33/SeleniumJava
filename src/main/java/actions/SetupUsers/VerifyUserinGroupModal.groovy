package actions.SetupUsers;

import actions.selenium.*
import screens.SystemSetup.GroupCreationLocators    
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyUserinGroupModal{
    public void run(def params){
        
        GroupCreationLocators.run(params)
        def verify = [:] 
        // Determine if the user is in the left or right rail
        if (params."User in Left or Right Rail" == "Left") {
            if(params."Placement Number") {
               //verify.ID = GroupCreationLocators.userOnLeftRailWithPlacementNumber.toString().replace("By.xpath: ", "") 
                //VerifyNumberOfMatches.run(verify)
                VerifyNumberOfMatches.run("ID Type":"By",By:GroupCreationLocators.userOnLeftRailWithPlacementNumber)
            } else {
                verify.ID = GroupCreationLocators.userOnLeftRail.toString().replace("By.xpath: ", "") 
            }
        } else {
            if(params."Placement Number") {
               //verify.ID = GroupCreationLocators.userOnRightRailWithPlacementNumber.toString().replace("By.xpath: ", "") 
               //VerifyNumberOfMatches.run(verify)
               VerifyNumberOfMatches.run("ID Type":"By",By:GroupCreationLocators.userOnRightRailWithPlacementNumber)

            } else {
                verify.ID = GroupCreationLocators.userOnRightRail.toString().replace("By.xpath: ", "") 
            }
        }
        verify.IDChildren = []
        if(params."Image"!=null){
            def img
            if(params."Image"==true){
                img = GroupCreationLocators.userMemberImage.toString().replace("By.xpath: ", "")
                // Following doesn't work, need to find elements from parent element see https://www.selenium.dev/documentation/webdriver/elements/finders/
                //assert Exists.run("ID Type":"By",By:GroupCreationLocators.userMemberImage)==1, "Failed to find GroupCreationLocators.userMemberImage"
            }
            else {
                img = GroupCreationLocators.userMemberInitial.toString().replace("By.xpath: ", "")
                // Following doesn't work, need to find elements from parent element see https://www.selenium.dev/documentation/webdriver/elements/finders/
                //assert Exists.run("ID Type":"By",By:GroupCreationLocators.userMemberInitial)==1, "Failed to find GroupCreationLocators.userMemberInitial"
            }
            verify.IDChildren << img
            
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)  
    }
}
