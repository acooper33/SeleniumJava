package actions.Whiteboards;

import actions.selenium.Click

class GoBackFromWhiteboard{
    public void run(def params){
        Click.run(ID:"//BUTTON[@data-tooltip-content='Back to Whiteboards']")
        sleep(2000)
    }
}