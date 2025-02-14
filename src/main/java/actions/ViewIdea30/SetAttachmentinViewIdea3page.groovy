package actions.ViewIdea30;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SendKeys
import java.nio.file.Paths
import actions.selenium.ExplicitWait

class SetAttachmentinViewIdea3page{
    public void run(def params){
       
        def path
        def os = System.getProperty("os.name").toLowerCase();
        if(params."Load From"=="Button"){
            path = "//*[@class='f-empty-attachments']//INPUT[@id='f-fileupload-link']"
        } else {
           path = "//*[@class='f-add-attachments']//INPUT[@id='f-fileupload-link']" 
        }
         if(params."Attachment File"){
            params."Attachment File".split(",").eachWithIndex{ name, x ->
                if(params."Attachment Add or Remove".split(",")[x]=="Add"){
                    //Get path to file we are sending
                     def fileName
                     if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ //linux
                        fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${name}"
                    }else{ // windows
                        fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"
                    }
                    SendKeys.run(ID:"${path}",Text:fileName)
                    if(params."Wait For Attachment To be Uploaded"){
                       if(params."Wait For Attachment To be Uploaded".split(",")[x]=="TRUE"){
                        ExplicitWait.run(ID:"//*[text()='${name}']/../../*[contains(@class,'f-file-progress-bar f-progress-hidden')]")
                        sleep(2000)
                       } else if(params."Wait For Attachment To be Uploaded".split(",")[x]=="FALSE"){
                        	ExplicitWait.run(ID:"//*[text()='${name}']/../../*[not(contains(@class,'f-progress-hidden'))][3]")
                       } 
                    }                   
                }
                else{
                    Click.run(ID:"//*[@class='f-tab-inner-component']//*[@alt='${name}' or text()='${name}']/../..//I[contains(@class,'fa fa-trash')]")
                    sleep(2000)
                }
            }
        }        
    }
}