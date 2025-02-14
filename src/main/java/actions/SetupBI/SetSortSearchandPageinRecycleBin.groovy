package actions.SetupBI;

import actions.selenium.*
import actions.common.SetupCommon

class SetSortSearchandPageinRecycleBin{
    public void run(def params){
        
        if(params."Navigate to Recycle Bin Tab"==true){
            SetupCommon.NavigateTab(Tab:"BI Only",Section:"Recycle Bin")
        }
        if(params."Sort"){
           Click.run(ID:"//*[@id='f-table-filter-dropdown']//*[contains(@data-test,'f-test-dropdown')]")
           Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'block')]//*[text()='${params."Sort"}']")
       }
        SetText.run(ID:"//*[contains(@class,'fractal-input fa-search')]/INPUT",Text:params."Search Text")
        if(params."Previous or Next"){
            if(params."Previous or Next"=="Previous"){
                Click.run(ID:"//*[contains(@class,'f-table-pagination')]/BUTTON[1]")
            } else {
                Click.run(ID:"//*[contains(@class,'f-table-pagination')]/BUTTON[2]") 
            }
            
        }
    }
}