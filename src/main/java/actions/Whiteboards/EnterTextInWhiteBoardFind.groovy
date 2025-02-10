package actions.Whiteboards;

import screens.WhiteboardLocators
import actions.selenium.*
    
class EnterTextInWhiteBoardFind{
    public void run(def params){
    	
        // Clear Text
        if(params."ClearSearchTextFirst"){
        	Click.run("ID Type":"By",By:WhiteboardLocators.clearButton)
        }
        
        // Enter New Text
        SetText.run("ID Type":"By",By:WhiteboardLocators.searchTextField,Text:params."Text")
        
    }
}