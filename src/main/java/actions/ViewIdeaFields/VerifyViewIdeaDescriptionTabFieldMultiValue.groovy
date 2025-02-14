package actions.ViewIdeaFields;

import actions.common.ViewIdeaCommon
import actions.selenium.Click
import actions.selenium.VerifyText

class VerifyViewIdeaDescriptionTabFieldMultiValue{
    public void run(def params){
        if(params."Field Value"){
            ViewIdeaCommon.NavigateTab(Tab:"Description")
        
            if(params."Field Value"=="<EMPTY>"){VerifyText.run(ID:"//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV/DIV[2]","Text":"<EMPTY>")}
            else{
                params."Field Value".split(",").eachWithIndex{ value, x ->
                    VerifyText.run(ID:"//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV/DIV[2]","Contains Text":value)
                }
            }
        }
    }
}