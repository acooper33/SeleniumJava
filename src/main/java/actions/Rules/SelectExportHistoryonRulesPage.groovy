package actions.Rules;

import actions.selenium.*

class SelectExportHistoryonRulesPage{
    public void run(def params){
        Click.run(ID:"//*[@id='rule-action-btn']")
        sleep(1000)
        Click.run(ID:"//*[@id='actions-list']//A[@id='action-export-history']", "Type of Click":"Javascript")
        sleep(1000)
    }
}