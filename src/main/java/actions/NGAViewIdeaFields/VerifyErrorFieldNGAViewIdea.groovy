package actions.NGAViewIdeaFields;

import actions.selenium.Exists

class VerifyErrorFieldNGAViewIdea{
    public void run(def params){
        if(params."Should Error Exist"){
            assert Exists.run(ID:"//*[starts-with(text(),'${params."Field Name"}')]/../..//*[contains(@class,'required-question-error')]")>0, "Error - Expected error field was not found"
            
			//Click.run(ID:"//*[starts-with(text(),'${params."Field Name"}')]/../..//input[starts-with(@value,'${params."Field Value"}')]")            
        }else{
            assert Exists.run(ID:"//*[starts-with(text(),'${params."Field Name"}')]/..//*[contains(@class,'required-question-error')]")==0, "Error - Unexpected error field was found"
        }
        
        
    }
}