package actions.ViewIdea.GigEnhancementsApplyApplicants;

import actions.selenium.*;

class ApplyinViewIdea{
    public void run(def params){
        Click.run(ID:"//*[@id='f-gig-app-btn-trigger-modal']")
        if(params."Message"){
            SetText.run(ID:"//textarea[@id='gig-application-message']", Text:params."Message")
        }
        if (params."Expertise"){
            params."Expertise".split(",").eachWithIndex{ expertise, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@class='react-tags__search-input']",Text:expertise,"Type of Clear":"None")  
                    sleep(1000)
                    Click.run(ID:"//*[contains(@id,'ReactTags-')]//*[@class='f-tag-suggestion-name' and text()='${expertise}']")   
                }else{
                    Click.run(ID:"//*[contains(@class,'f-tag-name') and text()='${expertise}']/..//*[contains(@class,'f-rmv-tag')]")
                }
            } 
        }
        if(params."Contact - Include my contact email"){
            SetCheckBox.run(ID:"//*[contains(@class,'f-gig-app-modal-input-wrapper')]/input[@type='checkbox']", Check:params."Contact - Include my contact email")
        }
        if(params."Action"=="Apply"){
            Click.run(ID:"//button[contains(@class,'fractal-button f-submit-btn f-btn-primary f-btn-sm')]")
        }else if(params."Action"=="Cancel"){
            Click.run(ID:"//button[contains(@class,'fractal-button f-btn-link f-btn-sm')]")
        }
    } 
}