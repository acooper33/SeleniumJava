package actions.ViewIdea;

import actions.common.ViewIdeaCommon
import actions.selenium.SendKeys
import java.nio.file.Paths

class SetAddAttachmentinAttachmentstabforViewIdeapage{
    public void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        def fileName
        ViewIdeaCommon.NavigateTab(Tab:"Attachments")

        //Get path to file we are sending
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ 	//linux
        	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."Attachment File"}"
        }else{																//windows
        	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Attachment File"}"  
        }
        //Now send a file to the 'attachment-uploader' element
        SendKeys.run(ID:"//*[@id='attachment-uploader']",Text:fileName)
        if(params."Wait for Attachment to load"==null || params."Wait for Attachment to load"=="TRUE"){
                         sleep(5000)
        }       
    }
}