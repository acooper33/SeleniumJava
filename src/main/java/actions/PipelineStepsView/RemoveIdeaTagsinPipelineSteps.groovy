package actions.PipelineStepsView;

import actions.selenium.SendKeys
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetReactTags

class RemoveIdeaTagsinPipelineSteps{
    public void run(def params){
        Click.run(ID:"//*[@id='actions_dropdown']")
        Click.run(ID:"//*[@id='action-remove-tag']")
        if(params."Tag Name"){SetReactTags.setIdeaTagsOrExpertise("Tag Name":params."Tag Name", "Tag Add or Remove":params."Tag Add or Remove")}
		/*if(params."Tag Name"){
            params."Tag Name".split(",").eachWithIndex{ name, x ->
                if(params."Tag Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@class='react-tags__combobox-input']",Text:name)
                    sleep(2000)
                    SendKeys.run(ID:"//*[@class='react-tags__combobox-input']",Key:"ENTER")
                }
                else{
                    Click.run(ID:"//*[contains(@class,'react-tags__tag')]//SPAN[text()='${name}']/..//*[contains(@class,'f-rmv-tag')]")
                }
            }
        }*/
        if(params.Action=="Remove Tags"){Click.run(ID:"//*[@data-test='modal-footer-submit']")}
        else{Click.run(ID:"//*[@class='f-footer']//*[text()='${params.Action}']")}
    }
}