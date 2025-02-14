package actions.NGAViewIdea;

import actions.common.NGAViewIdeaCommon
import actions.selenium.Click

class DeleteAttachmentinAttachmentstabforNGAViewIdea{
    public void run(def params){
        NGAViewIdeaCommon.NavigateTab(Tab:"Attachments")
        def set = [:]
        if(params."Attachment File".contains(".png") || params."Attachment File".contains(".jpg")){
            set.ID="//*[contains(@id,'-container')]//*[contains(@class,'image-collection-wrapper')]/DIV[@class='image-attachment image-attachment-item']/DIV[@class='attachment-image-info-wrapper']/A[contains(@class,'remove-file')]"
        }
        else{
            set.ID= "//*[text()=${params."Attachment File"}]/..//A[@title='Delete attachment']"
        } 
        if(params."Instance"){set."Instance"=params."Instance".toInteger()} 
        Click.run(set)
        if(params.Action=='Remove'){Click.run(ID:"//*[@id='bi-modal-button']")}
        else if (params.Action=='Cancel'){Click.run(ID:"//A[@class='bimodal-secondary' and text()='Cancel']")}
        else {Click.run(ID:"//*[@id='bimodal-close-label']")}       
    }
}