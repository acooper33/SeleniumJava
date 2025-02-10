package actions.PipelineSetup;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.ExplicitWait
import actions.selenium.SetCheckBox
import org.openqa.selenium.StaleElementReferenceException;

class CreateEmptyTemplateScorecardsTemplates{
    public void run(def params){
        if(params."Template Title"){
            ExplicitWait.run(ID:"//*[@id='new-template-btn']")
            try {
            	Click.run(ID:"//*[@id='new-template-btn']", "Type of Click":"Javascript")
        	} catch (StaleElementReferenceException e) {
            	System.out.println("Stale element encountered. Retrying...")
				sleep(1000)
                Click.run(ID:"//*[@id='new-template-btn']", "Type of Click":"Javascript")
        	}
            //Click.run(ID:"//*[@id='new-template-btn']", "Type of Click":"Javascript")
            ExplicitWait.run(ID:"//*[@id='generic-message-popup']")
            SetText.run(ID:"//*[@id='generic-message-popup']//INPUT[@id='input-box']", Text:params."Template Title")
        	if(params.Action=="Cancel"){Click.run(ID:"//*[@id='generic-message-popup']//A[text()='Cancel']")}
        	else{Click.run(ID:"//*[@id='generic-message-popup']//*[@id='bi-modal-button']")}
        }
        if(params."Go Back"==true){Click.run(ID:"//*[@id='back-btn']")}
        if(params."Available for all Initiatives"){SetCheckBox.run(ID:"//*[@id='scorecards-shared']/input",Check:params."Available for all Initiatives")}
        sleep(1000)
    }
}