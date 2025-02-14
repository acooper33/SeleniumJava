package actions.SetIdeaFields;

import actions.selenium.Click
import actions.selenium.Exists
import java.nio.file.Paths
import actions.selenium.SendKeys
import actions.selenium.ExplicitWait

class SetPostIdeaAttachment{
    public static void run(def params){
        if(params."Attachment File"){
            def os = System.getProperty("os.name").toLowerCase();
			def fileName
            params."Attachment File".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){
                    //Get path to file we are sending
                    if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ //linux
                        fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${name}"
                    }else{ // windows
                        fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"
                    }
                    //Now send a file to the 'fallback_input' element
                    SendKeys.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV//INPUT[contains(@id,'attachment-dropzone-input')]",Text:fileName)
                    if(params."Wait for Attachment to load"){
                    	if(params."Wait for Attachment to load".split(",")[x]==null || params."Wait for Attachment to load".split(",")[x]=="TRUE"){
                        	ExplicitWait.run(ID:"//*[text()='${name}']/../..//*[contains(@class,'hidden') and contains(@class,'f-file-progress-bar')]")
                    	}
                    }
                }
                else{
                    sleep(2000)
                    if(Exists.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV/parent::FIELDSET//A[text()='${name}']")>0){
                        Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV/parent::FIELDSET//A[text()='${name}']/parent::DIV/parent::DIV//I")
                    }
                    else{Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/parent::DIV//P[text()='${name}']/parent::DIV/parent::DIV//I")}
                }
            }
        }
    }
}