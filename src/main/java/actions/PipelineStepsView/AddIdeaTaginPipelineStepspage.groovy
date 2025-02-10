package actions.PipelineStepsView;

import actions.selenium.SendKeys
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SetReactTags

class AddIdeaTaginPipelineStepspage{
    public void run(def params){
        if (Exists.run(ID:"//*[@id='actions_dropdown']")==1){ // action also used for Top Ideas, so if we are in pipeline view, click actions 
            Click.run(ID:"//*[@id='actions_dropdown']")
        	Click.run(ID:"//*[@id='action-tag']")
        } 
        sleep(1000)
        if(params."Tag Name"){SetReactTags.setIdeaTagsOrExpertise("Tag Name":params."Tag Name", "Tag Add or Remove":params."Tag Add or Remove")}
        if(params."Remove All Existing Tags"){Click.run(ID:"//*[@class='f-tags-remove-all']/DIV/DIV/DIV")}
        if(params.Action=="Add Tags"){Click.run(ID:"//*[@data-test='modal-footer-submit']")}
        else if (params.Action!=null){Click.run(ID:"//*[@class='f-footer']//*[text()='${params.Action}']")}
        if(params."Remove All Existing Tags Action"=="Submit"){
           Click.run(ID:"//BUTTON[contains(@class,'f-submit-btn')]") 
        }
    }
}