package actions.ViewIdeaComment;

import actions.common.*
import actions.selenium.*
import java.nio.file.Paths
import actions.selenium.ExplicitWait

class EditCommentinViewandNGAViewIdeapage{
    public void run(def params){
     
        if(params."View Idea or NGA"=="NGA"){
            NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        } else {
            ViewIdeaCommon.NavigateTab(Tab:"Description")
        }
        
        if(params."New Comment"){
            SetText.run(ID:"//*[@class='f-comment-input-textarea' and text()='${params."Comment to Edit"}']",Text:params."New Comment")
        }
        if(params."New Comment Permission"){
            Click.run(ID:"//*[@data-test='f-test-comment-permission-dropdown']", "Type of Click": "Javascript")
            Click.run(ID:"//*[contains(@class,'f-status-indicator-solid') and text()='${params."New Comment Permission"}']","Type of Click": "Javascript")
        }
        
         if(params."Attachment File"){
            def os = System.getProperty("os.name").toLowerCase();
            def fileName
            params."Attachment File".split(",").eachWithIndex{ name, x ->
                if(params."Attachment Add or Remove".split(",")[x]=="Add"){
                    //Get path to file we are sending
                    if(os.contains("nix") || os.contains("nux")||os.contains("aix")) {
                        fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${name}"
                    } else {
                        fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"
                    }
                    //Now send a file to the 'fallback_input' element
                    SendKeys.run(ID:"//*[contains(@id,'f-comment-upload-link-')]",Text:fileName)
                    if(params."Wait For Attachment To be Uploaded"==null || params."Wait For Attachment To be Uploaded"==true){
                        ExplicitWait.run(ID:"//*[text()='${name}']/../../*[contains(@class,'f-file-progress-bar f-progress-hidden')]")
                        sleep(2000)
                     } else if(params."Wait For Attachment To be Uploaded"==false){
                        ExplicitWait.run(ID:"//*[text()='${name}']/../../*[not(contains(@class,'f-progress-hidden'))][3]")
                    }
                }
                else{
                    Click.run(ID:"//*[contains(@class,'fractal-clickoutside f-comment-input-web')]//*[@alt='${name}' or text()='${name}']/../..//I")
                    sleep(2000)
                }
            }
        }
        
        if(params."Action"){
            if(params."Action"=="Update Comment"){
            Click.run(ID:"//*[@data-test='f-test-comment-submit-button']", "Type of Click":"Move to Element")          
            } else {Click.run(ID:"//*[contains(@class,'fractal-button') and text()='${params."Action"}']", "Type of Click":"Move to Element")}
        }
        sleep(3000)
    }
}