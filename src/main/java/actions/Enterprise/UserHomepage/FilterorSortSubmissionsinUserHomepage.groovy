package actions.Enterprise.UserHomepage;

import actions.selenium.Click

class FilterorSortSubmissionsinUserHomepage{
    public void run(def params){
        if(params."Filter by"){
            Click.run(ID:"//button[.='${params."Filter by"}']")
        }
        if(params."Sort by"){
            Click.run(ID:"//*[@class='fractal-dropdown']")
            Click.run(ID:"//*[@class='fractal-dropdown']//ul/li[.='${params."Sort by"}']")
        }
        sleep(500)
    }
}