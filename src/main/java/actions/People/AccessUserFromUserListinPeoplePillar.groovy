package actions.People;

import actions.selenium.Click

class AccessUserFromUserListinPeoplePillar{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'user-link') and contains(text(),'${params."User Email or Screen Name"}')]") 
    }
}