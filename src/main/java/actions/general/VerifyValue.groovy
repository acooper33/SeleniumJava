package actions.general;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement


class VerifyValue{
    public void run(def params){
        def exists = false
        for(int i = 1;i <= 3;i++){
            def allElements = Elements.findAll(ID:"//*[contains(@value,\"${params."Value"}\")]",Browser.Driver)
            allElements.each{
                if(exists == true){return}
                if(it.isDisplayed()){exists = true}
            }
            if(exists == true){break}
            sleep(2000)
        }

        assert exists==params."Should Exist","Error - Value expected to be ${params."Should Exist"} but is actually ${exists}"
        
    }
}