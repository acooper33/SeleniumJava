package actions.ViewIdeaFields;

import actions.common.ViewIdeaCommon
import actions.selenium.Click
import java.nio.file.Paths
import actions.selenium.SendKeys

class SetViewIdeaInsertImageforTextField{
    public void run(def params){
        ViewIdeaCommon.NavigateTab("Tab":"Description")
        ViewIdeaCommon.DescriptionEnableEdit(params)
        sleep(2000)
        if(params."Field Name"=="Description"){Click.run(ID:"//DIV[@id='description-text-container']//DIV[@class='redactor-toolbar']/A[@aria-label='Image']")}
        else{Click.run(ID:"//DIV[starts-with(@id,'question-title-holder')]/DIV[contains(text(),'${params."Field Name"}')]/../..//DIV[@class='redactor-toolbar']/A[@aria-label='Image']")}
		//Get path to file we are sending
        def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Image File"}"
        //Now send a file to the 'fallback_input' element
        SendKeys.run(ID:"//*[@class='redactor-modal-header' and .='Image']/..//INPUT[@type='file']", Text:fileName)
        sleep(7000)
        ViewIdeaCommon.DescriptionAction(params)
    }
}
