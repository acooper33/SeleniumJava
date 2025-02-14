package actions.NGAInnovationList;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.GridCommon

class VerifyIdeainInnovationsPillar{
    public void run(def params){

        def verify = [:]
        verify.IDChildren = []
        verify.Table = "//DIV[1]/DIV[3]/TABLE[1]"
        verify.ID = "(//TABLE)[2]//TD[.='${params."Title"}']"

        if(params."Team Name"){verify.IDChildren << "./..//TD[contains(@class,'team_name_cell') and text()='${params."Team Name"}']"}
        if(params."Code"){verify.IDChildren << "./..//TD[text()='${params."Code"}']"}
        if(params."Pipeline"){verify.IDChildren << "./../..//A[contains(@href,'pipeline') and text()='${params."Pipeline"}']"}
        if(params."Stage"){verify.IDChildren << "./..//TD[contains(@class,'stage') and text()='${params."Stage"}']"}
        if(params."Step"){verify.IDChildren << "./..//TD[contains(@class,'step') and text()='${params."Step"}']"}
        if(params."Owner"){verify.IDChildren << "./..//TD[contains(@class,'owner') and text()='${params."Owner"}']"}        
        if(params."Submitter"){verify.IDChildren << "./..//TD[contains(@class,'screen_name') and text()='${params."Submitter"}']"}
        if(params."Submitted"){verify.IDChildren << "./..//TD[contains(@class,'date_created') and text()='${params."Submitted"}']"}
        if(params."Category"){verify.IDChildren << "./..//TD[contains(@class,'category_cell') and text()='${params."Category"}']"}
        if(params."Status"){verify.IDChildren << "./..//TD[contains(@class,'status') and text()='${params."Status"}']"}
        if(params."Innovation State"){verify.IDChildren << "./..//TD[contains(@class,'state') and text()='${params."Innovation State"}']"}
        if(params."Points"){verify.IDChildren << "./..//TD[contains(@class,'score') and text()='${params."Points"}']"}
        if(params."Chips"){verify.IDChildren << "./..//TD[contains(@class,'chips') and text()='${params."Chips"}']"}
        if(params."Views"){verify.IDChildren << "./..//TD[contains(@class,'views') and text()='${params."Views"}']"}
        if(params."Visible"){verify.IDChildren << "./..//TD[contains(@class,'visible') and text()='${params."Visible"}']"}
        if(params."Visible"){verify.IDChildren << "./..//TD[contains(@class,'visible') and text()='${params."Visible"}']"}
        if(params."Projected Benefit"){verify.IDChildren << "./..//TD[contains(@class,'projected_gross') and contains(text(),'${params."Projected Benefit"}')]"}
        if(params."Projected Cost"){verify.IDChildren << "./..//TD[contains(@class,'projected_cost') and contains(text(),'${params."Projected Cost"}')]"}
        if(params."Actual Benefit"){verify.IDChildren << "./..//TD[contains(@class,'outcomes_cell') and contains(text(),'${params."Actual Benefit"}')]"}
        if(params."Actual Cost"){verify.IDChildren << "./..//TD[contains(@class,'actual_cost') and contains(text(),'${params."Actual Cost"}')]"}
        if(params."Non-Financial Benefit"){verify.IDChildren << "./..//TD[contains(@class,'outcomes_count_cell') and contains(text(),'${params."Non-Financial Benefit"}')]"}
        if(params."Tags"){verify.IDChildren << "./..//TD[contains(@class,'tags') and contains(text(),'${params."Tags"}')]"}
        if(params."Admin Tags"){verify.IDChildren << "./..//TD[contains(@class,'admin_tags') and contains(text(),'${params."Admin Tags"}')]"}
        if(params."Linked Ideas"){verify.IDChildren << "./..//TD[contains(@class,'linked_ideas_cell') and contains(text(),'${params."Linked Ideas"}')]"}
        if(params."Favorites"){verify.IDChildren << "./..//TD[contains(@class,'favorites') and contains(text(),'${params."Favorites"}')]"}
        if(params."Comments"){verify.IDChildren << "./..//TD[contains(@class,'favorites') and contains(text(),'${params."Comments"}')]"}
        if(params."Subscriber Count"){verify.IDChildren << "./..//TD[contains(@class,'subscriber_count') and contains(text(),'${params."Subscriber Count"}')]"}

        if(params."Row Number"){
            verify.ID = "//TD[.='${params."Title"}']"
            def rowNum = GridCommon.RowNumberForValues(verify).toString()
            assert rowNum==params."Row Number","Error - Expected value to be in Row Number ${params."Row Number"} but actual Row is ${rowNum}"
        } else {
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        }
    }
}