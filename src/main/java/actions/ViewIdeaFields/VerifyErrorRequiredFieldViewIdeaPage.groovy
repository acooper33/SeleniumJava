package actions.ViewIdeaFields;

import actions.selenium.Exists

class VerifyErrorRequiredFieldViewIdeaPage{
    public void run(def params){
        if(params."Should Error Exist"){
            //assert Exists.run(ID:"//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/../../DIV/INPUT[contains(@class,'required-question-error')]")>0, "Error - Expected error field was not found"
            assert Exists.run(ID:"//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/../..//*[contains(@class,'required-question-error')]")>0, "Error - Expected error field was not found"

        }
        else {
            //assert Exists.run(ID:"//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/../../DIV/INPUT[contains(@class,'required-question-error')]")==0, "Error - Error field that was NOT expected was found"
            assert Exists.run(ID:"//*[@class='question-title' and starts-with(text(),'${params."Field Name"}')]/../..//*[contains(@class,'required-question-error')]")==0, "Error - Error field that was NOT expected was found"

        }
        
    }
}