package actions.People;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*
import actions.common.PeopleCommon
import java.time.LocalDateTime 
import java.time.format.DateTimeFormatter 

class VerifyWhiteboardLicensesinUse{
    public void run(def params){
        
        if(params."Expand License Breakdown"== true || params."Expand License Breakdown"== null){
            PeopleCommon.ExpandLicenseBreakdown(License:"Whiteboard License Type")
        }  
        def verify = [:]
        verify.ID = "//*[@class='f-wb-col f-wb-unlimited']/preceding-sibling::LI//A[text()='${params."Licenses in Use"}']"
        verify.IDChildren = []
        if(params."Number of Whiteboards"){verify.IDChildren << "./..//SPAN[1][@class='f-wb-col' and text()='${params."Number of Whiteboards"}']"}
        if(params."Last Login"){
            def date
            if(params."Last Login" == "Todays date"){
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy")
                LocalDateTime now = LocalDateTime.now()
                date = dateFormat.format(now)
            } else { date = params."Last Login"}
            verify.IDChildren << "./..//SPAN[2][@class='f-wb-col' and text()='${date}']"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}        
        VerifyNumberOfMatches.run(verify) 
        
        if(params."Click on the User Name"){
            Click.run(verify)
        }
    }
}