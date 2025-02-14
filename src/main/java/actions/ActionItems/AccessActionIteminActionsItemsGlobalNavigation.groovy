package actions.ActionItems;

import actions.selenium.Click
import actions.selenium.Exists


class AccessActionIteminActionsItemsGlobalNavigation{
    public void run(def params){
        if(Exists.run(ID:"//*[@id='f-global-nav']")>0){
           Click.run(ID:"//*[contains(@class,'fa-clock')]") 
           Click.run(ID:"//*[@id='action-items']//*[starts-with(text(),'${params."Action Item"}')]")
        }else if (Exists.run(ID:"//*[@id='global-nav']")>0){
            Click.run(ID:"//*[@id='action-items']//*[@class='global-nav-section']")
            sleep(2000)
        	//Click.run(ID:"//*[@id='action-items']//*[text()='${params."Action Item"}']")
            Click.run(ID:"//*[@id='action-items']//*[starts-with(text(),'${params."Action Item"}')]")
        }
        sleep(2000)
    }
}