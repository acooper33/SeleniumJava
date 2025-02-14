package actions.Memo;

import actions.selenium.Click

class SetReviewRequestDropdownorButton{
    public void run(def params){
        
       if(params."Click on button"){
            Click.run(ID:"//*[contains(@class,'f-memo-review-dropdown')]/BUTTON[.='${params."Click on button"}']")
        } 
        
        if(params."Dropdown Options"){
            Click.run(ID:"//*[contains(@class,'f-memo-review-dropdown')]//*[contains(@class,'f-review-dropdown-btn')]//*[@class='fa fa-chevron-down']")
            Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//*[text()='${params."Dropdown Options"}']")
        }
        
    }
}