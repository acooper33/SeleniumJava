package actions.Enterprise.UserHomepage;

import actions.selenium.Exists

class VerifyOneOnboardingPanelMeterItem{
    public void run(def params){
        
        if(params."Completed Total"){
            assert Exists.run(ID:"//*[@class='f-checklist-title-wrapper']/SPAN[@class='f-checklist-subtitle' and contains(.,'${params."Completed Total"}')]")==1, "Total Nunber of Completed is Incorrect"
        }
        
        if(params."Completed"==true){
            assert Exists.run(ID:"//*[@class='f-checklist-wrapper']/UL[@class='f-checklist']/LI/A/SPAN[.='${params."Item Name"}' and contains(@class,'strikethrough')]")==1, "Error - ${params."Item Name"} is Incomplete"
        }
        else{
            assert Exists.run(ID:"//*[@class='f-checklist-wrapper']/UL[@class='f-checklist']/LI/A/SPAN[.='${params."Item Name"}' and not(contains(@class,'strikethrough'))]")==1, "Error - ${params."Item Name"} is Complete"

        }
    }
}