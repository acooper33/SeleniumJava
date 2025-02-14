package actions.PipelineList;

import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.MouseOver
import actions.selenium.utils.Elements
import actions.selenium.Browser

class FilterIdeasinPipelineListView{
    public void run(def params){
        if(params."Filter by Column"){
            //Click.run(ID:"//TH/A[text()='${params."Filter by Column"}']/..//*[@class='fa fa-filter']","Type of Click":"Javascript")
            def ID = "//TH/A[text()='${params."Filter by Column"}']"
            def elem = Elements.findAll(ID:ID, Browser.Driver)
            println("Size: ${elem.size()}")
            
            //def ID = "//table[@class='header_table']/th[contains(@class,'sortable')]/A[text()='${params."Filter by Column"}']"
            //MouseOver.run(ID:ID)
            
            Click.run(ID:ID+"/..//*[@class='fa fa-filter']", "Type of Click":"Javascript")
            if(params."Enter Keyword or Search Value"){
                SetText.run(ID:ID+"/..//*[@id='grid-filter-wrapper']//INPUT[@id='grid-filter-search']", Text:params."Enter Keyword or Search Value")
            }
            if(params."Select All"){Click.run(ID:ID+"/..//*[@id='grid-filter-wrapper']//*[@id='grid-filter-all-btn']")}
            if(params."Select None"){Click.run(ID:ID+"/..//*[@id='grid-filter-wrapper']//*[@id='grid-filter-all-btn']")}
            if(params."Checkbox Options"){
                params."Checkbox Options".split(",").eachWithIndex{x, name ->
                    if(params."Option Check of Uncheck".split(",")[x]=="Check"){SetCheckBox.run(ID:ID+"/..//*[@id='grid-filter-wrapper']//*[@class='selectable-filter-label']/INPUT[@value='${name}']",Check:true)}
                    else{SetCheckBox.run(ID:ID+"/..//*[@id='grid-filter-wrapper']//*[@class='selectable-filter-label']/INPUT[@value='${name}']",Check:false)}
                	
                }
            }
            if(params.Action=="Apply"){Click.run(ID:ID+"/..//*[@class='filter-btn-wrapper']/*[@id='filter-btn-ok']")}
            else{Click.run(ID:ID+"/..//*[@class='filter-btn-wrapper']/*[@id='filter-btn-cancel']")}
        }
        
        /*
        
        if((params."Stage Select All")||(params."Stage Select None")||(params."Stage Name")){
            Click.run(ID:"//*[@class='stage sortable renderable']/DIV[@class='header-filter']/I", "Type of Click":"Javascript")
            if(params."Stage Select All"==TRUE){Click.run(ID:"//*[@id='grid-filter-all-btn']")}
            if(params."Stage Select None"==TRUE){Click.run(ID:"//*[@id='grid-filter-clear-btn']")}
            if(params."Stage Name"){SetCheckBox.run(ID:"//*[@class='selectable-filter-label']/INPUT[@value='${params."Stage Name"}']")}    
            if(params."Stage Filter Action"=="Apply"){Click.run(ID:"//*[@id='filter-btn-ok']")}
            else{Click.run(ID:"//*[@id='filter-btn-cancel']")}
    	}
		*/
    }        
}
