package actions.SetupUsers;

import actions.selenium.*
import actions.common.SetupCommon
    
class SetInitiativeSetupUsersReputationpage{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Users",Section:"Reputation")
        SetText.run(ID:"//*[@id='register_points']",Text:params."Register")
        SetText.run(ID:"//*[@id='invite_friend_points']",Text:params."Invite a Friend")
        SetText.run(ID:"//*[@id='friend_registered_points']",Text:params."Invited Friend Registered")
        SetText.run(ID:"//*[@id='promote_idea_points']",Text:params."Promote Idea")
        SetText.run(ID:"//*[@id='demote_idea_points']",Text:params."Demote Idea")
        SetText.run(ID:"//*[@id='idea_promoted_points']",Text:params."Someone promotes your idea")
        SetText.run(ID:"//*[@id='post_idea_points']",Text:params."Post Idea")
        SetText.run(ID:"//*[@id='post_comment_points']",Text:params."Post Comment")
        SetText.run(ID:"//*[@id='promote_comment_points']",Text:params."Promote Comment")
        SetText.run(ID:"//*[@id='comment_promoted_points']",Text:params."Someone promotes your comment")
        SetText.run(ID:"//*[@id='demote_comment_points']",Text:params."Demote Comment")
        Click.run(ID:"//*[@id='reputation_save_button']")
    }
}