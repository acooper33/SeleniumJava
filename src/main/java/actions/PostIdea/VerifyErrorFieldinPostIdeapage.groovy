package actions.PostIdea;

import actions.selenium.Exists

class VerifyErrorFieldinPostIdeapage{
    public void run(def params){
        if(params."Should Error Exist"){
            assert Exists.run(ID:"//*[contains(@class,'invalid')]//LEGEND[contains(text(),'${params."Field Name"}')]")>0,"Error - Expected error field was not found"
        }
        else{
            assert Exists.run(ID:"//*[contains(@class,'invalid')]//LEGEND[contains(text(),'${params."Field Name"}')]")==0,"Error - Error field that was NOT expected was found"
        }
    }
}