package actions.SetScorecardFields;

import actions.selenium.SetText

class SetShortTextField{
    public static void run(def params){
        
        if(params."Page"=="View Idea3"){
             if(params."Field Value"){SetText.run(ID:"//*[@class='f-quest-c']/*[.='${params."Field Name"}']/..//INPUT",Text:params."Field Value")}          
        } else {
            if(params."Field Value"){SetText.run(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='eval_quesiton_short']",Text:params."Field Value")}            
        }
    }
}
