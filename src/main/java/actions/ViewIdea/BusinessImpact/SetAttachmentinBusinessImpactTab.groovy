package actions.ViewIdea.BusinessImpact;

import actions.selenium.Click
import actions.selenium.Exists
import java.nio.file.Paths
import actions.selenium.SendKeys
import java.nio.file.Files

class SetAttachmentinBusinessImpactTab{
    public void run(def params){
        if(params.Section == "Non-Financial"){
            if(Exists.run(ID:"//*[@id='business-impact-tab-non-financial']/I[contains(@class,'fa-plus-square-o')]")==1){ 
                Click.run(ID:"//*[@id='business-impact-tab-non-financial']/I[contains(@class,'fa-plus-square-o')]")}
        }
        if(params."Add or Delete" == "Add"){
            def os = System.getProperty("os.name").toLowerCase()
        	def fileNames = []
            if(params."Attachment File"){
            	params."Attachment File".split(",").each { name ->
            	def filePath
            	if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ //linux
            		filePath = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${name.trim()}"
            	}else{																//windows
              		filePath = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name.trim()}"  
                }
                println(filePath)
                fileNames.add(filePath)
                }
                def concatenatedFileNames = fileNames.join("\n")

    			// Send concatenated file paths to the file input element
            	SendKeys.run(ID:"//*[@id='${params."Section".toLowerCase()}-impact-attachments-dropzone']",Text:concatenatedFileNames)
            	if (params."Wait for attachment to load" == null || params."Wait for attachment to load" == true) {
            	sleep(3000)
            	}
            }
        } else {
            Click.run(ID:"//*[@id='${params."Section".toLowerCase()}-impact-attachments']//*[text()='${params."Attachment File"}']/../..//I")
        }
    }
}
