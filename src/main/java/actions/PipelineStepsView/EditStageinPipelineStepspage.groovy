package actions.PipelineStepsView;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.selenium.VerifyElementState
import actions.selenium.VerifyAttribute
import actions.selenium.VerifyText
import actions.PipelineStepsView.CreateStepinPipelineStepspage

class EditStageinPipelineStepspage{
    public void run(def params){
                
        if(params."Stage to Edit"){
            Click.run(ID:"//DIV[contains(@class,'stage_name')]/DIV[text()='${params."Stage to Edit"}']/following-sibling::DIV[@class='edit_stage_icon']/I", "Type of Click":"Javascript")
        	VerifyElementState.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class, 'color-picker-square')]/../DIV[contains(@class, 'color-picker-options')]", "Is Visible":false);
        	setStageColorPicker("Color Code":params."Background Color Code", "Color Palette":params."or Select From Color Palette")
        }
        if(params."Stage Name"){
            SetText.run(ID:"//INPUT[@id='stage_name']", Text:params."Stage Name")
        }
        if(params."Innovations State"){
            SelectItem(ID:"//SELECT[@id='stage-state']", "Visible Text":params."Innovations State")
        }        
        if(params.Action=='Save'){
            Click.run(ID:"//*[@id='bi-modal-button']")
            sleep(2000)
        }
        if(params.Action=='Cancel'){
            Click.run(ID:"//A[text()='Cancel']")
        }       
    }
    
    public static void setStageColorPicker(def params){
        if (params."Color Code"){
           SetText.run(ID:"//*[@id='color-picker-square-container']/INPUT", Text:params."Color Code")
        }
        else if (params."Color Palette"==true){
           Click.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class,'color-picker-square')]")
           Click.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class, 'color-picker-square')]/../DIV[contains(@class, 'color-picker-options')]/UL[3]/LI[3]")
           sleep(1000)
           VerifyElementState.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class, 'color-picker-square')]/../DIV[contains(@class, 'color-picker-options')]", "Is Visible":false);
           VerifyText.run(ID:"//*[@id='color-picker-square-container']/INPUT", "Input Field Text":"#fad7a0")
           VerifyAttribute.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class,'color-picker-square')]", "Attribute Name":'style', "Value":'background-color: rgb(250, 215, 160);')
        }
    }
    
}