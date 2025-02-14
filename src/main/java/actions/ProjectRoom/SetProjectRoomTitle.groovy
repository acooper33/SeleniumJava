package actions.ProjectRoom;

import actions.selenium.*
import actions.selenium.SendKeyboardAction

class SetProjectRoomTitle{
    public void run(def params){
        
        if(params."Verify Title"==true){
            VerifyText.run(ID:"//SPAN[contains(@class,'f-rooms-title')]",Text:params.Title)
        } else if (params."Verify Title"==false || params."Verify Title"==null){
            if(params.Title){
            Click.run(ID:"//SPAN[contains(@class,'f-rooms-title-text')]")
            SetText.run(ID:"//*[contains(@class,'f-rooms-title')]//*[contains(@class,'fractal-input')]//INPUT",Text:params.Title, "Type of Clear":"Cut")
            sleep(2000)
            } 
        }         
        if(params.Action=='Submit'){
            SendKeyboardAction.run("Button":"ENTER")
        }
        if(params.Action=='Cancel'){
            SendKeyboardAction.run("Button":"ESCAPE")
        }
        sleep(3000)
    }
}
