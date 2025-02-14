package actions.ProjectRoom;

import actions.selenium.*
import actions.selenium.Exists    

class VerifyFolderPageinProjectRoom{
    public void run(def params){
        
        VerifyText.run(ID:"//h2[@class='f-folder-title']",Text:params."Folder Name")
        def input = params."Folder Name"
        def result = input.replaceAll(/.*:\s*/, "")
        assert Exists.run(ID:"//*[text()='${result}']/../../../../*[contains(@class,'f-selected')]")==1, "${result} is not selected"
        
    }
}