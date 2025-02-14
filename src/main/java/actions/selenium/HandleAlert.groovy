package actions.selenium;

import org.openqa.selenium.Alert

class HandleAlert{
    public static run(def params){
        println("In Handle Alert")
        Alert alert = Browser.Driver.switchTo().alert()
        if(params."Accept"==true){
            alert.accept()
            println("Accepting Alert")
        }else if(params."Accept"==false){
            alert.dismiss()
            println("Dismissing Alert")
        }
    }
}