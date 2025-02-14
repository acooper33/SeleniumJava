package actions.Rules;

import actions.selenium.*
    
class CloneRule{
    public void run(def params){
        Click.run(ID:"//*[@id='rule-action-btn']")
        Click.run(ID:"//*[@id='actions-list']/LI/A[@id='action-clone-rule']")
        //Click.run(ID:"//*[@id='action-clone-rule']")
        
        
        sleep(2000)
    }
}