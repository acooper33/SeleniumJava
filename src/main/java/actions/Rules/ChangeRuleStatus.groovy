package actions.Rules;

import actions.selenium.*

class ChangeRuleStatus{
    public void run(def params){
        Click.run(ID:"//*[@id='rule-action-btn']")
        //Click.run(ID:"//*[@id='list-change-status']")
        //MouseOver.run(ID:"//*[@id='list-change-status']")
        if(params."Change Status"=="Active"){Click.run(ID:"//*[@id='action-status-active']","Type of Click":"Javascript")}
        else{Click.run(ID:"//*[@id='action-status-inactive']","Type of Click":"Javascript")}
        sleep(1000)
    }
}