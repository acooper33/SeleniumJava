package actions.PipelineStepsView;

import actions.selenium.SetText
import actions.selenium.Click
import actions.common.SetupCommon
import actions.selenium.SelectItem


class FilterPipelineStepsView{
    public void run(def params){
        
        if(params."Open Filter Options"){Click.run(ID:"//*[@id='status-filters']")}
        
        if(params."Active/Inactive Status"=="Active"){
            if(params."Status Option"){
                params."Status Option".split(",").each{ value ->
                    Click.run(ID:"//*[@id='status-filters-popup']//DIV[@id='active-status-container']//span[@class='status-item-name' and text()='${value}']")
                    sleep(3000)
                }
            }
        }
        if(params."Active/Inactive Status"=="Inactive"){
            if(params."Status Option"){
                params."Status Option".split(",").each{ value ->
                    Click.run(ID:"//*[@id='status-filters-popup']//DIV[@id='inactive-status-container']//span[@class='status-item-name' and text()='${value}']")
                    sleep(3000)
                }
            }
        }
        
        if(params."Category Option"){
            params."Category Option".split(",").each{ value ->
                Click.run(ID:"//*[@id='status-filters-popup']//DIV[@id='categories-container']//span[@class='status-item-name' and text()='${value}']")
                sleep(3000)
            }
        }
       
        if(params."Reset Filters"){Click.run(ID:"//*[@id='reset-filters']")}
        if(params."Close Filter Options"){Click.run(ID:"//*[@id='status-filters']")}
        sleep(3000)
   }
}