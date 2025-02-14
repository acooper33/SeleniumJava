package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.Click
import java.nio.file.Paths
import actions.selenium.SendKeys

class SetIdeasImportInIdeasTab{
    public void run(def params){
		def os = System.getProperty("os.name").toLowerCase();
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Ideas Import")
  
        //Get path to file we are sending
        def fileName
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
        	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."File Name"}"
        }else{
            fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."File Name"}"
        }
        SendKeys.run(ID:"//*[@id='form-file-group-file']",Text:fileName)
        sleep(7000)
        if(params."Action"=="Import"){
            Click.run(ID:"//*[@id='idea_import_button_group_center']")
            Click.run(ID:"//*[contains(@id,'ext-comp-')]//*[text()='OK']")
            sleep(7000)
        } else {Click.run(ID:"//*[@id='user_import_cancel_button_group']")}
    }
}
