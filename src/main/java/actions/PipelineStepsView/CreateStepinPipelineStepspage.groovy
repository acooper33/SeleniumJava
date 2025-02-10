package actions.PipelineStepsView;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SetFocus
import actions.selenium.SelectItem
import actions.selenium.VerifyElementState
import actions.selenium.VerifyText
import actions.selenium.VerifyAttribute
import java.util.NoSuchElementException;

class CreateStepinPipelineStepspage{
    
    public void run(def params){
        Click.run(ID:"//*[@id='create-step']", "Handle Stale Element":true)
        SetText.run(ID:"//*[@id='create_step_name']",Text:params."Step Name")
        SelectItem.run(ID:"//*[@id='new_step_type']","Visible Text":params."Select Tool Type")
        SelectItem.run(ID:"//*[@id='create_step_stage']","Visible Text":params."Select Stage")
        
        if(params."Create Stage Stage Name" || params."Create Stage Innovation State"){
            Click.run(ID:"//*[@id='create_stage_btn']")
            SetText.run(ID:"//*[@id='stage_name']",Text:params."Create Stage Stage Name")
            SelectItem.run(ID:"//*[@id='stage-state']","Visible Text":params."Create Stage Innovation State")
            //color picker, verify not showing, until we interact with it
            VerifyElementState.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class, 'color-picker-square')]/../DIV[contains(@class, 'color-picker-options')]", "Is Visible":false);
            //println("Debug: ${params."Background Color Code"} and ${params."or Select From Color Palette"}")
            setStageColorPicker("Color Code":params."Background Color Code", "Color Palette":params."or Select From Color Palette")
            Click.run(ID:"//SPAN[text()='Create Stage']/../..//*[@id='bi-modal-button']/SPAN[text()='Create']")
        }
        sleep(2000)
        if(params."Action"){
            if(params."Action"=="Cancel"){Click.run(ID:"//SPAN[text()='Create Step']/../..//*[text()='Cancel']")}
            else{Click.run(ID:"//SPAN[text()='Create Step']/../..//*[text()='Create']","Type of Click":"Javascript")}
            sleep(2000)
        }
        //if(params."Step Name" && params."Select Tool Type"){toggleModalIfNotOpen(params)}
        if(params."Select Tool Type"){toggleModalIfNotOpen(params)}
        
    }
    
    //workaround when the step config would not pop up after creating a new step
    public static void toggleModalIfNotOpen(def params){
        sleep(5000)
        if(Exists.run(ID:"//*[contains(@class,'fractal-modal-header')]")>0) {
            println("Step config modal has opened...")
        } else {
            println("Step config modal did not open... Using workaround")
            Click.run(ID:"//*[@id='step-refresh']")
           	sleep(1000)
            if(params."Step Name"==null){
                println("No step name provided, will use Step to Edit")
                SetStepDropdown.setDropdownOption("Step Name":params."Step to Edit","Step Dropdown Option":"Configure")
            }else{SetStepDropdown.setDropdownOption("Step Name":params."Step Name","Step Dropdown Option":"Configure")}            
        }
    }
    
    public static void setStageColorPicker(def params){
        if (params."Color Palette"==true){
           Click.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class,'color-picker-square')]")
           Click.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class, 'color-picker-square')]/../DIV[contains(@class, 'color-picker-options')]/UL[2]/LI[2]")
           sleep(1000)
           VerifyElementState.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class, 'color-picker-square')]/../DIV[contains(@class, 'color-picker-options')]", "Is Visible":false);
           VerifyText.run(ID:"//*[@id='color-picker-square-container']/INPUT", "Input Field Text":"#f8c9c5")
           VerifyAttribute.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class,'color-picker-square')]", "Attribute Name":'style', "Value":'background-color: rgb(248, 201, 197);')
        }else if (params."Color Code" == "default"){
        	VerifyText.run(ID:"//*[@id='color-picker-square-container']/INPUT", "Input Field Text":"#f0f0f0")
            VerifyAttribute.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class,'color-picker-square')]", "Attribute Name":'style', "Value":'background-color: rgb(240, 240, 240);')
        }else if(params."Color Code" == null){
            VerifyAttribute.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class,'color-picker-square')]", "Attribute Name":'style', "Value":'background-color: rgb(240, 240, 240);')
        }else{
            SetText.run(ID:"//*[@id='color-picker-square-container']/INPUT", Text:params."Color Code")
            VerifyAttribute.run(ID:"//*[@id='color-picker-square-container']/DIV[contains(@class,'color-picker-square')]", "Attribute Name":'style', "Value":'background-color: rgb(252, 148, 175);')
        }
	}
}