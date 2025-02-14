package actions.SetupMail;

import actions.common.SetupCommon
import actions.selenium.SetCheckBox
import actions.selenium.Click

class SetWebstormSetupMailIdeaComments{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Mail",Section:"Idea Comments")
        SetCheckBox.run(ID:"//INPUT[@id='mail_idea_comments_checkbox']", Check:params."Enable idea email reply")
        if(params.Action=="Save Changes"){
            Click.run(ID:"//*[@id='mail_idea_comments_save_button']")
        }
    }
}