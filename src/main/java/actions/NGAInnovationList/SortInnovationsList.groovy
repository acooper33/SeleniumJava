package actions.NGAInnovationList;

import actions.selenium.*
    
class SortInnovationsList{
    public void run(def params){
        int i = 0
        while(Exists.run(ID:"//TR[1]/TH/A[text()='${params."Column Name"}']/parent::TH[contains(@class,'${params."Sort"}')]")==0){
            if(i==5){assert false,"Error - Failed to sort the column"}
            else{i++}
            Click.run(ID:"//TR[1]/TH/A[text()='${params."Column Name"}']")
            sleep(2000)
        }
    }
}