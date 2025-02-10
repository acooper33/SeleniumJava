package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.MouseOver

class WhiteboardPinUnpinWhiteboardTemplate{
    public void run(def params){
         if(params."Pin/Unpin Custom Template" == "Pin"){
        	MouseOver.run(ID:"//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Custom Template Title"}']/../..//DIV[contains(@class,'f-thumbnail')]")
       		Click.run(ID:"//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Custom Template Title"}']/../..//DIV[contains(@class,'f-thumbnail')]/../DIV[contains(@class,'f-btn-pinned-container')]/BUTTON[contains(@class,'btn-pinned') and not(contains(@class,'f-btn-pinned-selected'))]")
        }
        if(params."Pin/Unpin Custom Template" == "Unpin"){
        	MouseOver.run(ID:"//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Custom Template Title"}']/../..//DIV[contains(@class,'f-thumbnail')]")
       		Click.run(ID:"//*[contains(@class,'f-template-item')]//SPAN[@class='f-template-title' and .='${params."Custom Template Title"}']/../..//DIV[contains(@class,'f-thumbnail')]/../DIV[contains(@class,'f-btn-pinned-container')]/BUTTON[contains(@class,'f-btn-pinned-selected')]")
        }
        sleep(3000)
    }
}