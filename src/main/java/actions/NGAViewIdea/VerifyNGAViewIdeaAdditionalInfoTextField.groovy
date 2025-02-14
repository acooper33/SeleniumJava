package actions.NGAViewIdea;

import actions.common.NGAViewIdeaCommon
import actions.selenium.*

class VerifyNGAViewIdeaAdditionalInfoTextField{
    public void run(def params){
        NGAViewIdeaCommon.NavigateTab(Tab:"Additional Info")
        VerifyText.run(Text:params."Field Value",ID:"//*[@class='question-title' and contains(text(),'${params."Field Name"}')]/../..//*[@class='question-answer']")
    }
}