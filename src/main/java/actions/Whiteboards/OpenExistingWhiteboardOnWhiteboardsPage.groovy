package actions.Whiteboards;

import actions.selenium.Click

class OpenExistingWhiteboardOnWhiteboardsPage{
    public void run(def params){
        if(params."Tab"){
            Click.run(ID:"//*[@class='f-tabs-header-container']//DIV[contains(@class,'f-tab')]//SPAN[contains(.,'${params."Tab"}')]")
        }
        if(params."Name of Whiteboard"){
            Click.run(ID:"//*[@class='f-canvases-grid']//*[contains(text(),'${params."Name of Whiteboard"}')]")
             sleep(9000)
        }
    }
}