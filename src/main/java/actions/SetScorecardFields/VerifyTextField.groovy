package actions.SetScorecardFields;

import actions.selenium.VerifyText

class VerifyTextField{
    public static void run(def params){
        if(params."Field Name"){
            if(params."Question Type".contains("long")){
                VerifyText.run(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='${params."Question Type"}']",Text:params."Field Value")
            }else{
                //println("Verifying Short Answer")
                //println("Question name: '${params."Field Name"}'")
                //println("Passing ${params."Field Value"}")
                VerifyText.run(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='${params."Question Type"}']","Input Field Text":params."Field Value")
            }
        }
    }
}