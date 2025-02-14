package actions.PipelineTopIdeas;

import actions.selenium.Click

class SelectListInTopIdeas{
    public void run(def params){
        if(params."List Name"){
            Click.run(ID:"//DIV[@class='f-list-container']/UL/LI[contains(@class,'f-list-item')]/SPAN[@class='f-list-item-name' and contains(text(),'${params."params."List Name""}')]")
    	}
	}
}
    