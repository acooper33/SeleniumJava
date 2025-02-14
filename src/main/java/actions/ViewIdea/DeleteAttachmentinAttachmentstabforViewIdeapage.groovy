package actions.ViewIdea;

import actions.common.ViewIdeaCommon
import actions.selenium.Click

class DeleteAttachmentinAttachmentstabforViewIdeapage{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Attachments")
        def set = [:]
        if(params."Attachment File".contains(".png") || params."Attachment File".contains(".jpg")) {
            set.ID= "//*[@id='image-attachment-container']//*[text()='${params."Attachment File"}']/../..//A[@class='image-delete-wrapper']"

        } else {
            set.ID= "//*[text()='${params."Attachment File"}']/../..//A[@class='image-delete-wrapper non-image-attachment-item']"}
        //Map all values that will be used for access of that instance
        if(params."Instance"){set."Instance"=params."Instance".toInteger()}        
        Click.run(set)
        if(params.Action=="Cancel"){Click.run(ID:"//*[@id='delete_attachment_dialog']//*[text()='Cancel']")}
        else if(params.Action=="Close"){Click.run(ID:"//*[@id='delete_attachment_dialog']//*[text()='Close']")}
        else{Click.run(ID:"//*[@id='delete_attachment_dialog']//*[text()='Remove']")}

        sleep(2000)
    }
}