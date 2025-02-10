package actions.PipelineStepsView;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.PipelineStepsView.SetStepDropdown

class SetDuplicateStepinPipelineStepsView{
    public void run(def params){
        
      	SetStepDropdown.setDropdownOption("Step Name":params."Step to Edit","Step Dropdown Option":"Duplicate Step")
        SetText.run(ID:"//*[@id='f-duplicate-step-name']",Text:params."Step Name")
        SelectItem.run(ID:"//*[@id='select-stage-dropdown']","Visible Text":params."Select Stage")
        if(params."Action"=="Cancel"){Click.run(ID:"//*[@data-test='modal-footer-cancel']")}
        else{Click.run(ID:"//*[@id='f-modal-submit']")}
    }
}