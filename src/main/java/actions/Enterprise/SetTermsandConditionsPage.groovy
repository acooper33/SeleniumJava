package actions.Enterprise;

import actions.selenium.Exists
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetTermsandConditionsPage{
    public void run(def params){
        
         if(params."Terms and Conditions Text"){
             assert Exists.run(ID:"//*[@id='read_terms_body' and contains(text(),'${params."Terms and Conditions Text"}')]")==1, "Error - Terms and Conditions text not matching"
        }
        SetCheckBox.run(ID:"//*[@id='agree_terms_condition']",Check:params."Agree Terms and Conditions Checkbox")
        Click.run(ID:"//*[@id='complete_ent-terms_btn']")
        sleep(2000)
    }
}