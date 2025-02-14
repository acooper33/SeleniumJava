package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.SetText

class SetWebstormSetupIdeasforVotingtab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Voting")

        SetCheckBox.run(ID:"//*[@id='IDEAS_CB_DISABLE_IDEA_VOTING']",Check:params."Voting Checkbox")
        SetCheckBox.run(ID:"//*[@id='IDEAS_PROMOTE_ONLY_WS']",Check:params."Demote Voting Checkbox")

        if(params."Type of Voting"){
            if(params."Type of Voting"=="Simple"){
                Click.run(ID:"//*[@id='IDEAS_SIMPLE_VOTE']")
            } else if (params."Type of Voting"=="Chips"){
                Click.run(ID:"//*[@id='IDEAS_WS_CHIPS_VOTING']")
                if(params."Total number of chips per user"){SetText.run(Text:params."Total number of chips per user",ID:"//*[@id='CHIPS_PER_USER']")}
                if(params."Number of chips a user can give to an idea"){SetText.run(Text:params."Number of chips a user can give to an idea",ID:"//*[@id='CHIPS_PER_VOTE']")}
                if(params."Return chips when an idea reaches one of the following statuses") {
                    params."Return chips when an idea reaches one of the following statuses".split(",").eachWithIndex{ status, x ->
                        if(params."Add or Remove Statuses".split(",")[x]=="Add"){
                            Click.run(ID:"//*[@id='all_chips_statuses']/option[text()='${status}']")
                            Click.run(ID:"//*[@id='chips_voting_extra_options']//button[text()='>>']")
                        } else {
                            Click.run(ID:"//*[@id='selected_chips_statuses']/option[text()='${status}']")
                            Click.run(ID:"///*[@id='chips_voting_extra_options']//button[text()='Remove Selected']")
                        }
                    }
                }
            } else { Click.run(ID:"//*[@id='IDEAS_SINGLE_VOTE_WS']")}
        }

        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_PROMOTE_REASON']",Check:params."Enable Promote Reason")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_DEMOTE_REASON']",Check:params."Enable Demote Reason")
        SetCheckBox.run(ID:"//*[@id='CB_SUBMITTER_NO_AUTO_VOTE_ON_SUBMISSION']",Check:params."Submitter auto-promote on submission")
        SetCheckBox.run(ID:"//*[@id='CB_VIEW_IDEA_VOTING_UI_2']",Check:params."New Voting Buttons")

        Click.run(ID:"//*[@id='ideas_voting_save_button']")
    }
}
