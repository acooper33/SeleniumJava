package actions.Rules;

import actions.selenium.*
    
class DeleteRule{
    public void run(def params){
        Click.run(ID:"//*[@id='rule-action-btn']")
        Click.run(ID:"//*[@id='actions-list']/LI/A[@id='action-delete-rule']")
        //Click.run(ID:"//*[@id='action-delete-rule']")
        sleep(2000)
    }
}