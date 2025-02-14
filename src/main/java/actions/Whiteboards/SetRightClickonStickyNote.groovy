package actions.Whiteboards;

import actions.selenium.*
import org.openqa.selenium.interactions.Actions
import screens.WhiteboardLocators


class SetRightClickonStickyNote{
    public void run(def params){
        
        if(params."Right Click on Sticky Note"==true || params."Right Click on Sticky Note"==null){
            Actions builder = new Actions(Browser.Driver)
            builder.contextClick().build().perform()  
        }
        if(params."Add to pipeline"){
            if(params."Click on Add to pipeline"==true || params."Click on Add to pipeline"==null){
                Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Send to pipeline...']/..")
            }
            //cannot use it, deletes the object on WBs
            //SetCombobox.run(ID:"//*[contains(@id,'f-canvas-select-initiative')]", Option:params."Add to pipeline")
            Click.run(ID:"//*[contains(@id,'f-canvas-select-initiative')]")
        	sleep(1000)
            Click.run(ID:"//*[@id='f-combobox-list']//*[text()='${params."Add to pipeline"}']")
            sleep(1000)
            
            if(params."Select Pipeline Category"){
                //cannot use on WBs
                //SetCombobox.run(ID:"//*[contains(@id,'f-canvas-select-category')]",Option:params."Select Pipeline Category")
                Click.run(ID:"//*[contains(@id,'f-canvas-select-category')]")
        		sleep(1000)
            	Click.run(ID:"//*[@id='f-combobox-list']//*[text()='${params."Select Pipeline Category"}']")
            	sleep(1000)
            }
            //Click.run(ID:"//*[contains(@id,'f-canvas-select-initiative')]")
        	//sleep(3000)
            //Click.run(ID:"//*[@id='f-combobox-list']//*[text()='${params."Add to pipeline"}']")
            //sleep(4000)
            
            if(params."Add to pipeline Action"=="Add"){
                Click.run(ID:"//*[@data-test='modal-footer-submit']")
            } else {
                 Click.run(ID:"//*[@data-test='modal-footer-cancel']")
             }
        }
        if(params."View idea details"==true){
          Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='View idea details...']")  
        }
        if(params."Unlink from pipeline"==true){
          Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Unlink from pipeline']/..")   
        }
        if(params."Change category"==true){
            Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[not(contains(@class,'f-disabled')) and text()='Change category...']")
        }
        if(params."Add Tags"==true){
            Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[not(contains(@class,'f-disabled')) and text()='Add tags...']")
        }
        if(params."Lock"==true){
            Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[not(contains(@class,'f-disabled')) and text()='Lock']")
        }
       	if(params."Unlock"==true){
            Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[not(contains(@class,'f-disabled')) and text()='Unlock']")
        }
        if(params."Send to back"==true){
            SetFocus.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI/SPAN[starts-with(.,'Send to back')]")
            Click.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI/SPAN[starts-with(.,'Send to back')]")
        }
        if(params."Bring to front"==true){
            SetFocus.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI/SPAN[starts-with(.,'Bring to front')]")
            Click.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI/SPAN[starts-with(.,'Bring to front')]")
        }
        if(params."Group selection"==true){
            Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[not(contains(@class,'f-disabled')) and text()='Group selection']")
        }
        if(params."Ungroup selection"==true){
            Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[not(contains(@class,'f-disabled')) and text()='Ungroup selection']")
        }
        if(params."Link to selected object"==true){
            SetFocus.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI[contains(.,'Copy link to object location')]")
            Click.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI[contains(.,'Copy link to object location')]")
        }
        if(params."Add link to selected object"==true){
            SetFocus.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI[contains(.,'Add link to selected object')]")
            Click.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI[contains(.,'Add link to selected object')]")
        }
        if(params."Export as CSV"==true){
            SetFocus.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI[contains(.,'Export')]")
            Click.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI[contains(.,'Export')]")
            Click.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI[contains(.,'Export')]//UL[contains(@class,'sub-menu')]//LI//*[starts-with(.,'Export as CSV')]", "Type of Click":"Move to Element")
		}
        if(params."Break into Stacks"==true){
            SetFocus.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI[contains(.,'Break into Stacks')]")
            Click.run(ID:"//UL[contains(@class,'f-canvas-right-click-menu')]/LI/SPAN[starts-with(.,'Break into Stacks')]")
        }
        if(params."Copy"==true){
            SetFocus.run("ID Type":"By",By:WhiteboardLocators.rightClick_Copy)
            Click.run("ID Type":"By",By:WhiteboardLocators.rightClick_Copy)
            //SetFocus.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Copy']")
            //Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Copy']")
        }
        if(params."Copy as PNG"==true){ 
            SetFocus.run("ID Type":"By",By:WhiteboardLocators.rightClick_CopyAsPNG)
            Click.run("ID Type":"By",By:WhiteboardLocators.rightClick_CopyAsPNG)
            //SetFocus.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Copy as PNG']")
            //Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Copy as PNG']")
        }
        if(params."Paste"==true){
            SetFocus.run("ID Type":"By",By:WhiteboardLocators.rightClick_Paste)
            Click.run("ID Type":"By",By:WhiteboardLocators.rightClick_Paste)
            //SetFocus.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Paste']")
            //Click.run(ID:"//*[contains(@class,'f-canvas-right-click-menu')]//*[text()='Paste']")
        }
    }
}

       