package actions.ViewIdeaComment;

import actions.common.*
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SendKeys
import java.nio.file.Paths
import actions.selenium.SetFocus
import actions.selenium.ExplicitWait
import java.util.NoSuchElementException
import actions.selenium.Refresh

class AddCommentinViewandNGAViewIdea{
    public void run(def params){

        if(params."View Idea or NGA"=="NGA"){
            NGAViewIdeaCommon.NavigateTab(Tab:"Description")
            sleep(4000)
        } else if(params."View Idea or NGA"=="View Idea"){
            ViewIdeaCommon.NavigateTab(Tab:"Description")
        }

        try{
            SetFocus.run(ID:"//*[starts-with(@id,'fractal-commenting-input')]") 
        }catch (Exception e){
            System.out.println("Comment modal did not load. Retrying...")
			sleep(3000)
            Refresh.run()
       		SetFocus.run(ID:"//*[starts-with(@id,'fractal-commenting-input')]")
        }
        //SetFocus.run(ID:"//*[starts-with(@id,'fractal-commenting-input')]")
        SetText.run(ID:"//*[starts-with(@id,'fractal-commenting-input')]",Text:params.Comment,"Type of Clear":"None")
        if(params."Comment Type"){
            Click.run(ID:"//*[@data-test='f-test-comment-permission-dropdown']", "Type of Click": "Javascript")
            Click.run(ID:"//*[contains(@class,'f-status-indicator-solid') and text()='${params."Comment Type"}']", "Type of Click": "Javascript")
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
                    Click.run(ID:"//*[starts-with(@id,'fractal-commenting-input')]")
                    SendKeys.run(ID:"//*[contains(@id,'fractal-commenting-input---')]/following-sibling::DIV[contains(@class,'fractal-fileupload-v2')]//INPUT",Text:fileName)
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
        if(params."Post Comment"){
            if(params."Post Comment"== true){
                Click.run(ID:"//*[@data-test='f-test-comment-submit-button']","Type of Click": "Javascript")
                sleep(2000)
            }
        }
    }
}
