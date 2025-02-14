package actions.PostIdea;

import actions.selenium.VerifyText
import actions.selenium.Exists
import actions.selenium.Click

class VerifyPostPreviewIdea{
    public void run(def params){
        VerifyText.run(ID:"//*[@id='preview-content']//*[@class='title']",Text:params."Title")
        if(params."Image"!=null){
            if(params."Image"){assert Exists.run(ID:"//*[@id='preview-content']//*[@class='idea-image' and contains(@style,'default-idea-image.jpg')]")==0,"Error - Image not found"}
            else{assert Exists.run(ID:"//*[@id='preview-content']//*[@class='idea-image' and contains(@style,'default-idea-image.jpg')]")>0,"Error - Default image not found"}
        }
        VerifyText.run(ID:"//*[@id='preview-content']//*[@class='category']/SPAN",Text:params."Category")
        VerifyText.run(ID:"//*[@id='preview-content']//*[@data-content='description']","Contains Text":params."Description")
        
        if(params.Action){
            if(params.Action=='Back'){Click.run(ID:"//*[@id='cancel']")}
            else{Click.run(ID:"//*[@id='submit']")}
        }
    }
}