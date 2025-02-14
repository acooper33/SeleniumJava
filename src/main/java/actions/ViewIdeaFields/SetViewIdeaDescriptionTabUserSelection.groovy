package actions.ViewIdeaFields;

import actions.selenium.SetText
import actions.selenium.SendKeys
import actions.common.ViewIdeaCommon
import actions.selenium.Click


class SetViewIdeaDescriptionTabUserSelection{
    public void run(def params){
        ViewIdeaCommon.NavigateTab("Tab":"Description")

        ViewIdeaCommon.DescriptionEnableEdit("Field Name":params."Field Name")
        if(params."User Name"){
            params."User Name".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){

                    SetText.run(ID:"//*[@class='question-title' and starts-with(text(), 'User Selection Question')]/../..//div[contains(@id,'addTag')]/input[contains(@id,'tag')]",Text:name)
                    sleep(2000)
                    SendKeys.run(ID:"//*[@class='question-title' and starts-with(text(), 'User Selection Question')]/../..//div[contains(@id,'addTag')]/input[contains(@id,'tag')]",Key:"ENTER")
                }
                else{
                    Click.run(ID:"//*[contains(@id,'_tagsinput')]//SPAN[contains(text(),'${name}')]/following-sibling::A")
                }
            }
        }
        ViewIdeaCommon.DescriptionAction("Field Name":params."Field Name", "Action":params."Action")
    }
}