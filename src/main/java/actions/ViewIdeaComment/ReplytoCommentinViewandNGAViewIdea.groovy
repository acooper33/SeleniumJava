package actions.ViewIdeaComment;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SendKeys
import java.nio.file.Paths
import actions.selenium.MouseOver
import actions.selenium.ExplicitWait

class ReplytoCommentinViewandNGAViewIdea{
    public void run(def params){

        if(params."Parent Comment"){
        MouseOver.run(ID:"//*[@data-test='f-test-comment-wrapper']//*[text()='${params."Parent Comment"}']/../..//SPAN[@class='f-web-dropdown']")
        Click.run(ID:"//*[@data-test='f-test-comment-wrapper']//*[text()='${params."Parent Comment"}']/..//DIV[@data-class='reaction-count-button' and @data-test='f-test-comment-reply-button']","Type of Click":"Move to Element") 
        }
        SetText.run(ID:"//*[starts-with(@id,'fractal-commenting-input-') and contains(@id,'reply')]",Text:params."Comment Reply","Type of Clear":"None")
        if(params."Attachment File"){
            def os = System.getProperty("os.name").toLowerCase();
            params."Attachment File".split(",").eachWithIndex{ name, x ->
                if(params."Attachment Add or Remove".split(",")[x]=="Add"){
                    //Get path to file we are sending
                    def fileName
                    if(os.contains("nix") || os.contains("nux")||os.contains("aix")) {
                        fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${name}"
                    } else {
                     	fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"
                    }

                    //Now send a file to the 'fallback_input' element
                    SendKeys.run(ID:"//*[@class='f-upload-link']",Text:fileName)
                    if(params."Wait For Attachment To be Uploaded"==null || params."Wait For Attachment To be Uploaded"==true){
                        ExplicitWait.run(ID:"//*[text()='${name}']/../../*[contains(@class,'f-file-progress-bar f-progress-hidden')]")
                        sleep(2000)
                    } else if(params."Wait For Attachment To be Uploaded"==false){
                        ExplicitWait.run(ID:"//*[text()='${name}']/../../*[not(contains(@class,'f-progress-hidden'))][3]")
                    }    
                }
                else{
                    Click.run(ID:"//*[@class='f-images-horizontal-scroll']//*[@alt='${name}' or text()='${name}']/../..//I","Type of Click": "Javascript")
                }
            }
        }
        if(params."Post Reply"!=null){
            if(params."Post Reply"== true){
                Click.run(ID:"//*[contains(@class,'f-comment-input-reply')]//*[@data-test='f-test-comment-submit-button']","Type of Click": "Javascript")
                sleep(2000)
            } else if(params."Post Reply"== false){
                Click.run(ID:"//*[contains(@class,'f-comment-input-reply')]//*[contains(@class,'f-btn-cancel-edit')]","Type of Click": "Javascript")}
        }
    }
}
