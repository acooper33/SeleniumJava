package actions.PipelineManageSteps;

import actions.selenium.*

class SetEmailEvaluators{
    public void run(def params){
        
        sleep(5000)
         if(params."Select All"){
            if(params."Select All"==true){
                Click.run(ID:"//*[contains(@class,'f-email-evals-row')][1]/*[@class='f-checkbox']/DIV[not(contains(@class,'f-checkbox-checked'))]//input/..")
            } else {
                Click.run(ID:"//*[contains(@class,'f-email-evals-row')][1]/*[@class='f-checkbox']/DIV[contains(@class,'f-checkbox-checked')]//input/..")
            }
        } else if(params."Evaluators"){
            	params."Evaluators".split(",").eachWithIndex{ user, x ->
                	if(params."Check or Uncheck Evaluators".split(",")[x]=="Check"){
                   		Click.run(ID:"//*[@class='f-email-evals-display-name' and text()='${user}']/..//*[@class='f-checkbox']/DIV[not(contains(@class,'f-checkbox-checked'))]//input/..")
                	} else {
                    	Click.run(ID:"//*[@class='f-email-evals-display-name' and text()='${user}']/..//*[@class='f-checkbox']/DIV[contains(@class,'f-checkbox-checked')]//input/..")
                	}
            	}
        	}
        SetText.run(ID:"//*[@id='f-email-evals-subject']",Text:params."Subject")
        
        if(params."Description"){
            if(params."Click on Description Field"==null || params."Click on Description Field"==true){
                SetFocus.run(ID:"//*[@id='f-email-evals-body']/../DIV[2]")
            }            
            SetText.run(ID:"//*[@id='f-email-evals-body']/../DIV[2]",Text:params."Description","Type of Clear":"None")
            sleep(3000)
        }
                
        if(params."Dynamic Fields"){
            SetCombobox.run(ID:"//INPUT[@id='f-email-evals-dropdown']", Option:params."Dynamic Fields")
            sleep(1000)
            Click.run(ID:"//*[contains(@class,'f-email-evals-dynamic-add-btn')]")
            sleep(5000)
        }
        if(params."Click on Copy Evaluation Link"==true){
             Click.run(ID:"//*[@class='f-copy-link']/A")   
        } 
        if(params."Action"){
            if(params."Action"=="Send"){
              Click.run(ID:"//*[@data-test='modal-footer-submit']")  
            } else {
              Click.run(ID:"//*[@data-for='modal-close']")   
            }
        }
    }
}
