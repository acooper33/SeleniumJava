package actions.SetupIdeas;

import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.common.SetupCommon

class SetWebstormSetupIdeasCommentsTab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Comments")
        if(params."Commenting Type"){
            Click.run(ID:"//*[@id='comments_content']//*[text()='${params."Commenting Type"}']/preceding-sibling::input[1]")
        }
 		SetCheckBox.run(ID:"//*[@id='CB_DISABLE_COMMENTS_WS']", Check:params."Comment Submission")
        SetCheckBox.run(ID:"//*[@id='CB_EDIT_COMMENT_SUBMITTER']", Check:params."Comment Editing for Submitter")
        SetCheckBox.run(ID:"//*[@id='CB_DELETE_COMMENT_SUBMITTER']", Check:params."Comment Deleting for Submitter")
        SetCheckBox.run(ID:"//*[@id='CB_COMMENTS_W_ATTACHMENTS']", Check:params."Attachments on Comments")
        SetCheckBox.run(ID:"//*[@id='CB_WS_COMMENT_VOTING']", Check:params."Voting on Comments")
        SetCheckBox.run(ID:"//*[@id='CB_SHOW_COMMENT_DEMOTE_COUNT']", Check:params."Show Comment Demote Count")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_TAG_TO_INVITE_IN_COMMENTS_FOR_ALL_USERS']", Check:params."Allow all users to invite from comment tags")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_EVAL_COMMENTS']", Check:params."Allow admins and evaluators to always comment")
        if(params.Action == "Save Changes"){
            Click.run(ID:"//*[@id='comments_save_button']")
        }
        sleep(5000)
   	}
}