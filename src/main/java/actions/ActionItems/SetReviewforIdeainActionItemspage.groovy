package actions.ActionItems;

import actions.selenium.Click
import actions.selenium.Exists

class SetReviewforIdeainActionItemspage{
    public void run(def params){
        if(Exists.run(ID:"//*[@class='tour-tip']//*[text()='Start Quick Tour']",Timeout:4)>0){
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Start Quick Tour']")
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
            sleep(500)
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
            sleep(500)
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
            sleep(500)
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Finish']")
        }
        Click.run(ID:"//*[@id='idea-prescreen-btn']")
        sleep(2000)
    }
}