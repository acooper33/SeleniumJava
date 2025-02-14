package actions.Memo;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SendKeyboardAction
import actions.Whiteboards.SendKeysToWhiteboard

class ColabEditorSetMemoTitle{
    public void run(def params){
        if(params."New Title"){
        	Click.run(ID:"//SPAN[contains(@class,'f-memo-title')]", "Type Of Click":"Javascript")
            SendKeysToWhiteboard.run("Key(s) to send":params."New Title")
            //SetText.run(ID:"//*[contains(@class,'fractal-input')]", Text:params."New Title", "Type Of Clear":"Cut")
            //SetText.run(ID:"//*[@id='f-memo-rename']", Text:params."New Title", "Type Of Clear":"Cut")
            sleep(500)
        }
        if(params.Action=='Submit'){
            SendKeyboardAction.run("Button":"ENTER")
            //Click.run(ID:"//*[@class='f-title-edit-btns']/BUTTON[contains(@class,'f-add-btn')]")
        }
        if(params.Action=='Cancel'){
            SendKeyboardAction.run("Button":"ESCAPE")
            //Click.run(ID:"//*[@class='f-title-edit-btns']/BUTTON[contains(@class,'f-end-btn')]")
        }
        sleep(10000)
    }
}