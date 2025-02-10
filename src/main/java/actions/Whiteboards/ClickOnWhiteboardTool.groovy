package actions.Whiteboards;

import actions.selenium.Click

class ClickOnWhiteboardTool{
    public void run(def params){
        //updated on Jan 14
//        println("Running udpated script from Jan 14")
        sleep(5000)
        if(params."Click on ToolKit"){
            if(params."Click on ToolKit"==true){
               Click.run(ID:"//*[@id='f-canvas-left-toolbar-toolkit-btn']") 
            }
        }
        if(params."Tool Type"){
        	if(params."Tool Type"=="Move"){
            	Click.run(ID:"//DIV[contains(@class,'f-canvas-left-toolbar')]//I[contains(@class, 'fal fa-mouse-pointer')]/..")
        	} else{
          	   Click.run(ID:"//DIV[contains(@class,'f-canvas-left-toolbar')]//BUTTON[contains(@data-tooltip-content, '${params."Tool Type"}')]") 
            }
        }        
        sleep(2000)
    }
}