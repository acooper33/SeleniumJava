package actions.general;

import actions.selenium.Click

class NavigateCommunityAdminBar{
    public void run(def params){
       	Click.run(ID:"//DIV[@class='f-community-admin-nav-dropdown']")        
        if(params."Area to Navigate to"){Click.run(ID:"//DIV[@class='f-community-admin-nav-dropdown']//UL[contains(@class,'f-dropdown-options')]/LI[contains(.,'${params."Area to Navigate to"}')]")}
    }
}