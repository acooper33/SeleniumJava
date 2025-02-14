package actions.SetupBI;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SetText
import actions.selenium.ExplicitWait

class SetEnterpriseSetupforBIOnlyBetatab{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"BI Only",Section:"Beta")
        if(params."Enable Messages in new Global Nav"){SetCheckBox.run(ID:"//*[@id='CB_ENABLE_MESSAGE_IN_NEW_GLOBAL_NAV']",Check:params."Enable Messages in new Global Nav")}
        if(params."Attachment Max Upload Filesize"){SetText.run(ID:"//*[@id='ATTACH_MAX_FILESIZE']",Text:params."Attachment Max Upload Filesize")}
        SetCheckBox.run(ID:"//*[@id='CB_USER_SELECTION_FIELD']",Check:params."User Selection field")
        SetCheckBox.run(ID:"//*[@id='CB_DISPLAY_IDEA_OWNER_OPTION']", Check:params."Display Idea Owner Option")
        SetCheckBox.run(ID:"//*[@id='CB_DISPLAY_FIND_OWNER_TOOL_OPTION']", Check:params."Display Find Owner Tool Option")
        SetCheckBox.run(ID:"//*[@id='CB_EDIT_OWNER_FEATURE_TOGGLE']", Check:params."Owner Edit and History")
        SetCheckBox.run(ID:"//*[@id='CB_DUPLICATE_INITIATIVE_UPDATES']", Check:params."Duplicate Initiative Updates")
        SetCheckBox.run(ID:"//*[@id='CB_INSTRUCTIONAL_TEXT_FOR_POST_IDEA']",Check: params."Instructional Text for Post Idea 2.0")
        SetCheckBox.run(ID:"//*[@id='CB_USER_HOMEPAGE_FEATURED_ACTIVITY_TOGGLE']",Check: params."Featured Activity Panel on Highlights page")
        SetCheckBox.run(ID:"//*[@id='CB_INDIVIDUAL_ASSIGNMENT_FOR_FIND_OWNER']", Check:params."Individual Assignment for Find Owner")
        SetCheckBox.run(ID:"//*[@id='CB_HIDE_PRIVATE_COMMENTS_FOR_DEV_STEPS']", Check:params."Hide Private Comments for Development Steps")
        //used to test old copy idea and change pipeline
        SetCheckBox.run(ID:"//*[@id='CB_MOVE_AND_COPY_IDEA_UPDATES']", Check:params."Move and Copy Idea Updates")
        SetCheckBox.run(ID:"//*[@id='CB_MOVE_IDEA_AND_COPY_IDEA_IN_RULES_ENGINE']", Check:params."Move Idea and Copy Idea in Rules Engine")
      	SetCheckBox.run(ID:"//*[@id='CB_ENABLE_IDEA_BOARDS_LIST_VIEW']", Check:params."Idea Boards List View")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_BOARDS_CARDS_FRACTAL_V2']", Check:params."New Idea Card Design on Idea Boards")
        SetCheckBox.run(ID:"//*[@id='CB_VIEW_IDEA_VOTING_UI_2']", Check:params."New Voting UI in View Idea 2.0")
        SetCheckBox.run(ID:"//*[@id='CB_PEOPLE_PILLAR_USER_MANAGEMENT_DROPDOWN']", Check:params."People Pillar User Management dropdown")
        SetCheckBox.run(ID:"//*[@id='CB_LINK_IDEA_IMPROVEMENTS']", Check:params."Link Ideas Improvements")
        SetCheckBox.run(ID:"//*[@id='CB_MOVE_COPY_DEV_FIELD_UPDATE']", Check:params."Move/Copy Development Field Updates")
        SetCheckBox.run(ID:"//*[@id='CB_COMMUNITY_ADMINISTRATOR_MANAGER']", Check:params."Community Administrator Manager")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_BOX_MANAGER_FIELD']", Check:params."Idea Box Manager Field Updates")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_WHITEBOARD_ONLY_WB_AG']", Check:params."Only users in group name ends with WB-AG can Access from UserHome")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_WHITEBOARD_LINE_TOOL']", Check:params."Whiteboard Line Tool")
        SetCheckBox.run(ID:"//*[@id='CB_STEP_AND_STAGE_EXPORTS']", Check:params."Step and Stage Exports")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_DUPLICATE_IDEA_BOX']", Check:params."Duplicate Idea Box")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_VIEW_ONLY_LINK_FOR_WHITEBOARDS']", Check:params."View-Only Link for Whiteboards")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_SECURITY_QUESTIONS']", Check:params." Enable Security Questions")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_COMMUNITY_ANALYTICS_DASHBOARDS']", Check:params."Community Dashboards")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_MEMO_USERHOME']", Check:params."Enable memos on Userhome")
        SetCheckBox.run(ID:"//*[@id='CB_MEMO_IN_WHITEBOARD']", Check:params."Import from pipeline in Whiteboard")
        SetCheckBox.run(ID:"//*[@id='CB_QUICK_ADD_EVALUATOR']", Check:params."Evaluator able to submit Quick Add")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_NEW_ENT_SEARCH_PAGE']", Check:params."Enable New Enterprise Search Page")
        SetCheckBox.run(ID:"//*[@id='CB_TEMPLATES_RIBBON']", Check:params."Memo BI Templates")
        SetCheckBox.run(ID:"//*[@id='CB_CREATE_MEMO_WIZARD']", Check:params."Create Memo Wizard")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_MEMO_TAB_IN_SYSTEM_SETUP']", Check:params."Show Memo tab in system setup")
        SetCheckBox.run(ID:"//*[@id='CB_WB_LINK_TO_SELECTED']", Check:params."Whiteboard: Link to Object")
        SetCheckBox.run(ID:"//*[@id='CB_DUPLICATE_STEP']", Check:params."Duplicate Step")
        SetCheckBox.run(ID:"//*[@id='CB_WB_EXPORT_OPTIONS']", Check:params."Whiteboard: Export options")
        SetCheckBox.run(ID:"//*[@id='CB_STEP_CONFIG_UPD']", Check:params."Step Configuration Popup Updates")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_AI_ASSIST_SECTION']", Check:params."AI Toggle Updates for Release")
        SetCheckBox.run(ID:"//*[@id='CB_MEMO_AI_CONTENT_UPDATES']", Check:params."Memo AI, Content Updates")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_MEMO_EDITOR']", Check:params."Memo Collaborative Editor")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_SEND_TO_WHITEBOARD']", Check:params."Pipeline to Whiteboard", "Type of Click":"Javascript")
        SetCheckBox.run(ID:"//*[@id='CB_WB_SAVE_AS_TEMPLATE']", Check:params."Whiteboard: Save as Template", "Type of Click":"Javascript")
        //SetCheckBox.run(ID:"//*[@id='CB_RULES_ENGINE_IMPROVEMENTS']", Check:params."Rules Engine Improvements")
        SetCheckBox.run(ID:"//*[@id='CB_UH_ACTIVITY_FEED']", Check:params."Userhome Activity Feed Updates")
//		SetCheckBox.run(ID:"//*[@id='CB_ENABLE_RESEND_ACTION_ITEMS']", Check:params."Resend Action Items Part 1")
        SetCheckBox.run(ID:"//*[@id='CB_IDEA_BOX_TEAM_SITE_REDIRECT']", Check:params."Idea Box Team Site Routing")
        //'Hack Judging Tooltype Updates' option had been removed and included under 'Evaluation reordering and communications' in Beta - Beta
        SetCheckBox.run(ID:"//*[@id='CB_HACK_JUDGING_UPDATES']", Check:params."Hack Judging Tooltype Updates")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_PROJECT_ROOM_RULES_ENGINE']", Check:params."Rules engine: Project Room Creation")
        SetCheckBox.run(ID:"//*[@id='CB_WB_LINK_OBJECTS']", Check:params."Whiteboard: Add Link to Object")
		SetCheckBox.run(ID:"//*[@id='CB_TEAM_NAME_CAPABILITIES']", Check:params."Team Name Capabilities")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_WHITEBOARD_WIDGET_VIEW_IDEA_3']", Check:params."Whiteboard on View Idea 3.0")
        SetCheckBox.run(ID:"//*[@id='CB_WB_SUBMISSION_FORM']", Check:params."Whiteboard on Submission Form")
        SetCheckBox.run(ID:"//*[@id='CB_HACK_ONBOARDING']", Check:params."Onboarding for Hackathon")
        SetCheckBox.run(ID:"//*[@id='CB_PROJECT_ROOM_TILE_ACTIONS']", Check:params."Project Room Tile Actions")
        SetCheckBox.run(ID:"//*[@id='CB_EVALUATION_NAVIGATION_UPDATE']", Check:params."Evaluation navigation updates")
        SetCheckBox.run(ID:"//*[@id='CB_UPDATE_EVALUATION_ORDER']", Check:params."Evaluation Reordering")
        SetCheckBox.run(ID:"//*[@id='CB_UPDATE_EVALUATION_ADMIN']", Check:params."Evaluation Updates for Admin")
        SetCheckBox.run(ID:"//*[@id='CB_PROJECT_ROOM_MULTI_FILE_PAGES']", Check:params."Multiple file pages in Project Room")
        SetCheckBox.run(ID:"//*[@id='CB_INVITE_USER_JOIN_TEAM']", Check:params."Invite user to join team flow")
        SetCheckBox.run(ID:"//*[@id='CB_STAGE_GATE_TEMPLATES']", Check:params." Stage Gate Templates")
        SetCheckBox.run(ID:"//*[@id='CB_PR_TEMPS_FOR_HACK']", Check:params."Project Room Templates for Hackathon")
        SetCheckBox.run(ID:"//*[@id='CB_CERTS_ON_PARTICIPANTS_PAGE']", Check:params."Adding Certifications to Participant Page ")
        SetCheckBox.run(ID:"//*[@id='CB_HACK_TEAM_SITE']", Check:params."Hackathon Team Site")
        SetCheckBox.run(ID:"//*[@id='CB_USER_REG_TEAM_SUBMISSION']",Check:params."Allow user registration on team submissions")
        SetCheckBox.run(ID:"//*[@id='CB_UPDATE_WB_MODAL_PR']",Check:params."Updated Whiteboard Modal in Project Room")
        SetCheckBox.run(ID:"//*[@id='CB_WB_TOP_IDEAS']",Check:params."Top Ideas in Whiteboard")
//        SetCheckBox.run(ID:"//*[@id='CB_PROJECT_ROOM_ONBOARDING_TEMPLATE']",Check:params."Project Room, Onboarding Template")
        SetCheckBox.run(ID:"//*[@id='CB_REMOVE_ACTION_ITEM_TOUR']",Check:params."Action Item Manager Tour Removal")
//        SetCheckBox.run(ID:"//*[@id='CB_GATE_SCORECARD_VISIBILITY']",Check:params."Gate Scorecard Visibility")
//        SetCheckBox.run(ID:"//*[@id='CB_GATE_FLOATING_SCORECARD']",Check:params."Floating Gate Scorecard")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_STAGE_GATE_UPDATES']",Check:params."Fall Stage Gate Updates")
        SetCheckBox.run(ID:"//*[@id='CB_ADVANCED_QA']",Check:params."Advanced Quick Add")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_APPS_PILLAR_V4']",Check:params."Migrate Legacy apps pillar and Programs Pro apps pillar to Cloud/BIC apps pillar")
        SetCheckBox.run(ID:"//*[@id='CB_GROUP_CREATION_UPDATES']",Check:params."Group Creation Updates")
        SetCheckBox.run(ID:"//*[@id='CB_SCHEDULER_UPDATES']",Check:params."Scheduler updates")
        SetCheckBox.run(ID:"//*[@id='CB_PROJECT_ROOM_SEARCH']",Check:params."Project Room Search in Userhome")
        
        if (params."Enable CA Updates"){
            SetCheckBox.run(ID:"//*[@id='CB_ENABLE_CA']", Check:params."Enable CA Updates")
            //after that need to Save and refresh the page
            Click.run(ID:"//*[@id='bi_only_beta_save_button']") 
            ExplicitWait.run(ID:"//*[@id='bi_only_beta_spinner' and contains(@style,'none')]")
            if(params."Enable CA Updates Site Setting"=='Multi-Site'){
                Click.run(ID:"//*[@id='gear-button']")
            	Click.run(ID:"//*[@id='account-links']//LI[text()='System Setup']")
                SetupCommon.NavigateTab(Tab:"BI Only",Section:"Beta")
                sleep(3000)
                Click.run(ID:"//*[@id='CB_ENABLE_CA_MULTI']")
                Click.run(ID:"//*[@id='bi_only_beta_save_button']")
                ExplicitWait.run(ID:"//*[@id='bi_only_beta_spinner' and contains(@style,'none')]")
            }
        }
        else{
            Click.run(ID:"//*[@id='bi_only_beta_save_button']")
            ExplicitWait.run(ID:"//*[@id='bi_only_beta_spinner' and contains(@style,'none')]")
        }
    }
    
}