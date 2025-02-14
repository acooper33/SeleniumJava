package actions.ViewIdeaFields;

import actions.selenium.SetText
import actions.common.ViewIdeaCommon

class SetViewIdeaAdditionalInfoTextField{
    public void run(def params){
        ViewIdeaCommon.NavigateTab(Tab:"Additional Info")
        
        SetText.run(Text:params."Field Value",ID:"//*[text()='${params."Field Name"}']/..//*[@class='answer']")
    }
}