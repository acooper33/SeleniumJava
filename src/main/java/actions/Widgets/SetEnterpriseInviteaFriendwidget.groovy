package actions.Widgets;

import actions.selenium.*

class SetEnterpriseInviteaFriendwidget{
    public void run(def params){
        SetText.run(ID:"//*[@id='invitefriend']",Text:params."Email")
        Click.run(ID:"//*[contains(@class,'invite_a_friend_widget')]//*[@class='rightjustify']/A")
    }
}