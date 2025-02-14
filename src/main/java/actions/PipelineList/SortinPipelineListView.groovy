package actions.PipelineList;

import actions.selenium.MouseOver
import actions.selenium.Click

class SortinPipelineListView{
    public void run(def params){
        if(params."Sort by Column"){
            def ID = "//table[@class='header_table']/th[contains(@class,'sortable')]/A[text()='${params."Sort by Column"}']"
            MouseOver.run(ID:ID)
            Click.run(ID:ID+"/../DIV[@class='header-filter']")
            //Click.run(ID:"table[@class='header_table']/th[contains(@class,'sortable')]/A[text()='${params."Sort by Column"}']/../DIV[@class='header-filter']")
            if(params.Sort=="Asc"){
                Click.run(ID:ID+"/..//form/*[@id='grid-sort-wrapper']/DIV[@class='grid-sort-btn' and @data-sort='ascending']")
            }
            else{Click.run(ID:ID+"/..//form/*[@id='grid-sort-wrapper']/DIV[@class='grid-sort-btn' and @data-sort='ascending']")}
        }
        sleep(2000)
        
    }
}