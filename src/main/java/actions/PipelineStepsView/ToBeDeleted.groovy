package actions.PipelineStepsView;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem

class ToBeDeleted{
    public void run(def params){
        
      	for(int i = 82;i <= 99;i++){
        Click.run(ID:"//*[@id='create-step']")
        SetText.run(ID:"//*[@id='create_step_name']",Text:"New Step ${i}")
        //SelectItem.run(ID:"//*[@id='new_step_type']","Visible Text":params."No Tool Selected")
        SelectItem.run(ID:"//*[@id='create_step_stage']","Visible Text":"Stage2")
        sleep(2000)
        Click.run(ID:"//SPAN[text()='Create Step']/../..//*[text()='Create']","Type of Click":"Javascript")
        }
    }
}