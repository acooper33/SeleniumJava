package actions.ProjectRoom;

import actions.selenium.Click
import actions.common.AppsCommon

class EditorRemoveTeamMemberinProjectRoom{
    public void run(def params){
        
        if(params."Member(s)"){AppsCommon.MemoUserPickerRemoveUpdatePermissions(User:params."Member(s)","Option":params."Option(s)")}
        if(params."Remove Action"){
            if(params."Remove Action".contains("Remove")){
                       Click.run(ID:"//*[@id='f-modal-submit']")
                   } else {
                      Click.run(ID:"//*[@data-test='modal-footer-cancel']") 
                   }
            }
        }
}
