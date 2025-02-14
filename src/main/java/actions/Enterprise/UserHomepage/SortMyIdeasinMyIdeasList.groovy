package actions.Enterprise.UserHomepage;

import actions.selenium.*

class SortMyIdeasinMyIdeasList{
    public void run(def params){
        int i = 0
        while(Exists.run(ID:"//*[contains(@class,'-header')]/*[text()='${params."Sort by Column"}']/../I[contains(@class,'${params."Sort"}')]")==0){
            if(i==5){assert false,"Error - Failed to sort the column"}
            else{i++}
            Click.run(ID:"//*[contains(@class,'-header')]/*[text()='${params."Sort by Column"}']")
            sleep(2000)
        }
    }
}