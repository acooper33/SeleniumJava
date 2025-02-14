package actions.PipelineTopIdeas;

import actions.selenium.Click

class SetRightClickMenuInTopIdeas{
    public void run(def params){
        if(params."Select Option"){
            Click.run(ID:"//UL[@class='f-best-idea-right-click-menu']/LI[contains(.,'${params."Select Option"}')]")
        }
    }
}