package actions.SetScorecardFields;

//import actions.selenium.SendKeys
import actions.selenium.SetText
import actions.selenium.Click

class SetLongTextField{
    public static void run(def params){
        
         if(params."Page"=="View Idea3"){
              if(params."Field Value"){
                 Click.run(ID:"//*[@class='f-quest-c']/*[.='${params."Field Name"}']/..//*[@class='fractal-textarea']/*")
                 SetText.run(ID:"//*[@class='f-quest-c']/*[.='${params."Field Name"}']/..//*[@class='fractal-textarea']/*",Text:params."Field Value") 
             }   
         } else {
             if(params."Field Value"){
                 Click.run(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='eval_question_long']")
            	//SendKeys.run(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='eval_question_long']",Text:params."Field Value")
                 SetText.run(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='eval_question_long']",Text:params."Field Value") 
             } 
         }
    }
}