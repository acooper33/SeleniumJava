package actions.ProjectRoom;

import actions.selenium.Click
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import java.util.ArrayList

class VerifyToastMessageinTasksInProjectRoom{
     public void run(def params){
         if(params."Message"){
            String toastMes
        	WebElement toast = Elements.find(ID:"//*[contains(@class,'success')]",Browser.Driver)
        	toastMes = toast.getText()
        	println("Toast message is ${toastMes}")
        	assert toastMes.contains(params."Message"), "Error - ${toastMes} does not contain Expected ${params."Message"}"    
         }        
        if(params."Click on the link" == true){
            Click.run(ID:"//*[contains(@class,'success')]//A")
        }
        if(params."Click on Undo" == true){
            Click.run(ID:"//*[contains(@class,'success')]//span[text()='Undo']")
        }
    }
}