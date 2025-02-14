package actions.ViewIdea.TeamWorkspace;

import actions.selenium.Click
import actions.selenium.Exists
import java.nio.file.Paths
import java.nio.file.Files
import actions.selenium.SendKeys
import actions.common.TeamWorkspaceCommon

class SetFilesinTeamWorkspace{
    public void run(def params){
        def os = System.getProperty("os.name").toLowerCase()
        def fileNames = []
        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}
        if(params."Attachment File"){
            params."Attachment File".split(",").each { name ->
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
             SendKeys.run(ID:"//INPUT[contains(@id,'attachment-dropzone')]",Text:concatenatedFileNames)
        }
        if (params."Wait for attachment" == null || params."Wait for attachment" == true) {
            sleep(3000)
        }
    }
}


   