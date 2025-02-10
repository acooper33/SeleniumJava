package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.MouseOver
import actions.selenium.ExplicitWait

class CreateWhiteboardFromUserhome{
    public void run(def params){
        def xpath = ""
        if(params."From Userhome or from Add Template Modal"=="Add Template Modal"){
            println("From the modal")
            xpath = "//DIV[contains(@class,'f-modal-body')]"
        }
        if (params."Create New or Choose Template"){
            Click.run(ID:xpath + "//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Create New or Choose Template"}']/../..//DIV[contains(@class,'f-thumbnail')]")
            //Click.run(ID:"//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Create New or Choose Template"}']/../..//DIV[contains(@class,'f-thumbnail')]")
            //if(params."Should it wait for page to load" == true || params."Should it wait for page to load" == null){
            if(params."Should it wait for page to load" == true){
                ExplicitWait.run(ID:"//*[@id='f-share-dialog-btn']") 
                sleep(2000)
            }           
        }
        if(params."Edit Custom Template"){
        	MouseOver.run(ID:xpath + "//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Edit Custom Template"}']/../..//DIV[contains(@class,'f-thumbnail')]")
            MouseOver.run(ID:xpath + "//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Edit Custom Template"}']/../..//DIV[contains(@data-test,'f-test-dropdown')]")
            Click.run(ID:xpath + "//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Edit Custom Template"}']/../..//DIV[contains(@data-test,'f-test-dropdown')]")
            Click.run(ID:xpath + "//UL[contains(@class,'f-dropdown-options')]/LI//SPAN[contains(.,'Edit Template...')]")
        }
        
    }
}