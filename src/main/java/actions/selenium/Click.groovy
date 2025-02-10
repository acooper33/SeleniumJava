package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.StaleElementReferenceException;

class Click{  
    public static void run(def params){
        if(params."Handle Stale Element"==true){
            clickWithStaleElementHandling(params)
        }else{
        if(params){
            //ID
            //IDChildren (optional)
            //"ID Type" (optional, XPath default)
            //Instance (optional, integer) = Instance to click on if multiple ones are returned (starting with 1), if not specified it will always click on the first one
            //"Type of Click" (optional, Regular by default) = Regular, Move to Element, Javascript
            println("Click Params ID Type: ${params."ID Type"}, Click Params By: ${params."By"}, Click Params ID: ${params."ID"}")

            def element = Elements.find(params,Browser.Driver)
            if(params.IDChildren || params.Instance){
                if(params.Instance==null){params.Instance=0}
                println("Instance: ${params.Instance}")
                element = Elements.findAll(params,Browser.Driver)[params.Instance-1]
                //println("Instance: ${params.Instance}")
                assert element!=null,"Error - Element instance doesn't exist so it cannot be clicked on"
            }         
            
            if(!params."Type of Click"){params."Type of Click"="Regular"}
            int iTimeout = 10
            while(iTimeout > 0){
                //If its a type of click which is Javascript, then no need to go through isDisplayed process since it might be hidden
                if(params."Type of Click"=="Javascript"){
                    println("Javascript Click Recognized")
                    JavascriptExecutor executor = (JavascriptExecutor) Browser.Driver 
                    executor.executeScript("arguments[0].click();", element)
                    return
                }
                else if(element.isDisplayed()){
                    try{
                        println("Element is displayed: ${params.ID}")
                        if(params."Type of Click"=="Move to Element"){
                            Actions action = new Actions(Browser.Driver)
                            action.moveToElement(element).click().perform()
                        }
                        if(params."Type of Click"=="Regular"){
                            println("Trying to click: ${params.ID}")
                            element.click()
                        }
                        return
                    }
                    catch(Exception | Error e){
                        iTimeout--
                        if(iTimeout == 0){
                            throw e
                        }
                        sleep(2000)
                    }
                }
                else{
                    iTimeout--
                    if(iTimeout == 0){
                        assert false,"Error - Element exists but is not displayed"
                    }
                    sleep(2000)        
                }
                println("Click Failed, going to try again: ${iTimeout}")
                element = Elements.find(params,Browser.Driver)          
            }
        }    
        }
    }
    private static clickWithStaleElementHandling(params){
        println("Click with Stale elem handling")
        params."Handle Stale Element"=false
        try {
			run(params)
		}catch (StaleElementReferenceException e){
			System.out.println("Stale element encountered. Retrying...")
			sleep(1000)
			run(params)
		}
    }
}