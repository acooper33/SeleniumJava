package actions.WebstormCreation;

import actions.selenium.Exists

class VerifyCreateWebstormErrorRequiredField{
    public void run(def params){

        if(params."Field Name"!="Plural Name of Submission Name") {
            if(params."Should Error Exist"){
                assert Exists.run(ID:"//*[(contains(@class,'error') or @class='bi-form validated invalid' or @class='form-control error') and contains(.,'${params."Field Name"}')]")>0, "Error - Expected error field was not found"
            }
            else {
                assert Exists.run(ID:"//*[(contains(@class,'error') or @class='bi-form validated invalid' or @class='form-control error') and contains(.,'${params."Field Name"}')]")==0, "Error - Error field that was NOT expected was found"

            }       
        } 
        else if(params."Should Error Exist") {
            assert Exists.run(ID:"//*[(contains(@class,'error') or @class='bi-form validated invalid' or @class='form-control error')]/..//*[contains(.,'plural name for your Submission Name')]")>0, "Error - Expected error field was not found"
        }
        else {
            assert Exists.run(ID:"//*[(contains(@class,'error') or @class='bi-form validated invalid' or @class='form-control error')]/..//*[contains(.,'plural name for your Submission Name')]")==0, "Error - Error field that was NOT expected was found"

        }    
    }
}
