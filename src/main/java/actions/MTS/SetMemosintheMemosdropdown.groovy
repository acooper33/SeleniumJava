package actions.MTS;

import actions.selenium.Click

class SetMemosintheMemosdropdown{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-top-left-community-hp']//*[@data-test='f-test-dropdown']/I")
        if(params."Memo"){
            Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]//*[text()='${params."Memo"}']/..")
        }
    }
}