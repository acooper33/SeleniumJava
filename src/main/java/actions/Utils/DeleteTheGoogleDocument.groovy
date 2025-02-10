package actions.Utils;

import actions.selenium.Click
import actions.selenium.MouseOver

class DeleteTheGoogleDocument{
    public void run(def params){
        
        if(params."Google document title"){
            Click.run(ID:"//*[contains(@class,'docs-homescreen-grid-item-title') and text()='${params."Google document title"}']/..//*[@class='docs-homescreen-item-overflow']")
            Click.run(ID:"//*[contains(@class,'docsshared-menu-bubble') and contains(@style,'isibility: visible')]//*[contains(@role,'menuitem')]//*[text()='Remove']")
        	sleep(2000)
        	Click.run(ID:"//*[contains(@name,'moveToTrash')]")
        	sleep(3000)
        } else {
            MouseOver.run(ID:"//*[text()='${params."OneDrive document title"}']/../../../../../..")
            Click.run(ID:"//*[text()='${params."OneDrive document title"}']/../../../../../../..//i[2]/..","Type of Click": "Javascript")
            sleep(2000)
            Click.run(ID:"//*[contains(@class,'ms-OverflowSet ms-CommandBar-primaryCommand primarySet')]//*[text()='Delete']/../..")
            sleep(2000)
            Click.run(ID:"//*[contains(@data-automationid,'confirmbutton')]")
        }
    }
}