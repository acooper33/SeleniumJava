package actions.SetupBI;

import actions.common.SetupCommon
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SetCheckBox

class SetSiteSetupforBIBetatab{
    public void run(def params){
       	SetupCommon.NavigateTab(Tab:"BI",Section:"Beta")       
        SetCheckBox.run(ID:"//*[@id='CB_BEST_IDEA_UI']", Check:params."Enable Best Idea Wins UI")
        SetCheckBox.run(ID:"//*[@id='CB_BIW_VIEW_MY_SETS']", Check:params."Show View My Sets in Category View")
        SetText.run(ID:"//*[@id='ATTACH_MAX_FILESIZE']",Text:params."Attachment Max Upload Filesize")
        SetCheckBox.run(ID:"//*[@id='CB_FIND_OWNER_TOOL_TYPE']",Check:params."Find Owner Tool Type")
        SetCheckBox.run(ID:"//*[@id='CB_ENABLE_VOTING_ON_IDEA_BOARDS']",Check:params."Voting on Idea Boards")
        SetCheckBox.run(ID:"//*[@id='CB_NEW_IDEA_BOX_SUB_PIPELINE']",Check:params."This pipeline is an Idea Box Sub-pipeline")
        SetCheckBox.run(ID:"//*[@id='CB_WS_ENABLE_STAGE_GATE_WORKFLOW']",Check:params."Stage Gate Workflow")
        if(params."My Open Evaluations"){
            System.out.println("TRUEEEEE")
            SetCheckBox.run(ID:"//*[@id='CB_FILTER_MY_OPEN_EVALUATIONS']", Check:params."My Open Evaluations")

        }
        //SetCheckBox.run(ID:"//*[@id='CB_FILTER_MY_OPEN_EVALUATIONS']", Check:params."My Open Evaluations")
        Click.run(ID:"//*[@id='bi_beta_save_button']") 
    }
}