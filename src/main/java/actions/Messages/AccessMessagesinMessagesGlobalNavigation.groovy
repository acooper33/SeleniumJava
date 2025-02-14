package actions.Messages;

import actions.selenium.Click

class AccessMessagesinMessagesGlobalNavigation{
    public void run(def params){
        Click.run(ID:"//*[@id='messages']//*[@class='global-nav-section']")
        sleep(2000)
        if(params."Message" && params."Sender"){
            Click.run(ID:"//*[@id='messages']//*[@class='message-screenname' and text()='${params."Sender"}']/following-sibling::DIV[@class='message-desc' and text()='${params."Message"}']")
            sleep(2000)
        }
        if(params."Send a New Message"==true){
            Click.run(ID:"//*[@id='messages-new-send']")
        }
        if(params."See All Messages"==true){
            Click.run(ID:"//*[@id='messages']//*[@class='dropdown-footer']/A")
        }
    }
}