package actions.ActionItems;

import actions.selenium.Click
import actions.selenium.Exists

class SetPairwiseforIdeainActionItemspage{
    public void run(def params){
        if(params."Select Idea Name or Neither"){
            if(params."Select Idea Name or Neither"=="Neither"){Click.run(ID:"//*[@id='select_neither']")}
            else{
                if(Exists.run(ID:"(//*[@id='idea-title'])[1][contains(.,'${params."Select Idea Name or Neither"}')]")>0){Click.run(ID:"//*[@id='select_1']")}
                else if(Exists.run(ID:"(//*[@id='idea-title'])[2][contains(.,'${params."Select Idea Name or Neither"}')]")>0){Click.run(ID:"//*[@id='select_2']")}
                else{assert false,"Error - Idea '${params."Select Idea Name or Neither"}' not found"}
            }
            sleep(2000)
        }
        if(params.Action){
            if(params.Action=="Start Over"){Click.run(ID:"//*[contains(@id,'start_over')]")}
            else if(params.Action=="Save and Exit"){Click.run(ID:"//*[@id='save']")}
            else if(params.Action=="Save and Exit and Complete"){
                Click.run(ID:"//*[@id='save']")
                sleep(2000)
                Click.run(ID:"//*[@id='complete']")
            }
            else if(params.Action=='Complete'){Click.run(ID:"//*[@id='complete']")}
            sleep(2000)
        }
    }
}