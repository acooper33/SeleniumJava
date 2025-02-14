package actions.Memo;

import actions.selenium.*

class NavigateTabinMyReviews{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-tab')]//*[not(contains(@class,'f-tab-selected')) and contains(text(),'${params."Tab"}')]")
        
    }
}