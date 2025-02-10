package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class WhiteboardSetMoveTool{
    public void run(def params){
        if(params."Select Mode"){
            println("Selecting Mode ${params."Select Mode}"}")
            Click.run(ID:"//DIV[@class='f-move-options']/I[contains(@data-for,'${params."Select Mode"}')]")
            sleep(500)
        }
    }
}