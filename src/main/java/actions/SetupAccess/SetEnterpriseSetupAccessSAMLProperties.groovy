package actions.SetupAccess;

import actions.common.SetupCommon
import actions.selenium.SendKeys
import actions.selenium.Click
import java.nio.file.Paths
import actions.selenium.*

class SetEnterpriseSetupAccessSAMLProperties{
    public void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        def fileName
        SetupCommon.NavigateTab(Tab:"Access",Section:"SAML Profiles")
        Click.run(ID:"//*[@id='self_sso_new']")
        SwitchToFrame.run(ID:"//*[@name='upload_meta']//*[@class='upload_iframe']")
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")) {
            fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."Upload Metadata File"}"
        } else {
        	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Upload Metadata File"}"
        }
        //Now send a file to the 'attachment-uploader' element
        SendKeys.run(ID:"//INPUT[@type='file']",Text:fileName)
        SwitchToDefaultContent.run()
        sleep(5000)       
    }
}