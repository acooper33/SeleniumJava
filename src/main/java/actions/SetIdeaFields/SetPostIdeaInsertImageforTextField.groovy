package actions.SetIdeaFields;

import actions.selenium.Click
import java.nio.file.Paths
import actions.selenium.SendKeys

class SetPostIdeaInsertImageforTextField{
    public void run(def params){
        def os = System.getProperty("os.name").toLowerCase();
        def fileName
        Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]/..//DIV[@class='redactor-toolbar']/A[@aria-label='Image']")        
        //Get path to file we are sending
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")) {
            fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${params."Image File"}"
        } else {
            fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Image File"}"
        }
        //Now send a file to the 'fallback_input' element
        SendKeys.run(ID:"//*[contains(@class,'redactor-modal-tab')]//INPUT",Text:fileName)
        sleep(7000)
        Click.run(ID:"//LEGEND[contains(text(),'${params."Field Name"}')]","Type of Click":"Move to Element")
    }
}