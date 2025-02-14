package actions.UserProfile;

import actions.selenium.Click

class SetTabonUserProfilepage{
    public void run(def params){
        
        Click.run(ID:"//*[@class='profile_horizontal_tabs']//*[contains(text(),'${params."Tab"}')]") 
    }
}