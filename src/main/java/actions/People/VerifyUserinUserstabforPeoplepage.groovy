package actions.People;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.PeopleCommon
import actions.common.GridCommon

class VerifyUserinUserstabforPeoplepage{
    public void run(def params){
        PeopleCommon.NavigateTab(Tab:"Users")
        
        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.Table = "//*[@id='grid-container']//TABLE[1]"
        
        /*if(params."Email Address".contains("mailinator")){ // remove when BPD-36833 fixed
            params."Email Address" = params."Email Address".replaceAll('_','\\.')
        }*/
        verify.ID= "//TD[3]/A[contains(text(),'${params."Email Address"}')]"        
        verify.IDChildren = []
        if(params."Name"){verify.IDChildren << "./../../TD[1]/*[contains(text(),'${params."Name"}')]"}
        if(params."Screen Name"){verify.IDChildren << "./../../TD[2]/*[contains(text(),'${params."Screen Name"}')]"}
        if(params."Status"){verify.IDChildren << "./../../TD[4]/*[contains(text(),'${params."Status"}')]"}
        if(params."Administrative Roles"){
            if(params."Administrative Roles"=="<EMPTY>"){verify.IDChildren << "./../../TD[5][not(text()) or text()=' ']"}
            else{verify.IDChildren << "./../../TD[5][text()='${params."Administrative Roles"}']"}
        }
        if(params."Job Title"){
            if(params."Job Title"=="<EMPTY>"){verify.IDChildren << "./../../TD[8][not(text()) or text()=' ']"}
            else{verify.IDChildren << "./../../TD[8][contains(text(),'${params."Job Title"}')]"}
        }
        if(params."Registration"){
            verify.IDChildren << "./../../TD[contains(@class,'registration') and text()='${params."Registration"}']"
        }
        if(params."Department"){
            if(params."Department"=="<EMPTY>"){verify.IDChildren << "./../../TD[9][not(text())]"}
            else{verify.IDChildren << "./../../TD[9][contains(text(),'${params."Department"}')]"}
        }
        if(params."Location"){
            if(params."Location"=="<EMPTY>"){verify.IDChildren << "./../../TD[10][not(text())]"}
            else{verify.IDChildren << "./../../TD[10][contains(text(),'${params."Location"}')]"}
        }
        if(params."Group"){
            if(params."Group"=="<EMPTY>"){verify.IDChildren << "./../../TD[contains(@class,'groups') and not(text()) or text()=' ']"}
            else{verify.IDChildren << "./../../TD[contains(@class,'groups') and contains(text(),'${params."Group"}')]"}
        }
        if(params."Expertise"){
            if(params."Expertise"=="<EMPTY>"){verify.IDChildren << "./../../TD[contains(@class,'expertise') and not(text())]"}
            /*else {
                params."Expertise".split(",").each{ expertise ->
                	verify.IDChildren << "./../../TD[contains(@class,'expertise') and contains(text(),'${expertise}')]"
            	}
            }*/
            else verify.IDChildren << "./../../TD[contains(@class,'expertise') and text()='${params."Expertise"}']"
        }
        if(params."Certification"){
            if(params."Certification"=="<EMPTY>"){verify.IDChildren << "./../../TD[contains(@class,'certification') and not(text())]"}
            else {
                params."Certification".split(",").each{ certification ->
                	verify.IDChildren << "./../../TD[contains(@class,'certification') and contains(text(),'${certification}')]"
            	}
            }
            //else{verify.IDChildren << "./../../TD[contains(@class,'certification') and text()='${params."Certification"}']"}
        }
        
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