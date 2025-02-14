package actions.Rules;

import actions.selenium.*

class AccessExistingRule{
    public void run(def params){
        
        Click.run(ID:"//*[@id='rule-grid']//TD/A[text()='${params."Rule Name"}']")
        
    }
}