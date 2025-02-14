package actions.Whiteboards;

import actions.selenium.Click

class WhiteboardSetMoveTool{
    public void run(def params){
        if(params."Select Mode"){
            println("Selecting Mode ${params."Select Mode}"}")
            Click.run(ID:"//DIV[@class='f-move-options']/I[contains(@data-for,'${params."Select Mode"}')]")
            sleep(500)
        }
    }
}