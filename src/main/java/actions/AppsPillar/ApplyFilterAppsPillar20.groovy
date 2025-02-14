package actions.AppsPillar;

import actions.selenium.Click

class ApplyFilterAppsPillar20{
    public void run(def params){
        if(params."Filter Option"){Click.run(ID:"//*[contains(@class,'filter-item') and text()='${params."Filter Option"}']")}
        sleep(2000)
    }
}