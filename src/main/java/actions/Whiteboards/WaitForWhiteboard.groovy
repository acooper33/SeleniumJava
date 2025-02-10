package actions.Whiteboards;

import actions.selenium.WaitForElement
import screens.WhiteboardLocators


class WaitForWhiteboard{
    public void run(def params){
        
        String timeout = "10"
        // Wait for an element in the WB Header panel to become available
    	WaitForElement.run("ID Type":"By",By:WhiteboardLocators.header_ShareButton, "Timeout In Seconds":timeout)
        
        // This is what CreateWhiteboardFromUserhome.groovy uses, but it doesn't support the screen locators
        //ExplicitWait.run(ID:"//*[@id='f-share-dialog-btn']") 
        //sleep(2000)
    }
}