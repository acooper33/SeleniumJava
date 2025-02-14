package actions.IdeaBoard;

import actions.selenium.Click

class FilterIdeainIdeaBoardpage{
    public void run(def params){
        Click.run(ID:"//*[@id='filter-toggle']")
        params."Categories".each{
            Click.run(ID:"//*[@id='drop-categories-wrapper']//*[text()='${it}']")
        }
        params."Status".each{
            Click.run(ID:"//*[@id='drop-status-wrapper']//*[text()='${it}']")
        }
        params."Tags".each{
            sleep(1000)
            Click.run(ID:"//*[@id='drop-tags-wrapper']//*[contains(text(),'${it}')]")
        }
        
        if(params.Action){
            if(params.Action=="Apply Filters"){Click.run(ID:"//*[@id='apply_filters_btn']")}
            else{Click.run(ID:"//*[@id='reset_filters_btn']")}
        }
        sleep(2000)
    }
}