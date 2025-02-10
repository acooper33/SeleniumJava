package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SendKeys
import java.nio.file.Paths

class ImportIdeasinPipelineStepspage{
    public void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        def fileName
        if(params."Download the Template - Sample Data Template"){
            Click.run(ID:"//A[@class='download_template' and text()='Sample Data Template']")
            sleep(7000)
        }else {
            //Get path to file we are sending
            if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ //linux
            	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."Idea Import File"}"
            }else{																//windows
              	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Idea Import File"}"  
            }
        	//def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Idea Import File"}"
        	//Now send a file to the 'attachment-uploader' element
        	SendKeys.run(ID:"//*[@id='attachment-input']",Text:fileName)
        	sleep(5000)
        	if(params."Action"){
            	if(params."Action"=="Import Ideas"){
                	Click.run(ID:"//*[@id='bi-modal-button']/span[text()='${params."Action"}']")
            	} else {Click.run(ID:"//*[@class='bimodal-secondary']")}
        	}
        	Click.run(ID:"//*[@id='bi-modal-button']/span[@class='green_btn_center']")
        	sleep(7000)
        }
    }
}