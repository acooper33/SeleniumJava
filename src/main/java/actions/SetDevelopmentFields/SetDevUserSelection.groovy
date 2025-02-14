package actions.SetDevelopmentFields;

import actions.selenium.Click
import actions.selenium.SetText

class SetDevUserSelection{
    public static void run(def params){
        if(params."Field Value"){
            Click.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//DIV[@id='member_search_input']")
            params."Field Value".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){
                	sleep(500)
                    SetText.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//DIV[@id='member_search_input']", Text:name)
                	sleep(500)
                    Click.run(ID:"//LI[contains(@class,'atwho-item user-typeahead')and @data-display_name='${name}']", "Type of Click":"Javascript")
                }
                //delete user
                else{
                    Click.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//DIV[@id='member_search_input']//SPAN[@class='eval_left' and contains(.,'${name}')]/following-sibling::A[contains(@class,'eval_right')]")
                }
        	}
    	}
	}
}