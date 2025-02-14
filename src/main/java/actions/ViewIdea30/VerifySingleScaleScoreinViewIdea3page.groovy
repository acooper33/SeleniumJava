package actions.ViewIdea30;

import actions.selenium.Exists
import actions.selenium.Click

class VerifySingleScaleScoreinViewIdea3page{
    public void run(def params){
       
        if(params."Completed Message"==true){
           assert Exists.run(ID:"//*[contains(@class,'f-message')]/*[contains(.,'Completed!')]")==1, "Error - Completed message not displayed"
        }  
        if(params."Click on View Completed Link"==true){
           Click.run(ID:"//*[contains(@class,'f-view-completed') and text()='View Completed']")
        }
        if(params."Question"){
            assert Exists.run(ID:"//*[@class='f-single-complete' and text()='Completed']")==1, "Error - Completed label is missing"
            assert Exists.run(ID:"//*[@class='f-single-scale-question' and text()='${params."Question"}']/..//*[@class='f-rating-container']/*[not(contains(@class,'f-rating f-rating-unselected'))]/*[text()='${params."Score"}']")==1, "Error - Incorrect score displayed"           
        }       
    }
}