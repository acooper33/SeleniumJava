package actions.ViewIdea30;

import actions.selenium.Exists
import actions.selenium.Click
import screens.ViewIdea3.StageGateActionItemInViewIdea3

class SetandVerifyStageandGateActionIteminViewIdea3{
    public void run(def params){
        
        StageGateActionItemInViewIdea3.run(params)
        if(params."Due Date"){
            assert Exists.run("ID Type":"By",By:StageGateActionItemInViewIdea3.dueDate) == 1,"Error - Incorrect Due Date"
        }
        if(params."Click on button"==true){
            Click.run("ID Type":"By",By:StageGateActionItemInViewIdea3.completeActionItemButton)
        }
        if(params."Completed Message"){
            assert Exists.run("ID Type":"By",By:StageGateActionItemInViewIdea3.completedMessage) == 1,"Error - Completed Message"
        }
        if(params."Click on link on Completed Tab"==true){
            Click.run("ID Type":"By",By:StageGateActionItemInViewIdea3.linkOnCompletedTab)
        }
    }
}