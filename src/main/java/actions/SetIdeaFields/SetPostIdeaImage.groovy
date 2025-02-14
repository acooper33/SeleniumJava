package actions.SetIdeaFields;

import actions.selenium.Click
import java.nio.file.Paths
import actions.selenium.SendKeys
import actions.PostIdea.SetCropImageinPostIdea

class SetPostIdeaImage{
    public static void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
       
        if(params."Image File"){
            Click.run(ID:"//*[contains(@class,'f-upload-modal-dropzone-browse-text')]")
            def fileName
            //Get path to file we are sending depending on OS
        	if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
            	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."Image File"}"
        	}else{
            	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Image File"}"
        	}
            //def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Image File"}"
            //Now send a file to the 'fallback_input' element
            SendKeys.run(ID:"//*[contains(@class,'f-upload-modal-dropzone-input')]",Text:fileName)
            sleep(3000)
            Click.run(ID:"//*[@data-test='modal-footer-submit']")
            sleep(3000)
            if(params."Crop or Cancel"){
                SetCropImageinPostIdea cropImage = new SetCropImageinPostIdea()
                params."Action"=params."Crop or Cancel"
                cropImage.run(params)
//                Click.run(ID:"//*[@class='bimodal-container']//*[text()='${params."Crop or Cancel"}']")
            }            
        }
    }
}