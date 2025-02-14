package actions.ViewIdeaFields;

import actions.common.ViewIdeaCommon
import actions.selenium.Click
import java.nio.file.Paths
import actions.selenium.SetText

class SetViewIdeaInsertVideoLongTextField{
    public void run(def params){
        ViewIdeaCommon.NavigateTab("Tab":"Description")
        ViewIdeaCommon.DescriptionEnableEdit(params)
        sleep(2000)
        if(params."Field Name"=="Description"){Click.run(ID:"//DIV[@id='description-text-container']//DIV[@class='redactor-toolbar']/A[@aria-label='Video']")}
        else{Click.run(ID:"//DIV[starts-with(@id,'question-title-holder')]/DIV[contains(text(),'${params."Field Name"}')]/../..//DIV[@class='redactor-toolbar']/A[@aria-label='Video']")}
        SetText.run(Text:params."Field Value",ID:"//*[@id='modal-video-input']", "Type of Clear":"Cut")
        Click.run(ID:"//*[@id='redactor-modal']//*[text()='Insert']")
        sleep(1000)
        ViewIdeaCommon.DescriptionAction(params)
    }
}