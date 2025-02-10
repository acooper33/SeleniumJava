package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.SetText

class WhiteboardSetZoom{
    public void run(def params){
        if(params."Click on Zoom button"=='-'){Click.run(ID:"//*[contains(@class,'f-canvas-top-bar-right')]//*[@class='f-top-bar-zoom-menu']/BUTTON[1]")}
        if(params."Click on Zoom button"=='+'){Click.run(ID:"//*[contains(@class,'f-canvas-top-bar-right')]//*[@class='f-top-bar-zoom-menu']/BUTTON[3]")}
        if(params."Click on Zoom button"=='Center'){Click.run(ID:"//*[contains(@class,'f-canvas-top-bar-right')]//*[@class='f-top-bar-zoom-menu']/*[@id='f-zoom-menu-display-btn']")}
        if(params."Enter %"){
            SetText.run(ID:"//*[contains(@class,'f-canvas-top-bar-right')]//*[@class='f-top-bar-zoom-menu']//UL/LI/INPUT[contains(@class,'f-zoom-menu-input-option')]", Text:params."Enter %")
        	//need to add ctrl a before entering text
        }
        if(params."Option"){Click.run(ID:"//*[contains(@class,'f-canvas-top-bar-right')]//*[@class='f-top-bar-zoom-menu']//UL/LI//DIV[@class='f-menu-item']//*[starts-with(.,'${params."Option"}')]")}
    }
}