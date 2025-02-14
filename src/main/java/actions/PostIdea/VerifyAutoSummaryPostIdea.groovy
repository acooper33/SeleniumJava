package actions.PostIdea;

import actions.selenium.VerifyText
import actions.selenium.Exists

class VerifyAutoSummaryPostIdea{
    public void run(def params){
        VerifyText.run(ID:"//*[@id='idea-sidebar-preview']//*[@class='title']",Text:params."Title")
        if(params."Image"!=null){
            if(params."Image"){assert Exists.run(ID:"//*[@id='idea-sidebar-preview']//div[contains(@style,'default-idea-image.jpg')]")==0,"Error - Image not found"}
            else{assert Exists.run(ID:"//*[@id='idea-sidebar-preview']//div[contains(@style,'default-idea-image.jpg')]")>0,"Error - Default image not found"}
        }
        VerifyText.run(ID:"//*[@id='idea-sidebar-preview']//div[@class='status tag']",Text:params."Status")
        VerifyText.run(ID:"//*[@id='idea-sidebar-preview']//p[@class='author green']","Contains Text":params."Username")
        VerifyText.run(ID:"//*[@id='idea-preview-meta']/DIV[@class='description']","Contains Text":params."Description")
    }
}