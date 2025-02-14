package actions.People;

import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SendKeys
import java.nio.file.Paths

class ImportUserinPeoplepage{
    public void run(def params){
		def os = System.getProperty("os.name").toLowerCase();
        def fileName
        Click.run(ID:"//*[@id='button-container']//button[contains(@class,'btn btn-standard dropdown-toggle')]")
        Click.run(ID:"//*[@id='import-users']")
        SetCheckBox.run(ID:"//*[@id='send-user-invite-email']",Check:params."Include Invite Email Checkbox")
        //Get path to file we are sending
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){	//linux
            fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."Import File"}"
        }else{																//windows
            fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Import File"}"
        }
        //Now send a file to the 'attachment-uploader' element
        SendKeys.run(ID:"//*[@id='user-import-file']",Text:fileName)
        sleep(3000)
        if(params."Action"){
            if(params."Action"=="Import"){
                Click.run(ID:"//*[@id='bi-modal-button']/span[text()='${params."Action"}']")
            } else {Click.run(ID:"//*[@class='bimodal-secondary']")}
        }
        if(params."Check Complete Action"){
            if(params."Check Complete Action"=="Finish Import"){
                Click.run(ID:"//*[@id='user-import-finish-btn']")
            } else {Click.run(ID:"//*[@id='user-import-cancel-btn']")}
        }
        Click.run(ID:"//*[@id='user-import-done-btn']")
        sleep(5000)
    }
}