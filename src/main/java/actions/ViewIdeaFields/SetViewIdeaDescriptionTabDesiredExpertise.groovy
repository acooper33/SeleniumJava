package actions.ViewIdeaFields;

import actions.selenium.SetText
import actions.common.ViewIdeaCommon
import actions.selenium.SendKeys
import actions.selenium.Click

class SetViewIdeaDescriptionTabDesiredExpertise{
    public void run(def params){
        ViewIdeaCommon.NavigateTab("Tab":"Description")

        ViewIdeaCommon.DescriptionEnableEdit("Field Name":"Expertise Required")
        if(params."Expertise Name"){
            params."Expertise Name".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){
                       SetText.run(ID:"//*[@id='idea-expertise-input_tag']",Text:name)
                       sleep(2000)
                       SendKeys.run(ID:"//*[@id='idea-expertise-input_tag']",Key:"ENTER")
                   }
                else if (params."Add or Remove".split(",")[x]=="Remove"){
                       Click.run(ID:"//*[@id='idea-expertise-input_tagsinput']//SPAN[contains(text(),'${name}')]/following-sibling::A")
                   }
                else if(params."Add or Remove".split(",")[x]=="Ignore"){
                     	SetText.run(ID:"//*[@id='idea-expertise-input_tag']",Text:name)
                }   
            }
        }
        ViewIdeaCommon.DescriptionAction("Field Name":"Expertise Required","Action":params.Action)
        sleep(2000)
    }
}