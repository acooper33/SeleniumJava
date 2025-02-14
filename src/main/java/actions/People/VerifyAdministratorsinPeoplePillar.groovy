package actions.People;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.common.PeopleCommon
import actions.selenium.Exists

class VerifyAdministratorsinPeoplePillar{
    public void run(def params){

        PeopleCommon.NavigateTab(Tab:"Administrators")
        if(params."Administrators Count"){
            assert Exists.run(ID:"//*[@class='administrators-current']/*[contains(.,'${params."Administrators Count"}')]")==1,"Error - Incorrect administrators count"
        }
        def verify = [:]
        verify.ID= "//*[@class='administrators-current']//*[@class='admin-item']/*[text()='${params."Administrator Screen Name"}']"        
        verify.IDChildren = []
        if(params."Administrator Type"){verify.IDChildren << "./..//*[@class='admin-right-column']//*[text()='${params."Administrator Type"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}