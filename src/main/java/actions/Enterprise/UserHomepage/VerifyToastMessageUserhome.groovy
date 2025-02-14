package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class VerifyToastMessageUserhome{
    public void run(def params){
        
        WebElement toast = Elements.find(ID:"//*[contains(@class,'fractal-toast')]",Browser.Driver)
        String toastMes = toast.getText()
        println("Toast message is ${toastMes}")
        assert toastMes.contains(params."Message"), "Error - ${toastMes} does not contain Expected /'${params."Message"}/'"
                
        if(params."Click on Idea Code" == true){
            Click.run(ID:"//*[contains(@class,'fractal-toast  success')]//A")
        }        
    }
}