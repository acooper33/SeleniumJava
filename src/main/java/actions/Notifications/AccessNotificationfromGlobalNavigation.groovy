package actions.Notifications;

import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.GetText
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import actions.selenium.Browser

class AccessNotificationfromGlobalNavigation{
    public void run(def params){

        if(Exists.run(ID:"//*[@class='global-nav-btn open']")==0){
            Click.run(ID:"//*[@class='fa fa-bell']") 
        }
        if(params."Notification Message"){
            sleep(4000)
            Click.run(ID:"//div[@class='n-desc' and contains(.,'${params."Notification Message"}')]")
        }
        if(params."Mark All as Read"==true){
            Click.run(ID:"//*[@class='dropdown-footer']/A[text()='Mark All as Read']")
        }
    }
}
