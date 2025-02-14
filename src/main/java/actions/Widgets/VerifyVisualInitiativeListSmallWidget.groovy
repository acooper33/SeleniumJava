package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyVisualInitiativeListSmallWidget{
    public void run(def params){
     def verify = [:]
        verify.ID = "//*[@id='visual-small-webstorms-list']//*[@class='vws-title redirect' and text()='${params."Initiative Title"}']"        
        verify.IDChildren = []
        if(params."Initiative Image"!=null){
            def img
            if(params."Initiative Image" == true){img = "/..//IMG[contains(@src,'/CT/getfile.php')]"}
            else{img = "/..//IMG[contains(@src,'/CORE/IMAGES/apps/')]"}
            verify.IDChildren << "${img}"
        }
        if(params."Placement Number"){
            verify.ID = "//*[@id='visual-small-webstorms-list']//*[@class='vms-webstorm'][${params."Placement Number"}]//*[@class='vws-title redirect' and text()='${params."Initiative Title"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }   
    }
}