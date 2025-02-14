package actions.SetScorecardFields;

import actions.selenium.Click

class SetMultiChoiceOneAnswer{
    public static void run(def params){
        
         if(params."Page"=="View Idea3"){
             if(params."Field Value"){
                 params."Field Value".split(',').each{value -> 
                     Click.run(ID:"//*[contains(@class,'f-quest-c')]/*[text()='${params."Field Name"}']/..//*[@class='f-quest-radio']//*[text()='${value}']/../*[@class='f-radio-outer']")
                 }
             }             
         } else {
             if(params."Field Value"){
                 params."Field Value".split(',').each{value -> 
                     Click.run(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='radio_label' and starts-with(normalize-space(.),'${value}')]/../..//INPUT")
                 }
             }
         }        
    }
}