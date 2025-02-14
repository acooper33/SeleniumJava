package actions.Enterprise.UserHomepage;

import actions.selenium.Click

class SortProjectsInUserHomepage{
    public void run(def params){
        println("params sort by ${params."Sort By"}")
        if(params."Sort By"){
            Click.run(ID:"//*[@class='fractal-widget-projects']//div[contains(@class,'f-dropdown-btn')]")
			sleep(3000)
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI[span='${params."Sort By"}']")
            sleep(5000)
        }
    }
}