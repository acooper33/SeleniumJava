package actions.Webstorm;

import actions.selenium.Click

class SubscribetoChallenge{
    public void run(def params){
        if(params."Subscribe or Unsubscribe") {
            if(params."Subscribe or Unsubscribe"=="Subscribe"){
            	Click.run(ID:"//*[@id='hh-subscribe']//*[text()='Subscribe']")
        	}
            if(params."Subscribe or Unsubscribe"=="Unsubscribe"){
                Click.run(ID:"//*[@id='hh-subscribe']//*[text()='Subscribed']")
            }
        }
    }
}