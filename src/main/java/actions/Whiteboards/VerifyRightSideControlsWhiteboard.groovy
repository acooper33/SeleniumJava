package actions.Whiteboards;

import actions.selenium.Exists
import actions.selenium.VerifyText
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import screens.WhiteboardLocators

class VerifyRightSideControlsWhiteboard{
    public void run(def params){
        Float valueFloat
        WebElement input
        String valueStr
        
        if(params."X"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-position-x') and starts-with(@value, '${params."X"}')]")==1), "Error - X is wrong"
        }
        if(params."Y"){
            assert diffAbs("//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-position-y')]", params."Y")<5, "Error - Y is wrong"
        }
        if(params."L or W"){
            assert diffAbs("//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-size-w')]", params."L or W")<5, "Error - L or W is wrong"
            //assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-size-w') and starts-with(@value, '${params."L or W"}')]")==1), "Error - L or W is wrong"
        }
        if(params."H"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-size-h') and @value = '${params."H"}']")==1), "Error - H is wrong"
        }
        if(params."R"){
            assert diffAbs("//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-rotate')]", params."R")<5, "Error - R is wrong"
        }
        if(params."Rounded Corners Radius"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-canvas-corner-container')]//INPUT[contains(@id,'f-canvas-corner-radius') and @value='${params."Rounded Corners Radius"}']")==1), "Error - Rounded Corners Radius is wrong"
        }
        if(params."Fill Color"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-color') and @value='${params."Fill Color"}']")==1), "Error - Fill Color is wrong"
        }
        if(params."Fill Color Opacity"){
            def numOnly = params."Fill Color Opacity".replaceAll("%","")
            //SetFocus.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//DIV[.='Fill' or .='Sticky Fill' or .='Background Color']/../..//*[contains(@id,'f-canvas-opacity')]")
            //assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-opacity') and @value = '${numOnly}']")==1), "Error - Fill Color Opacity is wrong"
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[.='Fill' or .='Sticky Fill' or .='Background Color' or .='Card Color' or .='Opacity']/../..//*[contains(@id,'f-canvas-opacity')and @value = '${numOnly}']")>0), "Error - Fill Color Opacity is wrong"
        }
        if(params."Line Width"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-line-width') and @value = '${params."Line Width"}']")==1), "Error - Line Width is wrong"
        }
        if(params."Border Color"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-border-heading-container')]/following-sibling::DIV[@class='f-canvas-control-content']//*[contains(@id,'f-canvas-color') and @value = '${params."Border Color"}']")==1), "Error - Border Color is wrong"
        }
        if(params."Border Width"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-border-heading-container')]/following-sibling::DIV[@class='f-canvas-control-content']//*[contains(@id,'f-canvas-border-width') and @value = '${params."Border Width"}']")==1), "Error - Border Width is wrong"
        }
        if(params."Text Font"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@id,'f-canvas-font-select') and @value ='${params."Text Font"}']")==1), "Error - Text Font is wrong"
        }
        if(params."Font Size"){
        	assert(Exists.run(ID:"//*[contains(@id,'f-slate-font-size-input') and contains(@value,'${params."Font Size"}')]")==1), "Error - Font Size is wrong"
        }
        if(params."Font Color"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-controls-container')]//*[contains(@class,'f-canvas-textfill-control')]/*[contains(@class,'f-canvas-color-control')]//INPUT[@id ='f-canvas-color' and @value='${params."Font Color"}']")==1), "Error - Font Color is wrong"
        }
        if(params."Bullets: unordered list"==true){
            assert (Exists.run(ID:"//*[contains(@class,'f-button-group')]/BUTTON[@data-tooltip-content ='Bullets: unordered list' and contains(@class,'selected')]")), "Error - Bullets: Unordered list not selected"
        }else if(params."Bullets: unordered list"==false){
            assert (Exists.run(ID:"//*[contains(@class,'f-button-group')]/BUTTON[@data-tooltip-content ='Bullets: unordered list' and not(contains(@class,'selected'))]")), "Error - Bullets: Unordered is selected"
        }
        if(params."Bullets: ordered list"==true){
            assert (Exists.run(ID:"//*[contains(@class,'f-button-group')]/BUTTON[@data-tooltip-content ='Bullets: ordered list' and contains(@class,'selected')]")), "Error - Bullets: Ordered list not selected"
        }else if(params."Bullets: ordered list"==false){
            assert (Exists.run(ID:"//*[contains(@class,'f-button-group')]/BUTTON[@data-tooltip-content ='Bullets: ordered list' and not(contains(@class,'selected'))]")), "Error - Bullets: Ordered is selected"
        }
        if(params."Arrow Section Left"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-arrow-section')]//*[contains(@class,'f-arrow-dropdown-left')]/*[contains(@class,'f-dropdown-btn')]/DIV/I[contains(@class,'${params."Arrow Section Left"}')]")==1),"Error - Arrow Left Section is Wrong"
        }
        if(params."Arrow Section Right"){
            assert(Exists.run(ID:"//*[contains(@class,'f-canvas-arrow-section')]//*[contains(@class,'f-arrow-dropdown-right')]/*[contains(@class,'f-dropdown-btn')]/DIV/I[contains(@class,'${params."Arrow Section Right"}')]")==1),"Error - Arrow Right Section is Wrong"
        }
        if(params."Assignee"){
            VerifyText.run("ID Type":"By",By:WhiteboardLocators.rightSidePanel_assignee,Text:params."Assignee")
        }
		if(params."Strikethrough"==true){
            assert(Exists.run(ID:"//*[contains(@class,'f-button-group')]/*[contains(@data-tooltip-content,'Strikethrough') and contains (@class,'f-btn-standard f-btn-sm f-selected')]")==1),"Error - Strikethrough button not enabled"
        } else if(params."Strikethrough"==false) {
            assert(Exists.run(ID:"//*[contains(@class,'f-button-group')]/*[contains(@data-tooltip-content,'Strikethrough') and not(contains(@class,'f-btn-standard f-btn-sm f-selected'))]")==1),"Error - Strikethrough button enabled but should not be enabled"
        }
        if(params."Crop"==true){
            assert(Exists.run(ID:"//*[contains(@class,'f-image-crop-btn')]")==1), "Error - Crop is not present"
        }
    }

    public static float diffAbs(def xpath, def expectedVal){
        Float valueFloat
        WebElement input
        String valueStr
        
        input = Browser.Driver.findElement(By.xpath(xpath));
        valueStr = input.getAttribute('Value')
        println("Our value: ${valueStr}")
        println("Expected ${expectedVal}")
        valueFloat=Float.parseFloat(input.getAttribute('Value'));
        def result = Math.abs(Float.parseFloat(expectedVal)-valueFloat)
        println("result -> ${result}")
		return Math.abs(Float.parseFloat(expectedVal)-valueFloat)
        
    }
}