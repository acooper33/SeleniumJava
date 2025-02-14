package actions.ViewIdeaComment;

import actions.common.ViewIdeaCommon
import actions.selenium.SetText
import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SendKeys
import java.nio.file.Paths

class AddCommentinViewIdeapage{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Description")
        
        SetText.run(ID:"//div[@id='add-comment-input']",Text:params.Comment)
        //If enetering a user for a comment field, then press enter after typing
        if(params.Comment.startsWith("@")){
            sleep(2000)
            SendKeys.run(ID:"//div[@id='add-comment-input']",Key:"ENTER")
        }
        //SetCheckBox.run(ID:"//input[@id='admin_comment_flag']",Check:params."Admin Comment")
        if(params."Comment Type"){
            if(Exists.run(ID:"//*[@id='comment_current_type']/DIV[.='${params."Comment Type"}']")==0){ 
            Click.run(ID:"//*[@id='idea_comment_type']")
            Click.run(ID:"//*[@id='idea_comment_type']//*[@class='dropdown-menu comment-dropdown-menu']//A[contains(text(),'${params."Comment Type"}')]")
            }  
        }
        //SelectItem.run(ID:"//*[@id='idea_comment_type']","Visible Text":params."Comment Type")
        
        if(params."Attachment File"){
            def os = System.getProperty("os.name").toLowerCase();
        	def fileName
            params."Attachment File".split(",").eachWithIndex{ name, x ->
                if(params."Attachment Add or Remove".split(",")[x]=="Add"){
                    //Get path to file we are sending
                    if(os.contains("nix") || os.contains("nux")||os.contains("aix")){ 	//linux
            			fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"/TestCaseResourceFiles/${name}"
            		}else{																//windows
              			fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${name}"  
            		}
                    //Now send a file to the 'fallback_input' element
                    SendKeys.run(ID:"//*[@id='comment-attachment-input']",Text:fileName)
                    println("File sent!!!!!");
                    sleep(5000)    
                }
                else{
                    Click.run(ID:"//*[@class='image-attachment']//A[text()='${name}']/../..//A[@class='image-delete-wrapper comment-image-attachment-item']")
                    Click.run(ID:"//*[@id='bi-modal-button']/SPAN[text()='Remove']")
                    sleep(2000)
                }
            }
        }
        
        Click.run(ID:"//div[@id='bi-comment-button']")
        sleep(2000)
    }
}