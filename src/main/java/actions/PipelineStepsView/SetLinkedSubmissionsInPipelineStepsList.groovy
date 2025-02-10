package actions.PipelineStepsView;

import actions.selenium.Click
import actions.selenium.SetText

class SetLinkedSubmissionsInPipelineStepsList{
    public void run(def params){
        Click.run(ID:"//*[@id='actions_dropdown']", "Type of Click":"Javascript")
        Click.run(ID:"//*[@id='action-link']")
        if (params."Submission Title"){
            if(params."Add or Remove"){
                params."Submission Title".split(',').eachWithIndex{ name, x->
                    if(params."Add or Remove".split(',')[x]=="Add"){
                        Click.run(ID:"//INPUT[@id='idea-links-search']")
                        SetText.run(ID:"//INPUT[@id='idea-links-search']", Text:name)
                        sleep(500)
                        Click.run(ID:"//*[@class='idea-title-ellipsis' and contains(., '${name}')]")
                    }
                    else if (params."Add or Remove".split(',')[x]=="Remove"){Click.run(ID:"//*[contains(@class,'idea-list-right')]//*[@class='idea-title-ellipsis' and contains(., '${name}')]/following-sibling::I[contains(@class,'trash')]")}
                }
    		}
        }
        if(params.Action=="Link Ideas"){Click.run(ID:"//BUTTON[contains(@class,'f-submit-btn')]")}
        if(params.Action=="Cancel"){Click.run(ID:"//BUTTON[contains(@class,'f-btn-subtle')]")}
    }
}