package actions.selenium;

import actions.selenium.Click

class SetReactDropdown{
    public static void run(def params){
        if(params.Option){
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options') and contains(@style, 'display: block')]/LI[starts-with(.,'${params."Option"}')]")
        }
    }
}