package actions.Widgets;

import actions.selenium.*

class VerifyUsersinUserCommunityWidget{
    public void run(def params){
        
         if (params."Users"){
            params."Users".split(",").eachWithIndex{ user, x ->
                if(params."User Should Exist".split(",")[x]=="TRUE"){
                    assert Exists.run(ID:"//*[contains(@class,'user_community_widget')]//IMG[@title='${user}']") == 1,"Error - Failed to find User ${user}"
                }
                else{
                    assert Exists.run(ID:"//*[contains(@class,'user_community_widget')]//IMG[@title='${user}']") == 0,"Error - User ${user} found but should NOT exist"
                }
            } 
        }
    }
}