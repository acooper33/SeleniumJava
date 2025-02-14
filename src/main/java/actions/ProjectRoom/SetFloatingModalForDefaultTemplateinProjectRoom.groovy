package actions.ProjectRoom;

import actions.POMHelperAndLocators.FormElements.SetReactMultiChoiceOneAnswer
import actions.POMHelperAndLocators.FormElements.SetReactLongTextField
import actions.selenium.*
import screens.common.ModalButtonLocators
import screens.Userhome.ProjectRoom.GateActionItemLocators

class SetFloatingModalForDefaultTemplateinProjectRoom{
    public void run(def params){
       
        GateActionItemLocators.run(params)
        if(params."Click on Floating Button"){
            if(params."Click on Floating Button"==true){
                Click.run("ID Type":"By", By:GateActionItemLocators.popoutReviewButton)
            }
        }
        if(params."Expand or Collapse"){
            if(params."Expand or Collapse"=="Expand"){
                Click.run("ID Type":"By", By:GateActionItemLocators.expand)
            } else {
                Click.run("ID Type":"By", By:GateActionItemLocators.collapse)
            }
        }
        if(params."How aligned is this to our core mission and strategy?"){
            SetReactMultiChoiceOneAnswer.run("Field Name":"How aligned is this to our core mission and strategy?", "Field Value":params."How aligned is this to our core mission and strategy?", "Base XPath": "//*[contains(@class,'pr-gate-popout-item ReactModal__Content')]")
        }
        if(params."Do the project benefits outweigh the cost and risks introduced?"){
            SetReactMultiChoiceOneAnswer.run("Field Name":"Do the project benefits outweigh the cost and risks introduced?", "Field Value":params."Do the project benefits outweigh the cost and risks introduced?", "Base XPath": "//*[contains(@class,'pr-gate-popout-item ReactModal__Content')]")
        }
        if(params."How complete is the project investigation at this point?"){
            SetReactMultiChoiceOneAnswer.run("Field Name":"How complete is the project investigation at this point?", "Field Value":params."How complete is the project investigation at this point?", "Base XPath": "//*[contains(@class,'pr-gate-popout-item ReactModal__Content')]")
        }
        if(params."Overall, should this project be considered for the next planning session?"){
            SetReactMultiChoiceOneAnswer.run("Field Name":"Overall, should this project be considered for the next planning session?", "Field Value":params."Overall, should this project be considered for the next planning session?", "Base XPath": "//*[contains(@class,'pr-gate-popout-item ReactModal__Content')]")
        }
        if(params."Do you have any additional notes for the team?"){
            SetReactLongTextField.run("Field Name":"Do you have any additional notes for the team?", "Field Value":params."Do you have any additional notes for the team?","Base XPath": "//*[contains(@class,'pr-gate-popout-item ReactModal__Content')]")
        }
        if(params."Action"){
            ModalButtonLocators.run(params)
            if(params."Action"=="Complete Gate"){
                Click.run(ID:"//*[contains(@class,'pr-gate-popout-item ReactModal__Content')]//BUTTON[contains(@class,'f-gate-submit')]")
//                Click.run("ID Type":"By", "Base XPath": "//*[contains(@class,'pr-gate-popout-item ReactModal__Content')]", By:GateActionItemLocators.completeGate)
            } else {
                Click.run("ID Type":"By", By:ModalButtonLocators.closeOnModalButton)
            }
        }
    }
}