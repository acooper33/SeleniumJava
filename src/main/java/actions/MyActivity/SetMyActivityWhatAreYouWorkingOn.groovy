package actions.MyActivity;

import actions.common.MyActivityCommon
import actions.selenium.*

class SetMyActivityWhatAreYouWorkingOn{
    public void run(def params){
        MyActivityCommon.NavigateTab(Tab:"Activity Feed")
        
        SetText.run(ID:"//*[@id='post_twork_textbox_inner_div']",Text:params."What Are You Working On")
        Click.run(ID:"//*[@id='post_twork_submit_btn']")
        sleep(1000)
    }
}