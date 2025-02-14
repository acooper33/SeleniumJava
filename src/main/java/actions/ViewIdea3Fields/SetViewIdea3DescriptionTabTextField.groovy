package actions.ViewIdea3Fields;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.MouseOver
import actions.common.ViewIdea3Common
import actions.selenium.SendKeyboardAction

class SetViewIdea3DescriptionTabTextField{
     public void run(def params){
//        ViewIdea3Common.NavigateTab("Tab":"Idea")

        def id
        if(params."Field Name"=="Description"){
            ViewIdea3Common.DescriptionAction(params)
        }
        else if(params."Field Name"=="Title") {
            MouseOver.run(ID:"//*[contains(@class,'f-title-container')]")
            Click.run(ID:"//*[contains(@class,'f-title-container')]//I","Type of Click":"Javascript")
            id="//*[@id='f-edit-textarea-title']"
            sleep(2000)
            SetText.run(Text:params."Field Value",ID:id,"Type of Clear":"Cut")
            //SendKeyboardAction.run(Button:"ENTER")
        }
        sleep(2000)
         
        ViewIdea3Common.DescriptionAction(params)
    }
}