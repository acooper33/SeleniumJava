package actions.selenium


import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Keys

class SendKeyboardAction{
    public static void run(def params){
        
        //Unlike Click this will not check for if the element is displayed
		Actions action = new Actions(Browser.Driver);
        if(params."Button"=="SHIFT ENTER"){
            action.keyDown(Keys.SHIFT).sendKeys(Keys.ENTER).keyUp(Keys.SHIFT).build().perform() 
        } else if(params."Button"=="ENTER"){
            action.sendKeys(Keys.ENTER).build().perform()   
        }else if(params."Button"=="ESCAPE"){
            action.sendKeys(Keys.ESCAPE).build().perform()
        }else if(params."Button"=="PAGE DOWN"){
            action.sendKeys(Keys.PAGE_DOWN).build().perform()
        } else if(params."Button"=="PAGE UP"){
            action.sendKeys(Keys.PAGE_UP).build().perform()
        } else {
            action.sendKeys(Keys.chord("${params."Button"}")).build().perform()
        }      
    }
}
