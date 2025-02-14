package actions.SetDevelopmentFields;

import actions.selenium.Exists

class VerifyErrorFieldDevelopment{
    public void run(def params){
        def a = params."Field Title"
        if(params."Should Error Exist"==true){
            assert Exists.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/ancestor::DIV[contains(@class,'question-required') and contains(@style,'red')]")>0, "Error - Expected error field was not found"
        }else {
            assert Exists.run(ID:"//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/../DIV[contains(@class,'question-required') and contains(@style,'red')]")==0, "Error - Found Unexpected Error field"
        }        
    }
}