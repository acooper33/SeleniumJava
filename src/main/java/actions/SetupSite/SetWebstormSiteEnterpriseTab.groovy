package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.SetCheckBox
import actions.selenium.Click

class SetWebstormSiteEnterpriseTab{
    public void run(def params){

        SetupCommon.NavigateTab(Tab:"Site",Section:"Enterprise")
        SetCheckBox.run(ID:"//*[@id='CB_ENTERPRISE_WS']",Check:params."Enterprise")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_GLOBAL_NAV_TOGGLE']",Check:params."Allow users to search other Pipelines")
        SetCheckBox.run(ID:"//*[@id='CB_RESTRICT_GLOBAL_NAV_SEARCH_TO_WS']",Check:params."Restrict Global Navigation user search results to this Initiative's Access Group")
        SetCheckBox.run(ID:"//*[@id='CB_ENT_PROFILE_WS']",Check:params."Enterprise Profiles")
        SetCheckBox.run(ID:"//*[@id='CB_EXCLUDE_FROM_ENT_LIST_WS']",Check:params."Exclude From Enterprise Lists")
        //SetCheckBox.run(ID:"//*[@id='CB_ENABLE_ENTERPRISE_NAV_WS']",Check:params."Enterprise Home in Initiative Navigation")
        SetCheckBox.run(ID:"//*[@id='CB_DISPLAY_EVAL_USER_HOME']",Check:params."Display link to Evaluation in User Home on Initiative card")
        Click.run(ID:"//*[@id='ent_standard_save_button']")
    }
}