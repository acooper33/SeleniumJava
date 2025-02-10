package actions.WebstormHomepage;

import actions.selenium.Click
import actions.selenium.Exists

class SetActionOnChangeBackgroundModal{
    public static void setAction(def params){

        if(params."Action"){
            def j = 1
            if(Exists.run(ID:"//*[contains(@class,'f-idea-modal-container')]")>0){j = 2}
            if(params."Action".contains("Add") | (params."Action".contains("Insert")) | (params."Action".contains("Update"))){
                Click.run(ID:"(//*[contains(@class,'footer')]//BUTTON[position()='2'])[${j}]")
            } else {
                Click.run(ID:"(//*[contains(@class,'footer')]//BUTTON[position()='1'])[${j}]")
            }
        }
    }
}