package actions.ViewIdeaComment;

import actions.selenium.Click

class SetSortingforComments{
    public void run(def params){
        
        Click.run(ID:"//*[@data-test='f-test-comment-sort-dropdown']","Type of Click": "Javascript")
        Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//*[text()='${params."Sorting Option"}']","Type of Click": "Javascript")        
    }
}