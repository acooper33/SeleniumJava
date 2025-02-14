package actions.ProjectRoom;

import actions.selenium.*
import actions.POMHelperAndLocators.FormElements.SetReactMultiChoiceOneAnswer
import actions.POMHelperAndLocators.FormElements.SetReactLongTextField

class SetGateApprovalActionItem{
    public void run(def params){
        
        if(params."How aligned is this to our core mission and strategy?"){
            SetReactMultiChoiceOneAnswer.run("Field Name":"How aligned is this to our core mission and strategy?", "Field Value":params."How aligned is this to our core mission and strategy?")
        }
        if(params."Do the project benefits outweigh the cost and risks introduced?"){
            SetReactMultiChoiceOneAnswer.run("Field Name":"Do the project benefits outweigh the cost and risks introduced?", "Field Value":params."Do the project benefits outweigh the cost and risks introduced?")
        }
        if(params."How complete is the project investigation at this point?"){
            SetReactMultiChoiceOneAnswer.run("Field Name":"How complete is the project investigation at this point?", "Field Value":params."How complete is the project investigation at this point?")
        }
        if(params."Overall, should this project be considered for the next planning session?"){
            SetReactMultiChoiceOneAnswer.run("Field Name":"Overall, should this project be considered for the next planning session?", "Field Value":params."Overall, should this project be considered for the next planning session?")
        }
        if(params."Do you have any additional notes for the team?"){
            SetReactLongTextField.run("Field Name":"Do you have any additional notes for the team?", "Field Value":params."Do you have any additional notes for the team?")
        }
        Click.run(ID:"//button[normalize-space()='Complete Gate']")
    }
}