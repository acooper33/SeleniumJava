package actions.Whiteboards;

import actions.selenium.Click

class SetTimerWhiteboardPage{
    public void run(def params){
        if(params."Action"){
            // action = [play, pause, stop]
            Click.run(ID:"//*[@class='f-userhome-canvases']//*[contains(@class,'f-canvas-timer')]/DIV[contains(@class,'f-timer-buttons')]/DIV[contains(@data-tooltip-content,'${params."Action"}')]")
            if(params."Close/Minimize"==true){
                Click.run(ID:"//*[@class='f-userhome-canvases']//*[contains(@class,'f-canvas-timer')]//BUTTON[contains(@class,'f-close-btn-subtle')]")
            }
            
        }
        
    }
}