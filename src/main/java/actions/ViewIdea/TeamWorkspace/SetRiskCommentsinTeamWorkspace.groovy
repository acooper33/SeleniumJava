package actions.ViewIdea.TeamWorkspace;

import actions.selenium.*
import java.nio.file.Paths
import java.nio.file.Files

class SetRiskCommentsinTeamWorkspace{
    public void run(def params){
        
        def os = System.getProperty("os.name").toLowerCase()
        def fileNames = []
        if(Exists.run(ID:"//*[@class='fractal-teamWorkspacePanel-heading']/*[text()='${params."Risk to be Commented"}']")==0){ 
            Click.run(ID:"//*[contains(@id,'table-body-row') and @value='${params."Risk to be Commented"}']") 
        }
        switch(params."Type of Comment"){
            case "Comment":
            SetText.run(ID:"//*[contains(@class,'redactor-styles redactor-placeholder redactor-in redactor-in') and contains(@placeholder,'comment')]",Text:params.Comment)
            if(Exists.run(ID:"//*[@class='redactor-box redactor-styles-on redactor-blur']")==1){
                Click.run(ID:"//*[contains(@class,'redactor-styles redactor-in redactor-in') and contains(@placeholder,'comment')]")
            }
            if(params."Attachment File"){
                Click.run(ID:"//*[@class='attachments-icon false']/I")
            	params."Attachment File".split(",").each { name ->
//                    SetFocus.run(ID:"//*[text()='${params.Comment}']/../../../..//*[@class='comment-inputbox-container']//*[contains(@class,'attachments-icon')]/I")
//                	Click.run(ID:"//*[text()='${params.Comment}']/../../../..//*[@class='comment-inputbox-container']//*[contains(@class,'attachments-icon')]/I")
            		def filePath
            		if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ //linux
            			filePath = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${name.trim()}"
            		}else{																//windows
              			filePath = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name.trim()}"  
                	}
                fileNames.add(filePath)
            }
            def concatenatedFileNames = fileNames.join("\n")

    		// Send concatenated file paths to the file input element
             SendKeys.run(ID:"//INPUT[contains(@id,'new-comment-attachments')]",Text:concatenatedFileNames)
             if (params."Wait for attachment to load" == null || params."Wait for attachment to load" == true) {
            	sleep(3000)
        	}    
        }
            if (params."Click on Post Button" == null || params."Click on Post Button" == true) {
            	 Click.run(ID:"//*[@id='postContent']") 
                sleep(5000) 
        	}   
           break
            case "Reply":
            Click.run(ID:"//*[text()='${params.Comment}']/../../../..//*[@class='fractal-comment-btn']", "Type of Click":"Javascript")
            SetFocus.run(ID:"//*[contains(@class,'redactor-styles redactor-placeholder redactor-in redactor-in') and contains(@placeholder,'Reply')]")
            SetText.run(ID:"//*[contains(@class,'redactor-styles redactor-placeholder redactor-in redactor-in') and contains(@placeholder,'Reply')]",Text:params."Reply Comment", "Type of Clear":"Cut")
            if(params."Attachment File"){
                SetFocus.run(ID:"//*[text()='${params.Comment}']/../../../..//*[@class='comment-inputbox-container']//*[contains(@class,'attachments-icon')]/I")
                Click.run(ID:"//*[text()='${params.Comment}']/../../../..//*[@class='comment-inputbox-container']//*[contains(@class,'attachments-icon')]/I")
                params."Attachment File".split(",").eachWithIndex{ name, x ->
				def fileName 
                    if(os.contains("nix") || os.contains("nux")||os.contains("aix")) {
                        fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${name}"
                    } else {
                    	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"
                    }
                    SendKeys.run(ID:"//INPUT[contains(@id,'comment-new-reply-attachments')]",Text:fileName)
                    sleep(3000)
                }
            }
            sleep(2000)
            Click.run(ID:"//*[@class='btn-post-animation-wrapper']//*[@id='postContent']", "Type of Click":"Javascript")
            break
        }
    }
}