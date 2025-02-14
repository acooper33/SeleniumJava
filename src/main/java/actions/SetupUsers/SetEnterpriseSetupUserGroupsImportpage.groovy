package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.Click
import java.nio.file.Paths
import actions.selenium.SendKeys

class SetEnterpriseSetupUserGroupsImportpage{
    public void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        def fileName
    	SetupCommon.NavigateTab(Tab:"Users",Section:"Group Import")
        //Get path to file we are sending
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
            fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."File Name"}"
        }else{
            fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."File Name"}"
        }  
        //def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."FileName"}"
        SendKeys.run(ID:"//*[@id='form-file-group-file']",Text:fileName)
        sleep(3000)
        if(params."Action"=="Import"){
            Click.run(ID:"//*[@id='idea_import_button_group_center']")
            Click.run(ID:"//*[contains(@id,'ext-comp-')]//*[text()='OK']")
            sleep(3000)
        } else {Click.run(ID:"//*[@id='user_import_cancel_button_group']")}
    }
}
