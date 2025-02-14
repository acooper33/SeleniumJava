package actions.SetScorecardFields;

import actions.selenium.utils.Elements
import actions.selenium.Browser


class VerifyMultiChoiceOneAnswer{
    public static void run(def params){
        
        if(params."Field Name"){
            def xPathClass = params."Question Type"
            //println("My Question type: ${xPathClass}")
            def answers = []
            def matchFound
            answers = Elements.findAll(ID:"//*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]/..//*[@class='${xPathClass}' and ../..//INPUT[@checked]]", Browser.Driver)
            //verify the number of answers
            if(params."Field Value"==null){assert answers.size()==0, "Error - Unexpected Number of Answers in ${params."Field Name"}"}
            else{
               	assert answers.size()==params."Field Value".split(',').size(), "Error - Unexpected Number of Answers in ${params."Field Name"}"
            	//for each expected value, match an actual answer
            	params."Field Value".split(',').each{expectedValue ->
                	//println("Moving to match expected ${expectedValue}")
                	matchFound = false
                	answers.each{actualAnswer ->
                    	//println("Does it match ${actualAnswer.getText()}")
                    	if(expectedValue.trim().contains(actualAnswer.getText().trim())){matchFound = true}
                	}
                	assert matchFound==true, "Error - Expected Answer ${expectedValue} not Found"
                }
            }
        }        
    }
}