package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SendKeyboardAction
import actions.Whiteboards.SendKeysToWhiteboard
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class EditTitleOfWhiteboard{
    public void run(def params){
        if(params.Title){
            Click.run(ID:"//SPAN[contains(@class,'f-canvas-name')]", "Handle Stale Element":true)
            //WebElement title = Elements.find(ID:"//DIV[@class='f-input-sizer']",Browser.Driver)
            //println("here we go: ${title.getAttribute("innerHTML")}")
            SendKeysToWhiteboard.run("Key(s) to send":params.Title)
            //SetText.run(ID:"//*[@id='f-canvas-rename']", Text:params.Title, "Type Of Clear":"Backspace") 
            sleep(2000)
        }
        if(params.Action=='Submit'){
            SendKeyboardAction.run("Button":"ENTER")
            //Click.run(ID:"//*[@class='f-title-edit-btns']/BUTTON[contains(@class,'f-add-btn')]")
        }
        if(params.Action=='Cancel'){
            SendKeyboardAction.run("Button":"ESCAPE")
            //Click.run(ID:"//*[@class='f-title-edit-btns']/BUTTON[contains(@class,'f-end-btn')]")
        }
        sleep(3000)
    }
}