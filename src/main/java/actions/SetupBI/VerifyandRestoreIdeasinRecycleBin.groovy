package actions.SetupBI;

import actions.selenium.Click
import actions.common.SetupCommon
import actions.selenium.utils.VerifyNumberOfMatches

class VerifyandRestoreIdeasinRecycleBin{
    public void run(def params){
        
        if(params."Navigate to Recycle Bin Tab"==true){
            SetupCommon.NavigateTab(Tab:"BI Only",Section:"Recycle Bin")
        }
        def verify = [:]
        verify.ID = "//*[@id='recycleTable']//*[contains(@class,'title')]/*[text()='${params."Title"}']"
        verify.IDChildren = []
        if(params."Date Deleted"){verify.IDChildren << "./../..//*[contains(@id,'cell-0')]/*[text()='${params."Date Deleted"}']"}
        if(params."Submitter"){verify.IDChildren << "./../..//*[contains(@id,'cell-2')]/*[text()='${params."Submitter"}']"}
        if(params."Code"){verify.IDChildren << "./../..//*[contains(@id,'cell-3')]/*[text()='${params."Code"}']"}
        if(params."Deleted By"){verify.IDChildren << "./../..//*[contains(@id,'cell-4')]/*[text()='${params."Deleted By"}']"}
        if(params."Action"){verify.IDChildren << "./../..//*[contains(@id,'cell-5')]/*[text()='${params."Action"}']"}
        if(params."Placement Number") {
            verify.ID="//*[@id='recycleTable']/DIV/DIV[${params."Placement Number"}]//*[contains(@class,'title')]/*[text()='${params."Title"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
        if(params."Click on Restore"==true){
            Click.run(ID:"//*[@id='recycleTable']//*[contains(@class,'title')]/*[text()='${params."Title"}']/../..//*[contains(@class,'fractal-table-cell f-restore-btn')]","Type of Click":"Move to Element")
        }
    }
}