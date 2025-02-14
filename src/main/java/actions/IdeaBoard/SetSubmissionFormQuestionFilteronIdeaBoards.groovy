package actions.IdeaBoard;

import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.Exists

class SetSubmissionFormQuestionFilteronIdeaBoards{
    public void run(def params){

        if(Exists.run(ID:"//*[@class='tab-header-title' and text()='${params."Question"}']/../..//*[contains(@class,'fa fa-plus-square-o')]")==1){
            Click.run(ID:"//*[@class='tab-header-title' and text()='${params."Question"}']/../..//*[contains(@class,'fa fa-plus-square-o')]")}

        if(params."Answers"){
            params."Answers".split(",").eachWithIndex{ answer, x ->
                SetCheckBox.run(ID:"//*[@class='tab-header-title' and text()='${params."Question"}']/../../..//SPAN[contains(.,'${answer}')]/../../INPUT",Check:params."Answers Check".split(",")[x].toBoolean())
            }
        }
    }
}