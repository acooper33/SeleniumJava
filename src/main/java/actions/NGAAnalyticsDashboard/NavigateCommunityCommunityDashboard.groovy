package actions.NGAAnalyticsDashboard;

import actions.selenium.Click

class NavigateCommunityCommunityDashboard{
    public void run(def params){
		Click.run(ID:"//DIV[@class='f-community-admin-nav-community-dropdown']//DIV[contains(@class, 'fractal-dropdown')]/DIV[contains(@class,'f-dropdown-btn')]")
        sleep(1000)
        if (params.'Select Community'){
            Click.run(ID:"//DIV[@class='f-community-admin-nav-community-dropdown']//DIV[contains(@class, 'fractal-dropdown')]/DIV[contains(@class,'f-dropdown-btn')]/../UL[contains(@class,'f-dropdown-options')]/LI/SPAN[contains(.,'${params."Select Community"}')]")
            sleep(3000)
        }
    }
}