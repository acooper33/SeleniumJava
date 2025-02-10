package actions.WebstormHomepage;

import actions.selenium.*
import java.nio.file.Paths
import actions.WebstormHomepage.SetActionOnChangeBackgroundModal
import actions.selenium.ExplicitWait

class SetUploadyourOwnBackground{
    public void run(def params){
        
        if(params."Choose File"!=null){
            def fileName
            String fileN
            def os = System.getProperty("os.name").toLowerCase();
            if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
                fileN = params."Choose File"
                fileName = Paths.get(".").toAbsolutePath().normalize().toString()+'/TestCaseResourceFiles/'+fileN
                println("File path: ${fileName}")
            }else{
            	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Choose File"}"
            }
            SendKeys.run(ID:"//*[contains(@class,'f-dropzone-wrapper f-dropzone-wrapper-preview')]//*[@id='attachment-dropzone-input']",Text:fileName)
            if(params."Wait for Image to load"==true){
                ExplicitWait.run(ID:"//*[@class='f-image-block']")
            }
        }
        if(params."Delete File" == true){
            Click.run(ID:"//*[@class='f-image-block']//I")
        }
        SetActionOnChangeBackgroundModal.setAction(Action:params."Action")
    }
}