package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Exists
import actions.selenium.SetCombobox
import actions.selenium.SetReactDropdown
import actions.selenium.SetReactModal
import actions.Whiteboards.SetRightClickonSmartMatrix
import org.openqa.selenium.StaleElementReferenceException;

class SendIdeaToWhiteboardFromPipelineSteps{
    public void run(def params){
        if(params."Send to Whiteboard or Smart Matrix" == null){params."Send to Whiteboard or Smart Matrix" = "Send to Whiteboard"}
        if (Exists.run(ID:"//*[@id='actions_dropdown']")==1){ //Pipeline Steps 
            Click.run(ID:"//*[@id='actions_dropdown']")
        	Click.run(ID:"//*[@id='action-send-to-whiteboard']")
        }
        if(Exists.run(ID:"//*[@class='f-best-idea-right-click-menu']")==1){ //Top Ideas
           Click.run(ID:"//UL/LI[starts-with(.,'${params."Send to Whiteboard or Smart Matrix"}')]")
        }
        sleep(500)        
        
        if(params."Existing Whiteboard or New Whiteboard".contains("New")){params."Existing Whiteboard or New Whiteboard"="New"}
        else {params."Existing Whiteboard or New Whiteboard"="Existing"}
        SetReactModal.setModalRadioButtonWithInput("Section xPath":"//DIV[@class='f-send-to-whiteboard-modal-container']", "Radio Option":params."Existing Whiteboard or New Whiteboard", Title:params."Whiteboard Title")

        if(params."Format"){
            Click.run(ID:"//DIV[@class='f-send-to-whiteboard-modal-container']//P[.='Format']/following-sibling::UL//LI//*[starts-with(.,'${params."Format"}')]/..//*[contains(@class,'f-radio-inner')]")
        }
        if(params."Sort by"){
            Click.run(ID:"//DIV[@class='f-send-to-whiteboard-modal-container']//P[.='Sort by']/following-sibling::UL//LI//*[starts-with(.,'${params."Sort by"}')]/..//*[contains(@class,'f-radio-inner')]")
        }
        if(params."Organized in"){
            Click.run(ID:"//DIV[@class='f-send-to-whiteboard-modal-container']//P[.='Organized in']/following-sibling::UL//LI//*[starts-with(.,'${params."Organized in"}')]")
        }
        if(params."Add Smart Matrix"){
            Click.run(ID:"//DIV[@class='f-send-to-whiteboard-modal-container']//P[.='Add Smart Matrix']/..//*[contains(@class,'checkbox-inner')]")  
        }
        if(params."Smart Matrix Name"){
            SetRightClickonSmartMatrix.run(params)
        }
        if(params."Connect to Initiative"){
            Click.run(ID:"//DIV[@class='f-send-to-whiteboard-modal-container']//P[.='Connect to Initiative']/..//*[contains(@class,'checkbox-inner')]")
        }
        if(params."Assign card to Submitter"){
            Click.run(ID:"//DIV[@class='f-send-to-whiteboard-modal-container']//P[.='Assign card to Submitter']/..//*[contains(@class,'checkbox-inner')]")
        }
        if(params."Add Assignee information"){
            Click.run(ID:"//DIV[@class='f-send-to-whiteboard-modal-container']//P[.='Add Assignee Information']/..//*[contains(@class,'checkbox-inner')]")
        }
        SetReactModal.setModalActionButton(Action:params.Action)
    }
}