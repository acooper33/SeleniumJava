package actions.SetScorecardFields;

import actions.selenium.SelectItem
import actions.selenium.Click

class SetDropdown{
    public static void run(def params){
        
        if(params."Page"=="View Idea3"){
            if(params."Field Value"){
                params."Field Value".split(',').each{value ->
                    Click.run(ID:"//*[@class='f-quest-c']/*[.='${params."Field Name"}']/..//*[@class='f-quest-select']//LI/*[text()='${value}']")
            	}
            }            
        } else {
            if(params."Field Value"){
                params."Field Value".split(',').each{value ->
                    SelectItem.run(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='eval_question_select']","Visible Text":value)
            	}
            }
        }        
    }
}