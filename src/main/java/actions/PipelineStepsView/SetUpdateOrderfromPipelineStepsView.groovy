package actions.PipelineStepsView;

import actions.PipelineStepsView.SetStepDropdown

class SetUpdateOrderfromPipelineStepsView{
    public void run(def params){
        
        SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Update ${params."Tool Type"} Order")
        sleep(3000)
        
    }
}