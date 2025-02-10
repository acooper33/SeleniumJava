package actions.PipelineStepsView;

import actions.selenium.*

class SetUpdateToolTypeOrder{
    public void run(def params){
        
        if(params."Ideas to Select"){
            if(params."Ideas to Select"=="All"){
                if(params."Check or Uncheck Ideas to Select".split(",")[x]=="CHECK"){
                    Click.run(ID:"//*[contains(@class,'f-table-header')]/*[@class='f-checkbox']/DIV[not(contains(@class,'f-checkbox-checked'))]//input")
                } else {
                    Click.run(ID:"//*[contains(@class,'f-table-header')]/*[@class='f-checkbox']/DIV[contains(@class,'f-checkbox-checked')]//input")
                }
            } else {
                params."Ideas to Select".split(",").eachWithIndex{ ideas, x ->
                if(params."Check or Uncheck Ideas to Select".split(",")[x]=="CHECK"){
                    Click.run(ID:"//*[text()='${ideas}']/../../..//*[@class='f-checkbox']/DIV[not(contains(@class,'f-checkbox-checked')) and contains(@class,'f-checkbox-wrapper')]//*[@class='f-checkbox-inner']")
                } else {
                    Click.run(ID:"//*[text()='${ideas}']/../../..//*[@class='f-checkbox']/DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]//*[@class='f-checkbox-inner']")}
                }
            }
        }
        if(params."Set order by Dropdown"){
            Click.run(ID:"//*[contains(@class,'f-reorder-dropdown')]/DIV")
            sleep(2000)
            Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'block')]/*[text()='${params."Set order by Dropdown"}']")
        }
        if(params."Action"){
            if(params."Action"=="Save Changes"){
                Click.run(ID:"//*[contains(@class,'submit-btn')]")
            } else {
                Click.run(ID:"//*[contains(@class,'close-button')]")
            }            
        }
    }
}
