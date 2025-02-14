package actions.NGAViewIdea;

import actions.common.NGAViewIdeaCommon
import actions.selenium.Click
import actions.selenium.SetText

class SetLinkedSubmissionsNGAViewIdeaPage{
    public void run(def params){
        sleep(1000)
        NGAViewIdeaCommon.NavigateTab(Tab:"Details")
        if (params."Submission Title"){Click.run(ID:"//*[contains(@id, 'linked-idea-edit-icon')]", "Type of Click":"Javascript")}
        sleep(3000)
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
        if(params.Action=="Link Submissions"){Click.run(ID:"//BUTTON[contains(@class,'f-submit-btn')]")}
        if(params.Action=="Cancel"){Click.run(ID:"//BUTTON[contains(@class,'f-btn-subtle')]")}
  	}
}