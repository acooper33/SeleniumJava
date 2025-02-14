package actions.NGAViewIdea;

import actions.common.*
import actions.selenium.*
import actions.NGAViewIdea.*

class VerifyNGAViewIdeaDevelopmentFieldValue{
    public void run(def params){
        if(params."Field Value"){
            NGAViewIdeaCommon.NavigateTab(Tab:"Description")
            if(params."Field Name".contains("Attachment")){VerifyText.run(ID:"//*[@class='question-name' and starts-with(text(),'${params."Field Name"}')]/../DIV[@class='question-scores-wrapper']//A","Text":params."Field Value")}
            else{VerifyText.run(ID:"//*[@class='question-name' and starts-with(text(),'${params."Field Name"}')]/../DIV[@class='question-scores-wrapper']/DIV","Text":params."Field Value")}
        }
    }
}