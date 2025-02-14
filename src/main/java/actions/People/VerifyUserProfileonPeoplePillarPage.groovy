package actions.People;

import actions.selenium.utils.VerifyNumberOfMatches
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class VerifyUserProfileonPeoplePillarPage{
    public void run(def params){
        
        //Map all values that will be used for verification for that instance
        sleep(2000)
        def verify = [:]
        verify.ID = "//*[@id='people-content']"        
        verify.IDChildren = []
        if(params."Member Image"!=null){
            def img
            if(params."Member Image"){img = "/IMG[contains(@src,'/ct/getfile.php')]"}
            else{img = "/IMG[contains(@src,'/CORE/IMAGES/profile')]"}
            verify.IDChildren << ".//*[@id='member-top-info-container']${img}"
        }
        
        if(params."Screen Name"){verify.IDChildren << ".//*[@id='member-top-info-container']//*[.='${params."Screen Name"}']"}
        if(params."Deactivated By Admin"){
			LocalDate today = LocalDate.now();
            def date = today.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            verify.IDChildren << ".//*[@id='member-top-info-container']//*[.='${params."Email"} (Deactivated ${date} by ${params."Deactivated By Admin"})']"
        } else {
            if(params."Email"){verify.IDChildren << ".//*[@id='member-top-info-container']//*[normalize-space(.)='${params."Email"}']"} 
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
    }
}
