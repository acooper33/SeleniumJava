package actions.ProjectRoom;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class VerifyErrorToastMessageforFiles{
    public void run(def params){
          
        WebElement toast = Elements.find(ID:"//*[contains(@class,'fractal-toast')]",Browser.Driver)
        String toastMes = toast.getText()
        println("Toast message is ${toastMes}")
        assert toastMes.contains(params."Message"), "Error - ${toastMes} does not contain Expected ${params."Message"}"      
    }
}