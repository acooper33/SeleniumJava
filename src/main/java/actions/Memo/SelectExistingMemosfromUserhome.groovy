package actions.Memo;

import actions.selenium.Click

class SelectExistingMemosfromUserhome{
    public void run(def params){
        
         Click.run(ID:"//*[contains(@class,'f-memo-thumbnail f-userhomepage-card f-memo-thumbnail-full')]//*[@class='f-memo-thumbnail-title' and text()='${params."Memo Title"}']")
        
    }
}