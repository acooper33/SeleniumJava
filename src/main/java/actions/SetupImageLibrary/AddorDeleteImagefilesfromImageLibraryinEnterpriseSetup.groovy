package actions.SetupImageLibrary;

import actions.common.SetupCommon
import actions.selenium.*
import java.nio.file.Paths

class AddorDeleteImagefilesfromImageLibraryinEnterpriseSetup{
    public void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        def fileName
        SetupCommon.NavigateTab(Tab:"File Library")
        if (params."Add or Delete"=="Add"){
            SwitchToFrame.run(ID:"//*[@id='iFrmAdd']")
            if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ //linux
            	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."File"}"
            }else{																//windows
              	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."File"}"  
            }
            //Now send a file to the 'attachment-uploader' element
            SendKeys.run(ID:"//*[@id='upload_file']",Text:fileName)
            sleep(3000) 
            SetText.run(ID:"//*[@id='upload_description']",Text:params."Description")
            SetCheckBox.run(ID:"//*[@id='upload_confidential']",Check:params."Confidential File")
            Click.run(ID:"//*[@id='cmdUpload']")
            sleep(5000)
            SwitchToDefaultContent.run()
        } else {Click.run(ID:"//*[@id='image_list']//a[text()='${params."File"}']/../../..//IMG[@title='Delete']")}
    }
}