package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

class Exists{
    public static def run (def params){
        //ID = parent or only element we are looking for
        //Timeout (optional, integer) = How long to wait for before giving up, default timeout is 5 seconds
        //IDChildren (optional)
        //"ID Type" (optional, XPath default)
        //Instance (optional, integer) = Instance to click on if multiple ones are returned, if not specified it will always click on the first one
        //RETURNS: Integer, ammount of instances found (0 if no instances)
        
        //Set default timeout if one wasn't provided
        
        if(params."Timeout"==null){params."Timeout" = 5}
        Browser.Driver.manage().timeouts().implicitlyWait(params."Timeout", java.util.concurrent.TimeUnit.SECONDS)

        //No matter what we need to deal with ID as an only element or a parent element
        def element
        try{element = Elements.find(params,Browser.Driver)}
        catch(e){
            Browser.Driver.manage().timeouts().implicitlyWait(50, java.util.concurrent.TimeUnit.SECONDS)
            println("Element not found, here is the exception: ${e}")
            return 0
        }
        Browser.Driver.manage().timeouts().implicitlyWait(50, java.util.concurrent.TimeUnit.SECONDS)
        if(params."Is Displayed" || params."Is Displayed"==null){
            try{
                if(!element.isDisplayed()){
                	println("Element not displayed")
                	return 0
            	}
            }catch (StaleElementReferenceException e){
                System.out.println("Stale element encountered. Retrying...")
				sleep(2000)
                if(!element.isDisplayed()){
                	println("Element not displayed")
                	return 0
            	}
            }
        }
        
        def elements = Elements.findAll(params,Browser.Driver)
        /*elements.each{
           println("********")
            println{ "${it.getAttribute('textContent')}"}
        }*/
        //println("elements.size()")
        //println(elements.size())
        
        return elements.size()
    }
}