package actions.IdeaBoard;

import actions.selenium.Click

class ClearFilterOptionIdeaBoardpage30{
    public void run(def params){
        
        if(params."Clear Field"==true){
            Click.run(ID:"//*[@class='fractal-input-clear']/I")
            sleep(3000)
        }
        if(params."Option Name"){
            println("Option name: ${params."Option Name"}")
            Click.run(ID:"//*[@class='tab-header-title' and text()='${params."Option Name"}']/../..//span[text()='Clear']")
        }
        
    }
}