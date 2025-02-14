package actions.Enterprise.UserHomepage;

import actions.selenium.Click


class SetFeedFilterSortOnUserhome{
    public void run(def params){
        if(params."Filter"){
            Click.run(ID:"//DIV[contains(@class,'f-activity-items-container')]//BUTTON//SPAN[.='${params."Filter"}']")
            sleep(1000)
        }
        if(params."Open Filter By Activity"==true){
            Click.run(ID:"//DIV[contains(@class,'f-activity-items-container')]//BUTTON[contains(@class,'f-filter-btn')]") 
            sleep(1000)
        }
        if(params."Filter By Activity"){
            params."Filter By Activity" = params."Filter By Activity".substring(0,params."Filter By Activity".lastIndexOf("s")).toLowerCase()
            println("Filter By Activity: ${params."Filter By Activity"}")
            Click.run(ID:"//DIV[contains(@class,'popout-container')]//LABEL[@for='${params."Filter By Activity"}']")
            sleep(1000)
        }
        if(params."Clear Filters"){
            Click.run(ID:"//DIV[contains(@class,'popout-container')]//DIV[contains(@class,'f-activity-filters-footer')]//SPAN[starts-with(.,'Clear Filters')]")
        }
        if(params."Action"){
            Click.run(ID:"//DIV[contains(@class,'popout-container')]//DIV[contains(@class,'f-activity-filters-footer')]//SPAN[starts-with(.,'${params."Action"}')]")
        }
        
    }
}