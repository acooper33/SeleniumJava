package actions.SetupUsers;

import actions.common.SetupCommon
import actions.selenium.Click
import java.nio.file.Paths
import actions.selenium.SendKeys

class SetEnterpriseSetupUsersImportpage{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Users",Section:"User Import")
        //Get path to file we are sending
        def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."FileName"}"
        SendKeys.run(ID:"//*[@id='form-file-file']",Text:fileName)
        sleep(3000)
        if(params."Action"=="Import Users"){
            Click.run(ID:"//*[@id='idea_import_button_center']")
            Click.run(ID:"//*[contains(@id,'ext-comp-')]//*[text()='OK']")
            sleep(3000)
        } else {Click.run(ID:"//*[@id='user_import_cancel_button_group']")}
    }
}