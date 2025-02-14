package actions.Widgets;

import actions.selenium.Click

class AccessUserProfilepagefromUserCommunityWidget{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'user_community_widget')]//IMG[@title='${params."User"}']")
        
    }
}