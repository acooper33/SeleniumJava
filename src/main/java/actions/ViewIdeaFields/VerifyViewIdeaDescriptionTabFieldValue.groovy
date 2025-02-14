package actions.ViewIdeaFields;

import actions.common.ViewIdeaCommon
import actions.selenium.Click
import actions.selenium.VerifyText
import actions.selenium.Exists
import actions.selenium.utils.Elements
import actions.selenium.Browser

class VerifyViewIdeaDescriptionTabFieldValue{
    public void run(def params){
        if(params."Field Value"){
            ViewIdeaCommon.NavigateTab(Tab:"Description")

            if(params."Field Value"=="Image"){
                assert Exists.run(ID:"//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV/DIV[2]//IMG[.]","Timeout":20)>0,"Error - Image for field ${params."Field Name"} not found"
            }
            else if(params."Field Value"=="Video"){
                assert Exists.run(ID:"//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/parent::DIV/parent::DIV/DIV[2]//IFRAME[contains(@src,'www.youtube.com') or contains(@src,'vimeo.com')]","Timeout":20)>0,"Error - Video for field ${params."Field Name"} not found"
            }
            else{
                if(params."Position Number"){
                    VerifyText.run(ID:"//*[contains(@class,'question-wrapper visible')][${params."Position Number"}]//*[@class='question-title' and starts-with(text(),\"${params."Field Name"}\")]/parent::DIV/parent::DIV/DIV[2]","Text":params."Field Value")
                } else {
                    VerifyText.run(ID:"//*[@class='question-title' and starts-with(text(),\"${params."Field Name"}\")]/parent::DIV/parent::DIV/DIV[2]","Text":params."Field Value")
                }
            }
        }
    }
}