package actions.SetScorecardFields;

import actions.selenium.utils.Elements
import actions.selenium.Browser


class VerifyDropdown{
    public static void run(def params){
        if(params."Field Name"){
            def answers
            answers = Elements.findAll(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='eval_question_select']/OPTION[@selected and not(@value='null')]", Browser.Driver)
            if(params."Field Value"==null){assert answers.size()==0, "Error - Unexpected answer in ${params."Field Name"}"}
            else{
                assert answers.size()==1, "Error - Unexpected answer in ${params."Field Name"}"
                assert answers[0].getText().trim().equals(params."Field Value"), "Error - found answer ${answers[0].getText()}, but expected ${params."Field Value"}"
            }
		}
    }
}