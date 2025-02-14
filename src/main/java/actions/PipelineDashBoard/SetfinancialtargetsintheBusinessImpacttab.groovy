package actions.PipelineDashBoard;

import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.SetText

class SetfinancialtargetsintheBusinessImpacttab{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-chart-title-right']/DIV")
        params."Year".split(",").eachWithIndex{ year, x ->  
            if (Exists.run(ID:"//*[@class='f-year-and-field-item-container']/*[@class='year' and text()='${year}']") == 0) {
                Click.run(ID:"//*[@id='add-year-btn']")}
            if (params."Targets"){
                def target = params."Targets".split(",")
                SetText.run(ID:"//*[contains(@id,'${year}-target-input')]",Text:target[x])
            }
        }
        if(params."Action"){
            if (params."Action"=="Save Targets") {
                Click.run(ID:"//*[@id='save-btn']")
            } else {Click.run(ID:"//*[@id='cancel-btn']")}
        }
    }
}

