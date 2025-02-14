package actions.ViewIdea30;

import actions.selenium.SetText
import actions.selenium.Click

class SetSubmitterinViewIdea3UsingDropdown{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-hover-${params."Field".toLowerCase()}')]/I","Type of Click":"Javascript")
        if(params."User"){
            if(params."Field"=="Owner"){
                SetText.run(ID:"//*[contains(@class,'f-idea-owner')]//input[contains(@CLASS,'react-tags__combobox-input')]",Text:params."Search User Text","Type of Clear":"None")
            } else {
                SetText.run(ID:"//*[contains(@class,'f-submitter')]//input[contains(@CLASS,'react-tags__combobox-input')]",Text:params."Search User Text","Type of Clear":"None")
            }
            
            //sleep(1000)
            Click.run(ID:"//*[@class='react-tags__listbox']//*[text()='${params."User"}']/../../..","Type of Click":"Move to Element")
            //sleep(2000)
        }
        if(params."Clear owner"){
           Click.run(ID:"//*[@class='f-tag-remove']/I")
           sleep(1000)
        }
        Click.run(ID:"//*[@class='f-component-title f-component-title-bold' and text()='Status']")
    }
}