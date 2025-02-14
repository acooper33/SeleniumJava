package actions.SetDevelopmentFields;

import actions.selenium.SetText
import actions.selenium.Browser
import actions.selenium.utils.Elements

class SetDevTextField{
    public static void shortTextField(def params){
        if(params."Field Value"){SetText.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//INPUT", Text:params."Field Value")}
    }
    public static void longTextField(def params){
        if(params."Field Value"){SetText.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//TEXTAREA", Text:params."Field Value")}
    }
}