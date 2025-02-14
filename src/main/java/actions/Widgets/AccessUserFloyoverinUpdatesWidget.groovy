package actions.Widgets;

import actions.selenium.MouseOver
import actions.selenium.Click

class AccessUserFloyoverinUpdatesWidget{
    public void run(def params){

        MouseOver.run(ID:"//*[@id='ws_updates_area']//*[contains(.,'${params."Update to hover"}') and contains(@style,'margin-left')]/A[@class='user-flyover']")

        if (params.Action){         
            if(params.Action=="Follow or Unfollow"){
                Click.run(ID:"//*[@id='user-fly-follow-btn']")
            } else if (params.Action=="Profile") {
                Click.run(ID:"//*[@id='user-fly-profile-btn']")
            } else { 
                Click.run(ID:"//*[@id='user-fly-message-btn']")        
            }
        }
    }
}
