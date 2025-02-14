package actions.SetDevelopmentFields;

import actions.selenium.VerifyText
import actions.selenium.Exists


class VerifyDevTextField{
    public static void run(def params){
        if(params."Field Title"){
            if(params."Question Type".contains("long")){
                VerifyText.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//TEXTAREA", Text:params."Field Value")
                VerifyText.run(ID:"//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-answer']", Text:params."Field Value")
            }
            else if (params."Question Type".contains("dropdown")){
                VerifyText.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//SELECT/OPTION[@selected]", Text:params."Field Value")
            	VerifyText.run(ID:"//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-answer']", Text:params."Field Value")
            
            }
            else if(params."Question Type".contains("user")){
                if(params."Field Value"==null){
                    assert Exists.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//DIV[@id='member_search_input']//span")==0, "Error - Unexpected Value in User Selection Field"
                    //VerifyText.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//DIV[@id='member_search_input']//span", "Contains Text":'<EMPTY>')
    				VerifyText.run(ID:"//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-answer']", Text:"No user selected.")
                
                }else{
                    VerifyText.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//DIV[@id='member_search_input']//span", "Contains Text":params."Field Value")
                    VerifyText.run(ID:"//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-user-info-wrapper']/A", Text:params."Field Value")
                 	if(params."User Pic"){assert Exists.run(ID:"//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-user-info-wrapper']/IMG[contains(@src,'getfile.php')]")>0, "Error - Profile Pic in User Selection Field Not Found"}
                }
                //VerifyText.run(ID:"//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-user-info-wrapper']/A", Text:params."Field Value")
                //if(params."User Pic"){assert Exists.run(ID:"//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-user-info-wrapper']/IMG[contains(@src,'getfile.php')]")>0, "Error - Profile Pic in User Selection Field Not Found"}
                //question-user-info-wrapper
            }
            else if(params."Question Type".contains("date")){
                VerifyText.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//INPUT", "Input Field Text":params."Field Value")
            	VerifyText.run(ID:"//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-answer']", Text:params."Field Value")
            }
            else{
                VerifyText.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//INPUT", "Input Field Text":params."Field Value")
            	VerifyText.run(ID:"//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-answer']", Text:params."Field Value")
            }
            //verify in the view idea additional questions
            //VerifyText.run(ID:"//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-answer']", Text:params."Field Value")
        }
    }
}