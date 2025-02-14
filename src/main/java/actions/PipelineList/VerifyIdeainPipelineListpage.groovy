package actions.PipelineList;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.GridCommon

class VerifyIdeainPipelineListpage{
    public void run(def params){
        //Map all values that will be used for verification for that instance
        
        def verify = [:]
        verify.Table = "//*[@id='grid_holder']/DIV[1]/DIV[3]/TABLE[1]"
        //verify.ID= "//TD[3]/A[contains(text(),'${params."Title"}')]"  
        verify.ID= "//TD[contains(@class,'title')]/A[contains(text(),'${params."Title"}')]"        
        verify.IDChildren = []
        if(params."Image"!=null){
            def img
            if(params."Image"){img = "/IMG[contains(@src,'/ct/getfile.php')]"}
            else{img = "/IMG[contains(@src,'default-idea-image.jpg')]"}
            verify.IDChildren << "./../../TD[2]${img}"
        }
        if(params."Code"){verify.IDChildren << "./../../TD[contains(@class,'code') and text()='${params."Code"}']"}
        if(params."Stage"){verify.IDChildren << "./../../TD[contains(@class,'stage') and text()='${params."Stage"}']"}
        if(params."Step"){verify.IDChildren << "./../../TD[contains(@class,'step') and text()='${params."Step"}']"}
        if(params."Submitter"){verify.IDChildren << "./../../TD[contains(@class,'screen_name') and text()='${params."Submitter"}']"}
        if(params."Submission Team"){verify.IDChildren << "./../../TD[contains(@class,'submission_team') and text()='${params."Submission Team"}']"}
        if(params."Submission Team Name"){verify.IDChildren << "./../../TD[contains(@class,'team_name') and text()='${params."Submission Team Name"}']"}
        if(params."Owner"){verify.IDChildren << "./../../TD[contains(@class,'owner') and text()='${params."Owner"}']"}
        if(params."Submitted"){verify.IDChildren << "./../../TD[contains(@class,'date_created') and text()='${params."Submitted"}']"}
        if(params."Category"){verify.IDChildren << "./../../TD[contains(@class,'category') and text()='${params."Category"}']"}
        if(params."Status"){verify.IDChildren << "./../../TD[contains(@class,'status') and text()='${params."Status"}']"}
        if(params."Innovation State"){verify.IDChildren << "./../../TD[contains(@class,'state') and text()='${params."Innovation State"}']"}
        if(params."Applications Sent"){verify.IDChildren << "./../../TD[contains(@class,'application_sent') and text()='${params."Applications Sent"}']"}
        if(params."Applications Accepted"){verify.IDChildren << "./../../TD[contains(@class,'application_accepted') and text()='${params."Applications Accepted"}']"}
        if(params."Points"){verify.IDChildren << "./../../TD[contains(@class,'score') and text()='${params."Points"}']"}
        if(params."Views"){verify.IDChildren << "./../../TD[contains(@class,'views') and text()='${params."Views"}']"}
        if(params."Visible"){verify.IDChildren << "./../../TD[contains(@class,'visible') and text()='${params."Visible"}']"}
        if(params."Projected Benefit"){verify.IDChildren << "./../../TD[contains(@class,'projected_gross') and text()='${params."Projected Benefit"}']"}
        if(params."Projected Cost"){verify.IDChildren << "./../../TD[contains(@class,'projected_cost') and text()='${params."Projected Cost"}']"}
        if(params."Actual Benefit"){verify.IDChildren << "./../../TD[contains(@class,'outcomes_cell') and text()='${params."Actual Benefit"}']"}
        if(params."Actual Cost"){verify.IDChildren << "./../../TD[contains(@class,'actual_cost') and text()='${params."Actual Cost"}']"}
        if(params."Non-Financial Benefit"){verify.IDChildren << "./../../TD[contains(@class,'outcomes_count') and text()='${params."Non-Financial Benefit"}']"}
        if(params."Tags"){
            if(params."Tags"=="<EMPTY>"){verify.IDChildren << "./../../TD[starts-with(@class,'tags') and not(text())]"}
            else{verify.IDChildren << "./../../TD[starts-with(@class,'tags') and text()='${params."Tags"}']"}
        }
        if(params."Admin Tags"){
            if(params."Admin Tags"=="<EMPTY>"){verify.IDChildren << "./../../TD[starts-with(@class,'admin_tags') and not(text())]"}
            else{verify.IDChildren << "./../../TD[starts-with(@class,'admin_tags') and text()='${params."Admin Tags"}']"}
        }
        if(params."Linked Submissions"){
            if(params."Linked Submissions"=="<EMPTY>"){verify.IDChildren << "./../../TD[starts-with(@class,'linked_ideas') and not(text())]"}
            else{verify.IDChildren << "./../../TD[starts-with(@class,'linked_ideas') and text()='${params."Linked Submissions"}']"}
        }
        if(params."Linked Whiteboard"){
            if(params."Linked Whiteboard"=="<EMPTY>"){verify.IDChildren << "./../../TD[starts-with(@class,'linked_whiteboard') and not(text())]"}
            else{verify.IDChildren << "./../../TD[starts-with(@class,'linked_whiteboard') and text()='${params."Linked Whiteboard"}']"}
        }
        if(params."Merged"){
            if(params."Merged"=="<EMPTY>"){verify.IDChildren << "./../../TD[starts-with(@class,'merged_cell') and not(text())]"}
            else{verify.IDChildren << "./../../TD[starts-with(@class,'merged_cell') and text()='${params."Merged"}']"}
        }
        if(params."Merged With"){
            if(params."Merged With"=="<EMPTY>"){verify.IDChildren << "./../../TD[starts-with(@class,'merged_with') and text()=not(text())]"}
            else{verify.IDChildren << "./../../TD[starts-with(@class,'merged_with') and text()='${params."Merged With"}']"}
        }
        if(params."Favorites"){verify.IDChildren << "./../../TD[starts-with(@class,'favorite') and text()='${params."Favorites"}']"}
        if(params."Comments"){verify.IDChildren << "./../../TD[starts-with(@class,'comment') and text()='${params."Comments"}']"}
        if(params."Subscriber Count"){verify.IDChildren << "./../../TD[starts-with(@class,'subscriber_count') and text()=text()='${params."Subscriber Count"}']"}
        if(params."Review Complete"){verify.IDChildren << "./../../TD[26][text()='${params."Review Complete"}']"}
        if(params."Single Scale Average Rating"){verify.IDChildren << "./../../TD[27][text()='${params."Single Scale Average Rating"}']"}
        if(params."Scorecarding Average Score"){verify.IDChildren << "./../../TD[28][text()='${params."Scorecarding Average Score"}']"}
        if(params."Stack Rank Overall Rank"){verify.IDChildren << "./../../TD[29][text()='${params."Stack Rank Overall Rank"}']"}
        if(params."Project Prep Revenue"){verify.IDChildren << "./../../TD[30][text()='${params."Project Prep Revenue"}']"}
        if(params."Project Prep Savings"){verify.IDChildren << "./../../TD[31][text()='${params."Project Prep Savings"}']"}
        if(params."Project Prep Outcomes"){verify.IDChildren << "./../../TD[32][text()='${params."Project Prep Outcomes"}']"}
        if(params."Pairwise Overall Rank"){verify.IDChildren << "./../../TD[33][text()='${params."Pairwise Overall Rank"}']"}
        if(params."Single Choice Additional Question Dropdown"){
           if(params."Single Choice Additional Question Dropdown"=="<EMPTY>"){verify.IDChildren << "./../../TD[34][not(text())]"}
            else{verify.IDChildren << "./../../TD[34][text()='${params."Single Choice Additional Question Dropdown"}']"}
        }
        if(params."Short Answer Additional Question"){
            if(params."Short Answer Additional Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[35][not(text())]"}
            else{verify.IDChildren << "./../../TD[35][text()='${params."Short Answer Additional Question"}']"}
        }
        if(params."Long Answer Additional Question"){
            if(params."Long Answer Additional Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[36][not(text())]"}
            else{verify.IDChildren << "./../../TD[36][text()='${params."Long Answer Additional Question"}']"}
        }
        if(params."Single Checkbox Additional Question"!=null){
            if(params."Single Checkbox Additional Question"){verify.IDChildren << "./../../TD[37]/INPUT[@checked='checked']"}
            else{verify.IDChildren << "./../../TD[37]/INPUT[not(@checked='checked')]"}
        }
        if(params."Multiple Choice Question"){
            if(params."Multiple Choice Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[38][not(text())]"}
            else{verify.IDChildren << "./../../TD[38][text()='${params."Multiple Choice Question"}']"}
        }
        if(params."Checkbox Question"){
            if(params."Checkbox Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[39][not(text())]"}
            else{verify.IDChildren << "./../../TD[39][text()='${params."Checkbox Question"}']"}
        }
        if(params."Short Answer Question"){
            if(params."Short Answer Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[40][not(text())]"}
            else{verify.IDChildren << "./../../TD[40][text()='${params."Short Answer Question"}']"}
        }
        if(params."Long Answer Question"){
            if(params."Long Answer Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[41][not(text())]"}
            else{verify.IDChildren << "./../../TD[41][text()='${params."Long Answer Question"}']"}
        }
        if(params."Dropdown Question"){
            if(params."Dropdown Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[42][not(text())]"}
            else{verify.IDChildren << "./../../TD[42][text()='${params."Dropdown Question"}']"}
        }
        if(params."Date Question"){
            if(params."Date Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[43][not(text())]"}
            else{verify.IDChildren << "./../../TD[43][text()='${params."Date Question"}']"}
        }
        if(params."Number Question"){
            if(params."Number Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[44][not(text())]"}
            else{verify.IDChildren << "./../../TD[44][text()='${params."Number Question"}']"}
        }
        if(params."User Selection Question"){
            if(params."User Selection Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[45][not(text())]"}
            else{verify.IDChildren << "./../../TD[45][text()='${params."User Selection Question"}']"}
        }
        if(params."Admin Only Dropdown Question"){
            if(params."Admin Only Dropdown Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[46][not(text())]"}
            else{verify.IDChildren << "./../../TD[46][text()='${params."Admin Only Dropdown Question"}']"}
        }
        if(params."Required Short Question"){
            if(params."Required Short Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[47][not(text())]"}
            else{verify.IDChildren << "./../../TD[47][text()='${params."Required Short Question"}']"}
        }
        if(params."Development Multiple Choice Question"){
            if(params."Development Multiple Choice Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[48][not(text())]"}
            else{verify.IDChildren << "./../../TD[48][text()='${params."Development Multiple Choice Question"}']"}
        }
        if(params."Development Long Answer Question"){
            if(params."Development Long Answer Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[49][not(text())]"}
            else{verify.IDChildren << "./../../TD[49][text()='${params."Development Long Answer Question"}']"}
        }
        if(params."Development Attachment Question"){
            if(params."Development Attachment Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[50][not(text())]"}
            else{verify.IDChildren << "./../../TD[50][text()='${params."Development Attachment Question"}']"}
        }
        if(params."Development User Select Question"){
            if(params."Development User Select Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[51][not(text())]"}
            else{verify.IDChildren << "./../../TD[51][text()='${params."Development User Select Question"}']"}
        }
        if(params."Development Parent Dropdown Question"){
            if(params."Development Parent Dropdown Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[52][not(text())]"}
            else{verify.IDChildren << "./../../TD[52][text()='${params."Development Parent Dropdown Question"}']"}
        }
        if(params."Development Child Checkbox Question"){
            if(params."Development Child Checkbox Question"=="<EMPTY>"){verify.IDChildren << "./../../TD[53]not(text())]"}
            else{verify.IDChildren << "./../../TD[53][text()='${params."Development Child Checkbox Question"}']"}
        }
		if(params."Team Name"){verify.IDChildren << "./../../TD[starts-with(@class,'team_name') and text()='${params."Team Name"}']"}
        if(params."Row Number"){
            def rowNum = GridCommon.RowNumberForValues(verify).toString()
            assert rowNum==params."Row Number","Error - Expected value to be in Row Number ${params."Row Number"} but actual Row is ${rowNum}"
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            verify.ID = verify.Table+verify.ID
            VerifyNumberOfMatches.run(verify)
        }
    }
}