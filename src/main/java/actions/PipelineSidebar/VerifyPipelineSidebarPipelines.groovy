package actions.PipelineSidebar;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyPipelineSidebarPipelines{
    public void run(def params){
        if(params."Pipeline Sidebar Tab"){
            if(params."Pipeline Sidebar Tab"=="Favorite"){Click.run(ID:"//*[@id='filter-favorites']")}
            else{Click.run(ID:"//*[@id='sidebar-filter-wrapper']/DIV[text()='${params."Pipeline Sidebar Tab"}']")}
            sleep(1000)
        }
        
        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify."Is Displayed"=true
        verify.ID = "//*[@id='sidebar-pipelines']//DIV[text()='${params."Pipeline or Folder Name"}']"
        
        if(params."Placement Number"){
            params."Number of Matches"=1
            verify.ID = "(//*[@id='sidebar-pipelines']//LI[contains(@class,'sidebar-content-')])[${params."Placement Number"}]//DIV[text()='${params."Pipeline or Folder Name"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}