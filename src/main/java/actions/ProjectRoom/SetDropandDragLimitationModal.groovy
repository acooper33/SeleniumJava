package actions.ProjectRoom;

import actions.selenium.Exists
import actions.selenium.Click

class SetDropandDragLimitationModal{
    public void run(def params){
        
        assert Exists.run(ID:"//*[contains(@class,'f-rooms-remove-main') and text()='Would you like to remove sorting so you can drag and drop?']")==1, "Error - Incorrect message displayed"
        if(params."Action"=="Remove Sorting"){
            Click.run(ID:"//*[@id='f-modal-submit']/SPAN[text()='Remove Sorting']")
        } else {
            Click.run(ID:"//*[@data-test='modal-footer-cancel']") 
        }        
    }
}