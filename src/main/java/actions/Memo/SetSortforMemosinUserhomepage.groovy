package actions.Memo;

import actions.selenium.*

class SetSortforMemosinUserhomepage{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-memo-sort']//*[contains(@class,'f-dropdown-btn')]")
        Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//*[text()='${params."Sort"}']/..")
        
    }
}