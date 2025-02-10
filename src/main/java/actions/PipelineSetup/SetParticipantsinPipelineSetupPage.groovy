package actions.PipelineSetup;

import actions.common.AppsCommon
import actions.selenium.Click
import actions.PipelineSetup.SetLeftSideTabInPipelineSetup

class SetParticipantsinPipelineSetupPage{
    public void run(def params){
        
        SetLeftSideTabInPipelineSetup.run(Tab:"Participants")
        AppsCommon.UserPickerAddRemove("Field Name":"General Access",User:params."General Access","Add or Remove":params."General Access Add or Remove")
        AppsCommon.UserPickerAddRemove("Field Name":"Early Access",User:params."Early Access","Add or Remove":params."Early Access Add or Remove")
        AppsCommon.ImportUserGroup("Import User Group As":params."Import Group as","Import Group File":params."Import File","Add or Remove User Group":params."Add or Remove Group","Import User Group Action":params."Import Group Action","Check Complete Modal Action":params."Check Modal Action","Group Name":params."Group Name")
        Click.run(ID:"//*[@id='save-participants-btn']")
    }
}





