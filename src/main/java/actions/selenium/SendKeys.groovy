package actions.selenium

import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement

class SendKeys{

    public static void run(def params){
        //Look up http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/Keys.html for key names
        
        WebElement element = Elements.find(params,Browser.Driver)

        if(params.Text != null){
            element.sendKeys(params."Text")    
        }

        if(params.Key != null){
            Binding binding = new Binding()
            binding.setVariable("key", null)
            GroovyShell shell = new GroovyShell(binding)
            shell.evaluate("key = org.openqa.selenium.Keys.${params.Key}")

            element.sendKeys(binding.getVariable("key"))
        }
    }
}