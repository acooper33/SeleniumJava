package actions.SetupIdeas;

import actions.selenium.SetCheckBox
import actions.common.SetupCommon
import actions.selenium.Click

class SetEnterpriseSetupforIdeasMemotab{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Memo")
        SetCheckBox.run(ID:"//*[@id='CB_MEMO_BROWSER_EXTENSION']",Check:params."Browser Extension promotional tab")
        SetCheckBox.run(ID:"//*[@id='CB_MEMO_AI_WRITING_TOOL']", Check:params."AI Writing")
        SetCheckBox.run(ID:"//*[@id='CB_GOOGLE_DOCS_MEMO_INTEGRATION']", Check:params."Google Docs")
        SetCheckBox.run(ID:"//*[@id='CB_ONE_DRIVE_MEMO_INTEGRATION']", Check:params."One Drive")
        Click.run(ID:"//*[@id='ideas_memo_options_save_button']")
    }
}