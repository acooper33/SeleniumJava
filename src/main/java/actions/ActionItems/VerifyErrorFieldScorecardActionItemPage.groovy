package actions.ActionItems;

import actions.selenium.Exists

class VerifyErrorFieldScorecardActionItemPage{
    public void run(def params){
    	if(params."Should Error Exist"==true){
        	assert Exists.run(ID:"//*[@class='eval_question required_error']/*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]")>0, "Error - Expected error field was not found"
       	}
        else{
            assert Exists.run(ID:"//*[@class='eval_question required_error']/*[@class='eval_title' and contains(normalize-space(.),'${params."Field Name"}')]")==0, "Error - Found Unexpected Error field"
        }
    }
}