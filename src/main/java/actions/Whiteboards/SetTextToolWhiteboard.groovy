package actions.Whiteboards;

import actions.selenium.Click

class SetTextToolWhiteboard{
    public void run(def params){
        if(params."Select Option"){
            Click.run(ID:"//DIV[contains(@class,'f-text-options')]/span[contains(.,'${params."Select Option"}')]")
            sleep(1000)
        }
    }
}