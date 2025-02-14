package actions.Memo;

import actions.selenium.Exists
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetandVerifyleftpanelinReviewResultmodal{
    public void run(def params){
        
        if(params."Question to be clicked"){
            Click.run(ID:"//*[@class='f-quick-jump-item' and contains(@data-tooltip-id,'f-question')]/*[text()='${params."Question to be clicked"}']")
        }
        if (params."Reviewer"){
            params."Reviewer".split(",").eachWithIndex{ reviewer, x ->
                SetCheckBox.run(ID:"//*[@class='f-checkbox-user-name' and text()='${reviewer}']/../../../../..//INPUT/..",Check:params."Reviewer Checkbox Check".split(",")[x].toBoolean())
                if(params."Score"){
                    assert Exists.run(ID:"//*[@class='f-checkbox-user-name' and text()='${reviewer}']/../..//*[@class='f-score' and .='${params."Score".split(",")[x]}']")==1, "Error - incorrect score for reviewer ${reviewer}"
                }
            }
        }        
    }
}