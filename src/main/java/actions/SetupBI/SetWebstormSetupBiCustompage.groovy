package actions.SetupBI;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox

class SetWebstormSetupBiCustompage{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"BI",Section:"Custom")
        
        SetCheckBox.run(ID:"//*[@id='OPT_TRANSLATE']",Check:params."Enable Text Translation")
        SetCheckBox.run(ID:"//*[@id='OPT_VIDEO_WS']",Check:params."Enable Video Upload/Embedding")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_EDIT_HISTORY']",Check:params."note Edit History")
        SetCheckBox.run(ID:"//*[@id='CB_WS_DISABLE_MEMBER_QUERY']",Check:params."Disable member query from Ideas search")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_IDEA_SUBMITTER_PROFILE_IMAGE']",Check:params."Show Submitter Profile Image Above Voting")
        SetCheckBox.run(ID:"//*[@id='CB_CUSTOM_WIDGET_DROPDOWN']",Check:params."Enable Custom Widget Dropdown")
        SetCheckBox.run(ID:"//*[@id='CB_SHOW_SEPERATE_IDEA_PRO_DE_SCORE']",Check:params."Show Seperate note Promote/Demote Score")
        SetCheckBox.run(ID:"//*[@id='CB_RICH_TEXT_LONG_QUESTION']",Check:params."Rich Text for Additional Submission Form Long Question")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_SUBMIT_ON_BEHALF']",Check:params."Enable Submit on Behalf")
        SetCheckBox.run(ID:"//*[@id='CB_WS_EMAIL_STATS_SUMMARY']",Check:params."Enable email statistics summary")
        if(params."Enable email statistics summary Weekly"){Click.run(ID:"//*[@id='CB_WS_EMAIL_STATS_SUMMARY_WEEKLY']")}
        if(params."Enable email statistics summary Monthly"){Click.run(ID:"//*[@id='CB_WS_EMAIL_STATS_SUMMARY_MONTHLY']")}
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_POLL_REPORT_WS']",Check:params."Enable Poll Report")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_USER_SELECT_SUB_FORM']",Check:params."Enable User Select Submission Form Field")
        SetCheckBox.run(ID:"//*[@id='CB_PRINT_FRIENDLY_IDEA_LIST']",Check:params."Enable Print Friendly note List")
        SetCheckBox.run(ID:"//*[@id='CB_DISPLAY_DATE_SIMPLE_FORMAT']",Check:params."Display dates in simple date and time format")
        SetCheckBox.run(ID:"//*[@id='CB_DISABLE_CATEGORY_SUB_ALERT']",Check:params."Disable Category Subscription Email Alert")
        SetCheckBox.run(ID:"//*[@id='CB_DISABLE_SUBMIT_CONFIRM']",Check:params."Disable Submission Email Alert")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_IDEA_REDIRECT']",Check:params."Redirect page to")
        SetText.run(ID:"//*[@id='redirect_url']",Text:params."Redirect page to text")
        
        Click.run(ID:"//*[@id='bi_custom_save_button']")
        Click.run(ID:"//*[@id='gen_mess_message']/BUTTON[1]")
    
    }
}