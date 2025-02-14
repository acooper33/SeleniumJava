package actions.NGAViewIdea;

import actions.common.NGAViewIdeaCommon
import actions.selenium.SendKeys
import actions.selenium.SetCheckBox
import java.nio.file.Paths

class SetAddAttachmentinAttachmentstabforNGAViewIdeapage{
    public void run(def params){
        NGAViewIdeaCommon.NavigateTab(Tab:"Attachments")
		def os = System.getProperty("os.name").toLowerCase();
        //Get path to file we are sending
        def fileName
        def attachmentFile = params."Attachment File"
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
            fileName = Paths.get(".").toAbsolutePath().normalize().toString()+'/TestCaseResourceFiles/'+attachmentFile
        }
        else{
            //fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Attachment File"}"
            fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\"+attachmentFile
        }
        //Now send a file to the 'attachment-uploader' element
        if(params."Private Attachment"){SetCheckBox.run(ID:"//input[@class='private-upload-input']", Check:params."Private Attachment")}
        SendKeys.run(ID:"//*[@id='attachment_upload_fallback']",Text:fileName)
        sleep(5000)
    }
}