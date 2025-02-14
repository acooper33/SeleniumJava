package actions.NGAAnalyticsDashboard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.GridCommon

class VerifyInitiativeintheInitiativeTableonEnterpriseBusinessImpacttab{
    public void run(def params){

        sleep(3000)
        def verify = [:]
        verify.Table = "//*[@id='enterpriseDashboardBusinessImpactInitiativeTable']/tbody"
        verify.ID = "//*[@class='idea-cell']/A[text()='${params."Initiative"}']"
        verify.IDChildren = []
        if(params."Initiative Image"!=null){
            def img
            if(params."Initiative Image"=="Custom Image"){img = "/IMG[contains(@src,'/ct/getfile.php')]"}
            else{img = "/IMG[contains(@src,'/CORE/IMAGES/apps/')]"}
            verify.IDChildren << "./..${img}"
        }
        if(params."App Type"){verify.IDChildren << "./../../../../TD[2][.='${params."App Type"}']"}
        if(params."Status"){verify.IDChildren << "./../../../../TD[3][.='${params."Status"}']"}
        if(params."Submissions with Impact"){verify.IDChildren << "./../../../../TD[4][.='${params."Submissions with Impact"}']"}
        if(params."Total Projected Benefits"){verify.IDChildren << "./../../../../TD[5][.='${params."Total Projected Benefits"}']"}
        if(params."Total Actual Benefits"){verify.IDChildren << "./../../../../TD[6][.='${params."Total Actual Benefits"}']"}
        if(params."Total Target Benefits"){verify.IDChildren << "./../../../../TD[7][.='${params."Total Target Benefits"}']"}
        if(params."Total Projected Costs"){verify.IDChildren << "./../../../../TD[8][.='${params."Total Projected Costs"}']"}
        if(params."Total Actual Costs"){verify.IDChildren << "./../../../../TD[9][.='${params."Total Actual Costs"}']"}

        if(params."Row Number"){
            def rowNum = GridCommon.RowNumberForValues(verify).toString()
            assert rowNum==params."Row Number","Error - Expected value to be in Row Number ${params."Row Number"} but actual Row is ${rowNum}"
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        }
    }
}
