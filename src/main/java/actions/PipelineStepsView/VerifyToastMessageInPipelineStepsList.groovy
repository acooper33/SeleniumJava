package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import java.util.ArrayList

class VerifyToastMessageInPipelineStepsList{
    public void run(def params){
        String toastMes
        WebElement toast = Elements.find(ID:"//*[contains(@class,'bi-notify-message')]",Browser.Driver)
        toastMes = toast.getText()
        println("Toast message is ${toastMes}")
        assert toastMes.contains(params."Message"), "Error - ${toastMes} does not contain Expected ${params."Message"}"   
        if(params."Click on the link" == true){
            Click.run(ID:"//*[contains(@class,'bi-notify-message')]//A")
        }
    }
}