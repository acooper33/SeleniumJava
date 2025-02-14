package actions.Search;

import actions.selenium.Click
import actions.selenium.SetText
    
class QuickOrAdvanceSearchInGlobalNav{
    public void run(def params){
        Click.run(ID:"//*[@id='global-search-input']")
        if (params."Search Input"){
            //Click.run(ID:"//*[@id='global-search-input']")
            SetText.run(ID:"//*[@id='global-search-input']",Text:params."Search Input")
            sleep(2000)
        }
        if(params."Tab (optional)"){
            Click.run(ID:"//*[contains(@class,'f-result-container')]//DIV[contains(@class,'f-tabs-header')]/DIV[contains(@class,'f-tab')]//SPAN[contains(.,'${params."Tab (optional)"}')]")
        }
         if(params."Remove WebStorm tag"==true){
            Click.run(ID:"//*[@CLASS='f-nav-search-tag']/I")
        }
    }
}