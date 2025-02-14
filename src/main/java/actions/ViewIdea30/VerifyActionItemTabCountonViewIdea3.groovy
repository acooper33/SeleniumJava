package actions.ViewIdea30;

import actions.selenium.Exists
import actions.selenium.Click

class VerifyActionItemTabCountonViewIdea3{
    public void run(def params){
        
        if(params."Tab Count"){
            if(params."Tab Count"=='0'){
                assert Exists.run(ID:"//*[contains(@class,'f-btn-link-animated f-btn-sm') and .='${params."Tab"} ']")==1, "Error - count for this tab is not 0"
            } else {
                assert Exists.run(ID:"//*[contains(@class,'f-btn-link-animated f-btn-sm') and .='${params."Tab"} (${params."Tab Count"})']")==1, "Error - Incorrect count for tab"
            }            
        } 
    }
}