package actions.SetScorecardFields;

import actions.selenium.Click

class SetMultiChoiceMultiAnswer{
    public static void run(def params){
        
        if(params."Page"=="View Idea3"){
             if(params."Field Value"){
                 params."Field Value".split(',').each{value -> 
                     Click.run(ID:"//*[@class='f-quest-c']/*[.='${params."Field Name"}']/..//*[text()='${value}']/../..//*[@class='f-checkbox-inner']")
                 }
             }             
         } else {
            if(params."Field Value"){
                params."Field Value".split(',').each{ value ->
                    Click.run(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='checkbox_label' and starts-with(normalize-space(.),'${value}')]/../..//INPUT")
                }
            }
        }    
    }
}