package actions.PipelineDashBoard;

import actions.selenium.Click
import java.lang.*

class FilterIdeainSubmissionTableonBusinessImpacttab{
    public void run(def params){
        Click.run(ID:"//*[@id='pipeline-dashboard-filters-button']")
        if(params."Category"){
            params."Category".each{Click.run(ID:"//DIV[@class='filter-category']//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id, 'filter-category')]")}
        }
         if(params."Status"){
            params."Status".each{Click.run(ID:"//DIV[@class='filter-status']//*[contains(@class,'filter-inline-input')]//label[@class='filter-label']/*[text()='${it}']/../..//input[starts-with(@id, 'filter-status')]")}
        }
        Click.run(ID:"//*[@id='active-pipeline-title']")
    }
}