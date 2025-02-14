package actions.PipelineDashBoard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.GridCommon
import actions.selenium.*

class VerifyandAccessMilestonesontheSubmissionHoverinBusinessImpactTab{
    public void run(def params){

        if(params."Incomplete Milestone"){
            def verify = [:]
            verify.Table = "//*[@class='milestone-tab']//tbody"
            verify.ID = "//*[@class='milestone-name' and text()='${params."Incomplete Milestone"}']"
            verify.IDChildren = []
            if(params."Due Date"){verify.IDChildren << "./../../TD[2][text()='${params."Due Date"}']"}
            if(params."Row Number"){
                def rowNum = GridCommon.RowNumberForValues(verify).toString()
                assert rowNum==params."Row Number","Error - Expected value to be in Row Number ${params."Row Number"} but actual Row is ${rowNum}"
            }
            else{
                if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
                VerifyNumberOfMatches.run(verify)
            }
        }
        if(params."View All Milestones"==true){
            Click.run(ID:"//*[@class='milestone-tab']//A","Type of Click":"Javascript")
        }
    }
}