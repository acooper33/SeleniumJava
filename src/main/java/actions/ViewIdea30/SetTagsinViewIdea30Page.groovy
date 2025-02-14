package actions.ViewIdea30;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetFocus
import actions.selenium.SetReactTags

class SetTagsinViewIdea30Page{
    public void run(def params){
        
        sleep(3000)
        SetFocus.run(ID:"//*[contains(@class,'f-edit-tags')]//input[contains(@class,'react-tags__combobox-input')]/..") 
        Click.run(ID:"//*[@id='f-tags-container']//I[contains(@class,'far fa-pencil')]","Type of Click":"Move to Element")
        sleep(500)
        if (params."Tag Name"){
            SetReactTags.setIdeaTagsOrExpertise("Tag Name":params."Tag Name", "Tag Add or Remove":params."Add or Remove", "Set Tab":params."Set Tab")
        }
        /*
        if (params."Tags"){
            params."Tags".split(",").eachWithIndex{ tag, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[contains(@class,'f-edit-tags')]//input[contains(@class,'react-tags__combobox-input')]",Text:tag,"Type of Clear":"None")
                    sleep(2000)
                    if(params."Set Tab"){                        
                        def setTab = params."Set Tab".split(",")
                        Click.run(ID:"//*[contains(@class,'f-tag-suggestion-name')][normalize-space()='${setTab[x]}']") 
                        sleep(4000)
                    }
                    Click.run(ID:"//*[contains(@class,'react-tags__listbox')]//*[contains(text(),'${tag}')]/../../..")
                }	
                else{
                    Click.run(ID:"//*[contains(@class,'f-tag-name') and text()='${tag}']/..//*[contains(@class,'f-rmv-tag')]")
                }
            } 
        }*/
        Click.run(ID:"//*[@class='f-component-title f-component-title-bold' and text()='Status']")
        sleep(2000)
    }
}