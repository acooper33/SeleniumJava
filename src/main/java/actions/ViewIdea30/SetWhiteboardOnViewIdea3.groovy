package actions.ViewIdea30;

import actions.selenium.SetCombobox
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.MouseOver
import actions.selenium.SetFocus
import org.openqa.selenium.StaleElementReferenceException;
import screens.common.ModalButtonLocators
import actions.selenium.SetReactModal

class SetWhiteboardOnViewIdea3{
    public void run(def params){
        
        // Flow to Add a whiteboard Dialog
        if(params."Add Whiteboard"){
            Click.run(ID:"//BUTTON[contains(@class,'f-add-whiteboard-btn')]")
            
            if(params."Whiteboard Title"){
                if(params."Existing or New"==null || params."Existing or New"=="Existing Whiteboard"){
                    SetReactModal.setModalRadioButtonWithInput("Section xPath":"//DIV[contains(@class,'whiteboard')]","Radio Option":"Existing Whiteboard", "Title":params."Whiteboard Title")
                } else {
                    SetReactModal.setModalRadioButtonWithInput("Section xPath":"//DIV[contains(@class,'whiteboard')]","Radio Option":"New Whiteboard", "Title":params."Whiteboard Title")
                }
        	}
            if(params."Action"){
                if(params."Action"=="Cancel"){
                    Click.run(ID:"//*[@id='f-add-select']/../../../../../..//DIV[@class='f-footer ']//BUTTON[@data-test='modal-footer-cancel']")
                } else if(params."Action"=="Close"){
                    Click.run(ID:"//*[@id='f-add-select']/../../../../../..//DIV[@class='fractal-modal-header ']//DIV[@data-for='modal-close']")
                }else {
                    Click.run(ID:"//*[@id='f-add-select']/../../../../../..//DIV[@class='f-footer ']//BUTTON[@id='f-modal-submit']")
                }
            }          
        }

        // Flow for Item in the menu option
        if(params."Menu Option"){
            SetFocus.run(ID:"//DIV[contains(@class,'f-component')]//SPAN[contains(@class,'f-component-title') and starts-with(.,'Whiteboard')]/../DIV[contains(@class,'f-whiteboard-container')]")
       		Click.run(ID:"//DIV[contains(@class,'f-component')]//SPAN[contains(@class,'f-component-title') and starts-with(.,'Whiteboard')]/../DIV[contains(@class,'f-whiteboard-container')]//DIV[@data-test='f-test-dropdown']")
            sleep(500)
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI/DIV[starts-with(.,'${params."Menu Option"}')]")
           
        }
    }
}