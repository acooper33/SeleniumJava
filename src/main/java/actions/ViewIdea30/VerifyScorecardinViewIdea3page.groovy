package actions.ViewIdea30;

import java.time.format.DateTimeFormatter  
import java.time.LocalDateTime
import java.time.LocalDateTime    
import actions.selenium.Exists
import actions.selenium.Click

class VerifyScorecardinViewIdea3page{
    public void run(def params){
        
        if(params."Completed Message"==true){
           assert Exists.run(ID:"//*[contains(@class,'f-action-items-wrapper') and contains(.,'Completed!')]")==1, "Error - Completed message not displayed"
        }  
        if(params."Click on View Completed Link"==true){
           Click.run(ID:"//*[contains(@class,'f-view-completed') and text()='View Completed']")
            sleep(2000)
        }
        if(params."Completed On"==true){
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy")
            LocalDateTime now = LocalDateTime.now()
            def date = dateFormat.format(now)
            println(dateFormat.format(now))
            assert Exists.run(ID:"//*[@class='f-completed-label']/*[text()='Completed on ${date}']")==1, "Error - Completed label is not showing the correct date"
        }
        if(params."View Complete Scorecard" == true){
           Click.run(ID:"//*[contains(@class,'f-btn-standard f-btn-sm f-action-btn')]") 
        }        
    }
}