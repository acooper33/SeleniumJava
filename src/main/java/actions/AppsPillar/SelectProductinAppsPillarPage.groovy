package actions.AppsPillar;

import actions.selenium.Click
import actions.selenium.Exists

class SelectProductinAppsPillarPage{
    public void run(def params){
        
        if(Exists.run(ID:"//*[@class='f-filter-item' and text()='${params."Product"}']")>0)
        {
        	Click.run(ID:"//*[@class='f-filter-item' and text()='${params."Product"}']")
        }
        else if(Exists.run(ID:"//*[contains(@class,'f-app-filter-tabs')]//BUTTON/SPAN[contains(.,'${params."Product"}')]")>0)
        {
            Click.run(ID:"//*[contains(@class,'f-app-filter-tabs')]//BUTTON/SPAN[contains(.,'${params."Product"}')]")
        }
        
    }
}