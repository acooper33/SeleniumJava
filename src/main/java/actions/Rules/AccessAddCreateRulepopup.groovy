package actions.Rules;

import actions.selenium.*

class AccessAddCreateRulepopup{
    public void run(def params){
        Click.run(ID:"//*[@id='rule-action-btn']")
        Click.run(ID:"//*[@id='actions-list']/LI/A[@id='action-add-rule']")
        //Click.run(ID:"//*[@id='actions-list']/LI[1]")
        sleep(3000)
    }
}