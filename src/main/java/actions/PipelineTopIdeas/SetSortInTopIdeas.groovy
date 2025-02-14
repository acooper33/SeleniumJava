package actions.PipelineTopIdeas;

import actions.selenium.Click

class SetSortInTopIdeas{
    public void run(def params){
        Click.run(ID:"//DIV[contains(@class,'f-best-idea-sort')]")
        sleep(1000)
        if(params."Sort By"){
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI/SPAN[contains(.,'${params."Sort By"}')]")
            sleep(1000)
        }
    }
}