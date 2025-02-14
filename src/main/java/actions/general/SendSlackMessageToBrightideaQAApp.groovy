package actions.general;

import actions.selenium.Click
import actions.Whiteboards.SendKeysToWhiteboard

class SendSlackMessageToBrightideaQAApp{
    public void run(def params){
        Click.run(ID:"//DIV[contains(@class,'tab_menu')]//BUTTON[@id='messages']", "Type of Click":"Javascript")
        sleep(1000)
        Click.run(ID:"//DIV[@data-qa='message_input']/DIV/P", "Type of Click":"Javascript")
        SendKeysToWhiteboard.run("Key(s) to send":"logout")
        SendKeysToWhiteboard.run("Key(s) to send":"Enter")
        sleep(1000)
        //SetText.run(ID:"//DIV[@data-qa='message_input']/DIV/P", Text:params."Message")
        println("Message: ${params."Message"}")
        /*SetTextByPasting.run(ID:"//DIV[@data-qa='message_input']/DIV/P", Text:params."Message")
        SendKeys.run(ID:"//DIV[@data-qa='message_input']/DIV/P", Key:"ENTER")*/
        
        //JavascriptExecutor jse = (JavascriptExecutor)Browser.Driver
		//jse.executeScript("document.getElementsByClassName('ql-editor').value='logout';");
        
        Click.run(ID:"//BUTTON[@data-qa='texty_send_button']", "Type of Click":"Javascript")
        sleep(1000)
    }
}