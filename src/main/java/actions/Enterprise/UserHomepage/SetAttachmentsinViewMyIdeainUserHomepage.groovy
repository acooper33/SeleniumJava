package actions.Enterprise.UserHomepage;

import actions.selenium.SendKeys
import actions.selenium.Click
import actions.selenium.Exists
import java.nio.file.Paths

class SetAttachmentsinViewMyIdeainUserHomepage{
    public void run(def params){

        if(params."Add/Remove" == "Add"){
            def os = System.getProperty("os.name").toLowerCase();
            def fileName
            if(os.contains("nix") || os.contains("nux")||os.contains("aix")) {
                fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."FileName"}"
            } else {
                fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."FileName"}"
            }
            SendKeys.run(ID:"//*[@id='f-fileupload-link']",Text:fileName)
            sleep(3000)
        } else {
            Click.run(ID:"//*[contains(@class,'f-images-horizontal-scroll')]//*[@alt='${params."FileName"}' or text()='${params."FileName"}']/../..//I[contains(@class,'trash')]")
            sleep(1000)
            if(Exists.run(ID:"//*[@id='clickToConfirmOkButton']")==1){
                println("Will click clickToConfirmOkButton")
                Click.run(ID:"//*[@id='clickToConfirmOkButton']")
            }
        }
    }
}