package actions.PipelineSetup;
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SaveScorecardTemplateChangeImpactExistingActionItemsModal{
    public void run(def params){
        
        SetCheckBox.run(ID:"//input[@id='checkbox']",Check: true)
        
        if(params."Action"){
            if(params.Action=="Cancel"){
                Click.run(ID:"//a[@class='bimodal-secondary']")
            } else if(params.Action=="Close"){
            	Click.run(ID:"//a[@class='bimodal-close']")
            } else {
            	Click.run(ID:"//span[@class='green_btn_center']")
                sleep(2000)
            }
        }
        
    }
}