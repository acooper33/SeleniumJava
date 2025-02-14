package actions.Whiteboards;

import actions.selenium.SetText
import actions.selenium.SendKeyboardAction
import actions.selenium.SetFocus
import actions.selenium.Click
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import actions.selenium.MouseOver
import actions.selenium.Browser

class SetRightSideControlsWhiteboard{
    public void run(def params){
        
        if(params."X"){
            SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-position-x')]")
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-position-x')]", "Text":params."X")
        }
        if(params."Y"){
            SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-position-y')]")
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-position-y')]", "Text":params."Y", "Type of Clear":"Backspace")
        }
        if(params."W"){
            SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-size-w')]")
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-size-w')]", "Text":params."W", "Type of Clear":"Backspace")
            SendKeyboardAction.run("Button":"ENTER")
        }
        if(params."H"){
            SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-size-h')]")
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-size-h')]", "Text":params."H")
        }
        if(params."R"){
            SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-rotate')]")
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-rotate')]", "Text":params."R")
        }
        if(params."Update Rounded Corner"==true){
            Click.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-border-heading-container')]//*[contains(@data-tooltip-content,'Update Rounded Corner')]")
        	SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-border-heading-container')]//*[contains(@data-tooltip-content,'Update Rounded Corner')]")
        }
        if(params."Rounded Corners Radius"){
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-corner-radius')]", "Type of Clear":"Backspace", "Text":params."Rounded Corners Radius")
        }
        if(params."Fill Color"=="TRANSPARENT"){
            Click.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-canvas-control-section')]//*[.='Fill' or .='Sticky Fill' or .='Background Color' or .='Card Color']/../..//*[contains(@class,'f-color-picker-group')]", "Type of Clear":"Backspace", "Text":params."Fill Color")
            SetFocus.run(ID:"//DIV[@class='fractal-color-picker ']")
            Click.run(ID:"//DIV[@class='fractal-color-picker ']//DIV[contains(@title,'transparent')]")
        }else if(params."Fill Color"){
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-canvas-control-section')]//*[.='Fill' or .='Sticky Fill' or .='Background Color' or .='Card Color' ]/../..//*[contains(@id,'f-canvas-color')]", "Type of Clear":"Backspace", "Text":params."Fill Color")
       		SendKeyboardAction.run("Button":"ENTER")
        }
        if(params."Fill Color Opacity"){
            SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[.='Fill' or .='Sticky Fill' or .='Background Color' or .='Card Color' or .='Opacity']/../..//*[contains(@id,'f-canvas-opacity')]")
            def numOnly = params."Fill Color Opacity".replaceAll("%","")
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[.='Fill' or .='Sticky Fill' or .='Background Color' or .='Card Color' or .='Opacity']/../..//*[contains(@id,'f-canvas-opacity')]", "Text":params."Fill Color Opacity", "Type of Clear":"Backspace")
        	SendKeyboardAction.run("Button":"ENTER")
        }
        if(params."Line Width"){
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-line-width')]", "Text":params."Line Width")
            SendKeyboardAction.run("Button":"ENTER")
        }
        if(params."Add Border"==true){
            Click.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-border-heading-container')]//*[contains(@data-tooltip-content,'Add Border')]")
        }else if(params."Add Border"==false){
            Click.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-border-heading-container')]//*[contains(@data-tooltip-content,'Remove Border')]")
        }
        if(params."Border Color"){
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-border-heading-container')]/following-sibling::DIV[@class='f-canvas-control-content']//*[contains(@id,'f-canvas-color')]", "Type of Clear":"Backspace", "Text":params."Border Color")  
        }
        if(params."Border Width"){
            SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-border-heading-container')]/following-sibling::DIV[@class='f-canvas-control-content']//*[contains(@id,'f-canvas-border-width')]")
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-border-heading-container')]/following-sibling::DIV[@class='f-canvas-control-content']//*[contains(@id,'f-canvas-border-width')]", "Text":params."Line Width")   
        }
        if(params."Text Font"){
            SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-font-select')]")
            Click.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-font-select')]")
            sleep(2000)
            Click.run(ID:"//*[contains(@id,'f-combobox-list')]/DIV[contains(@class,'f-combobox-list-item')]//*[.='${params."Text Font"}']")
        }
        if(params."Font Color"){
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-canvas-textfill-control')]//*[contains(@id,'f-canvas-color')]", "Type of Clear":"Backspace", "Text":params."Font Color")
        }
        if(params."Font Color Opacity"){
            SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-canvas-textfill-control')]//INPUT[contains(@id,'f-canvas-opacity')]")
            SetText.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-canvas-textfill-control')]//INPUT[contains(@id,'f-canvas-opacity')]", "Type of Clear":"Backspace", "Text":params."Font Color Opacity")
            SendKeyboardAction.run("Button":"ENTER")
        }
        if(params."Font Size"){
            Click.run(ID:"//DIV[contains(@class,'f-slate-font-size-input')]//BUTTON[contains(@class,'f-combobox-dropdown-button')]/I[contains(@class,'f-combobox-caret')]")
            List <WebElement> listElem = Elements.findAll(ID:"//*[@id='f-combobox-list' and contains(@style, 'flex')]/*[contains(@class,'f-combobox-list-item')]",Browser.Driver)
            //println("List items size: ${listElem.size()}")
            List<String> strings = new ArrayList<String>();
			for(WebElement e : listElem){
    			strings.add(e.getText());
			}
            if(!strings.contains(params."Font Size")){
                //println("Value is not in the dropdown")
                SetText.run(ID:"//*[@id='f-slate-font-size-input']", Text:params."Font Size", "Type of Clear":"Backspace")
                SendKeyboardAction.run("Button":"ENTER")
            }else{
                MouseOver.run(ID:"//*[@id='f-combobox-list' and contains(@style, 'flex')]/*[contains(@class,'f-combobox-list-item') and starts-with(text(),'${params."Font Size"}')]")
            	Click.run(ID:"//*[@id='f-combobox-list' and contains(@style, 'flex')]/*[contains(@class,'f-combobox-list-item') and starts-with(.,'${params."Font Size"}')]")
            }
        }
        if(params."Bullets: unordered list"){
            Click.run(ID:"//*[contains(@class,'f-button-group')]/BUTTON[@data-tooltip-content ='Bullets: unordered list']")
        }
        if(params."Bullets: ordered list"){
            Click.run(ID:"//*[contains(@class,'f-button-group')]/BUTTON[@data-tooltip-content ='Bullets: ordered list']")
        }
        if(params."Arrow Section Left"){
            Click.run(ID:"//*[contains(@class,'f-canvas-arrow-section')]//*[contains(@class,'f-arrow-dropdown-left')]/*[contains(@class,'f-dropdown-btn')]")
            Click.run(ID:"//*[contains(@class,'f-canvas-arrow-section')]//*[contains(@class,'f-arrow-dropdown-left')]/UL[contains(@class,'f-dropdown-options')]/LI//*[contains(.,'${params."Arrow Section Left"}')]")
            
        }
        if(params."Arrow Section Right"){
            Click.run(ID:"//*[contains(@class,'f-canvas-arrow-section')]//*[contains(@class,'f-arrow-dropdown-right')]/*[contains(@class,'f-dropdown-btn')]")
            Click.run(ID:"//*[contains(@class,'f-canvas-arrow-section')]//*[contains(@class,'f-arrow-dropdown-right')]/UL[contains(@class,'f-dropdown-options')]/LI//*[contains(.,'${params."Arrow Section Right"}')]")
            
        }
        if(params."Send to pipeline"){
            if(params."Send to pipeline"==true){
                Click.run(ID:"//*[contains(@class,'f-btn-md f-btn-standard f-btn-pipeline')]")
            } 
        }
        if(params."Links - Add"){
            Click.run(ID:"//*[@class='f-canvas-control-section']/*[@class='f-link-heading-container' or @class='f-card-links-heading-container']/BUTTON")
            //Click.run(ID:"//*[contains(@class,'f-card-links-heading-container')]//BUTTON")
            /*if(params."Card Links - Add"){
                Click.run(ID:"//DIV[contains(@class,'f-userhome-canvases')]//DIV[@class='f-card-link-modal']//DIV[contains(@class,'fractal-modal-body')]//INPUT[@id='f-card-link-input']", "Type of Click":"Javascript")
                SetText.run(ID:"//DIV[contains(@class,'f-userhome-canvases')]//DIV[@class='f-card-link-modal']//DIV[contains(@class,'fractal-modal-body')]//INPUT[@id='f-card-link-input']", "Text":params."Card Links - Add")
                Click.run(ID:"//BUTTON[@id='f-card-link-OkButton']")
            }*/
 
        }
        if(params."Links to Trash"){
            params."Links to Trash".split(",").each{
            	//Click.run(ID:"//*[@class='f-link-heading-container' or @class='f-card-links-heading-container']/..//SPAN[contains(@class,'link-text') and SPAN[starts-with(text(),'${it}')]]/../BUTTON")
                Click.run(ID:"//*[@class='f-link-heading-container' or @class='f-card-links-heading-container']/..//DIV[contains(@class,'modify-btns')]/BUTTON[contains(@data-test,'delete-btn')]")
                //Click.run(ID:"//*[@class='f-card-links-heading-container']/..//SPAN[@class='f-card-link-text' and SPAN[starts-with(text(),'${it}')]]/../BUTTON")
            }
        }
        if(params."Link to Edit"){
        	//Click.run(ID:"//*[@class='f-card-links-heading-container']/..//SPAN[@class='f-card-link-text' and SPAN[starts-with(text(),'${params."Link to Edit"}')]]")
            Click.run(ID:"//*[@class='f-link-heading-container' or @class='f-card-links-heading-container']/..//SPAN[contains(@class,'link-text')]/SPAN[starts-with(text(),'${params."Link to Edit"}')]")
            //SetText.run(ID:"//DIV[contains(@class,'f-userhome-canvases')]//DIV[@class='f-card-link-modal']//DIV[contains(@class,'fractal-modal-body')]//INPUT[@id='f-card-link-input']", "Text":params."Links - Edit to this URL")
            //Click.run(ID:"//BUTTON[@id='f-card-link-OkButton']")
        }
        
        if(params."Assign User"){
            Click.run(ID:"//*[@class='f-card-assign-heading-container']//BUTTON")
            /*params."Assign User - Choose User".split(",").each{
                AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":"Choose user",User:it,"Add or Remove":"Add")
            }
            Click.run(ID:"//*[contains(@class,'f-footer')]/BUTTON[contains(@class,'f-btn-primary')]") */
        }
        if(params."Remove Assigned User"){
            params."Remove Assigned User".split(",").each{
            	Click.run(ID:"//*[@class='f-card-assign-heading-container']/..//DIV[@class='f-assign-member' and A[starts-with(text(),'${it}')]]/../BUTTON")
            }
        }
        if(params."Add Row Top"){
            Click.run(ID:"//DIV[contains(@class,'f-canvas-control-content')]/DIV[@class='f-add-btns']/BUTTON/SPAN[starts-with(.,'Add Row Top')]")
        }
        if(params."Add Row Bottom"){
            Click.run(ID:"//DIV[contains(@class,'f-canvas-control-content')]/DIV[@class='f-add-btns']/BUTTON/SPAN[starts-with(.,'Add Row Bottom')]")
        }
        if(params."Add Column Left"){
            Click.run(ID:"//DIV[contains(@class,'f-canvas-control-content')]/DIV[@class='f-add-btns']/BUTTON/SPAN[starts-with(.,'Add Column Left')]")
        }
        if(params."Add Column Right"){
            Click.run(ID:"//DIV[contains(@class,'f-canvas-control-content')]/DIV[@class='f-add-btns']/BUTTON/SPAN[starts-with(.,'Add Column Right')]")
        }
        /*if(params."Links - Add"==true){ // this is not working
            Click.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-link-heading-container')]//BUTTON")
            SetText.run(ID:"//DIV[contains(@class,'f-userhome-canvases')]//DIV[@class='f-card-link-modal']//DIV[contains(@class,'fractal-modal-body')]//INPUT[@id='f-card-link-input']", "Text":params."Add a URL")
            Click.run(ID:"//BUTTON[@id='f-card-link-OkButton']")
        }*/
        /*if(params."Links - Trash"==true){
        	Click.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-link-heading-container')]/following-sibling::DIV/BUTTON[2]")
        }*/
    }
}