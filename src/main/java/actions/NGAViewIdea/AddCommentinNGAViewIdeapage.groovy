package actions.NGAViewIdea;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SendKeys
import java.nio.file.Paths
import actions.common.*

class AddCommentinNGAViewIdeapage{
    public void run(def params){
        
        NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        
        SetText.run(ID:"//div[@id='idea_comment_text']",Text:params.Comment)

        if (params."Comment Type") {
            if(params."Comment Type"!="Private"){
                Click.run(ID:"//*[@id='comment_current_type']")
                Click.run(ID:"//*[@id='idea_comment_type']//A[contains(.,'${params."Comment Type"}')]")
            }
        }
        if(params."Attachment File"){
            params."Attachment File".split(",").eachWithIndex{ name, x ->
                if(params."Attachment Add or Remove".split(",")[x]=="Add"){
                    //Get path to file we are sending
                    def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"

                    //Now send a file to the 'fallback_input' element
                    SendKeys.run(ID:"//*[@id='attachment-input']",Text:fileName)
                    sleep(5000)    
                }
                else{
                    Click.run(ID:"//A[text()='${name}']/../..//A[@class='image-delete-wrapper non-image-attachment-item']")
                    Click.run(ID:"//*[@id='bi-modal-button']/SPAN[text()='Remove']")
                    sleep(2000)
                }
            }
        }

        Click.run(ID:"//div[@id='add_comment_btn']")
        sleep(2000)
    }
}
