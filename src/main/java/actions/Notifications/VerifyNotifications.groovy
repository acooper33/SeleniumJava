package actions.Notifications;

import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.GetText
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import actions.selenium.Browser

class VerifyNotifications{
    public void run(def params){
        if(Exists.run(ID:"//*[@class='global-nav-btn open']")==0){
            Click.run(ID:"//*[@class='fa fa-bell']") 
        }
        sleep(4000)
        def element 
        if(params."Notification Read Status"=="Read"){
           element = Elements.findAll(ID:"//*[contains(@class,'notifcation-item-read')]//div[@class='n-desc']",Browser.Driver)  
        } else{
          element = Elements.findAll(ID:"//*[contains(@class,'notifcation-item-unread')]//div[@class='n-desc']",Browser.Driver)  
        }               
        def numfound = 0
        element.each{
            //println("------Printing")
            println(GetText.run(Element:it))
            if(GetText.run(Element:it).contains(params."Notification message")){numfound++}
        }
        assert numfound.toString()==params."Number of Matches","Error - Number of Matches ${params."Number of Matches"} does not match actual found ${numfound}"
    }
}