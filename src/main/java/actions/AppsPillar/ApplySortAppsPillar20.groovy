package actions.AppsPillar;

import actions.selenium.Click

class ApplySortAppsPillar20{
    public void run(def params){
        if(params."Sort Option"){Click.run(ID:"//UL[@class='sort-tabs']/LI[text()='${params."Sort Option"}']")}
        sleep(2000)
  	}
}