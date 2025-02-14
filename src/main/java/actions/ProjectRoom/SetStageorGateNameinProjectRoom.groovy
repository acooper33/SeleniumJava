package actions.ProjectRoom;

import actions.selenium.*
    
class SetStageorGateNameinProjectRoom{
    public void run(def params){
        
        SetText.run(ID:"//*[@id='f-rooms-folder-name']",Text:params."Stage or Gate Name", "Type of Clear":"Cut")
        if(params.Action){
             if(params.Action=='Cancel'){
                 Click.run(ID:"//*[@data-test='modal-footer-cancel']")
             } else {
                 Click.run(ID:"//*[@id='f-modal-submit' and .='${params.Action}']")  
             }
        }
    }
}