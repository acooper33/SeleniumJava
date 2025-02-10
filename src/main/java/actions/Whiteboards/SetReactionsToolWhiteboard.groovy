package actions.Whiteboards;

import actions.selenium.Click

class SetReactionsToolWhiteboard{
    public void run(def params){
        if(params."Select Tab"){
            Click.run(ID:"//DIV[contains(@class, 'f-reaction-tabs')]//DIV[contains(@class,'f-tabs-header')]//SPAN[contains(.,'${params."Select Tab"}')]")
        	sleep(500)
        }
        if(params."Object Placement Number"){
        	Click.run(ID:"//DIV[contains(@class,'f-reaction-tab-content')]/DIV[contains(@class,'f-reaction-option') and position()='${params."Object Placement Number"}']")
    	}
    }
}