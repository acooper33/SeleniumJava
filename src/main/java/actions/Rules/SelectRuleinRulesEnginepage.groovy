package actions.Rules;

import actions.selenium.*

class SelectRuleinRulesEnginepage{
    public void run(def params){
        //Map all values that will be used for access of that instance
        def set = [:]
        //set.ID= "//*[@id='content-inside']/*[text()='${params."Idea Name"}']" 
        set.ID = "//*[@id='rule-grid']//TD/A[text()='${params."Rule Name"}']/../..//TD[2]/INPUT"       
        set.IDChildren = []
        if(params."Event"){set.IDChildren << "./../../TD[text()='${params."Event"}']"}
        if(params."Instance"){set."Instance"=params."Instance".toInteger()}
        
        Click.run(set) 
    }
}