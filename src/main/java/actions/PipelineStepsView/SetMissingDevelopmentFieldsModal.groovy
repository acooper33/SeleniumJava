package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.Exists

class SetMissingDevelopmentFieldsModal{
    public void run(def params){
        
        if(params."Missing Development Fields Count"){
           assert Exists.run(ID:"//*[@class='f-missing-dev-questions-modal-body']/*[contains(.,'${params."Missing Development Fields Count"} Development fields from this initiative are missing in the destination initiative.')]")==1, "Error - Development Field count is wrong"  
        }
        
        if(params."Select Radiobutton Selection"){
            Click.run(ID:"//*[contains(@class,'f-radio-wrapper') and .='${params."Select Radiobutton Selection"}']") 
        }
        
        if(params."Action"){
            if(params."Action"=="Cancel"){
               Click.run(ID:"//*[@class='f-missing-dev-questions-modal-body']/../..//*[@data-test='modal-footer-cancel']") 
            } else {
                Click.run(ID:"//*[@class='f-missing-dev-questions-modal-body']/../..//*[@data-test='modal-footer-submit']")
            }
        } 
    }
}