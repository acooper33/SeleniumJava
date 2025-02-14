package actions.NGAViewIdeaFields;

import actions.common.NGAViewIdeaCommon
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SendKeys

class SetNGAViewIdeaUserSelection{
    public static void run(def params) {
	    //NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        NGAViewIdeaCommon.DescriptionEnableEdit(params)
        //NGAViewIdeaCommon.SubmissionFormFieldEnableEdit(params)
        if(params."User Name"){
            params."User Name".split(",").eachWithIndex{name, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@class='question-title' and contains(text(), 'User Selection Question')]/../..//div[contains(@class,'member-typeahead')]/div[contains(@id,'member_search_input')]",Text:name)
                    //SetText.run(ID:"//*[@class='question-title' and contains(text(), 'User Selection Question')]/../..//DIV[@class='question-answer-edit-wrapper']")
                    sleep(2000)
                    SendKeys.run(ID:"//*[@class='question-title' and contains(text(), 'User Selection Question')]/../..//div[contains(@class,'member-typeahead')]/div[contains(@id,'member_search_input')]",Key:"ENTER")
                }
                else{
                    Click.run(ID:"//*[@class='question-title' and contains(text(), 'User Selection Question')]/../..//div[contains(@class,'member-typeahead')]/div[contains(@id,'member_search_input')]//span[contains(text(),'${name}')]/following-sibling::A")
               		//Click.run(ID:"//*[@class='question-title' and contains(text(), 'User Selection Question')]")
                }
                
            }
            NGAViewIdeaCommon.DescriptionAction(params)
        }
    }
}