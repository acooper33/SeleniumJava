package actions.Whiteboards;

import actions.selenium.Click

class ClickOnPlaceImageTool{
    public void run(def params){
        Click.run(ID:"//DIV[@class='f-canvas-left-toolbar']//BUTTON[@data-tip='Place Image']")
    }
}