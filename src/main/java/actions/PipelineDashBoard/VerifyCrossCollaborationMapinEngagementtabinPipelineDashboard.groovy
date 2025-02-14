package actions.PipelineDashBoard;

import actions.selenium.Click
import actions.PipelineDashBoard.SetViewByInCrossCollaboration
import actions.selenium.Exists

class VerifyCrossCollaborationMapinEngagementtabinPipelineDashboard{
    public void run(def params){
        
        SetViewByInCrossCollaboration.ViewBy(params."View By")
        sleep(5000)
        Click.run(ID:"//*[contains(@class,'highcharts-tracker')]//*[contains(@class,'highcharts-text-outline') and text()='${params."Location or Department"}']/../..")
        if(params."ToolTip Location or Department"){
            assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip') and contains(@style,'opacity: 1')]//*[@class='collaborator-header collaborator-link-name' and text()='${params."ToolTip Location or Department"}']")==1,"Error - Incorrect Location or Department in ToolTip"
        }
         if(params."ToolTip Collaborator Section Value"){
            assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip') and contains(@style,'opacity: 1')]//*[@class='collaborator-section' and contains(.,'${params."ToolTip Collaborator Section Value"} ${params."ToolTip Collaboration Section Title"}')]")==1,"Error - Incorrect ToolTip Cross-Collaborations for ${params."ToolTip Collaboration Section Title"}"
        }
		if(params."ToolTip Cross-Collaborations"){
            assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip') and contains(@style,'opacity: 1')]//*[@class='collaborator-section' and contains(.,'${params."ToolTip Cross-Collaborations"} Cross-Collaborations')]")==1,"Error - Incorrect ToolTip Cross-Collaborations"
        }
        if(params."Collaborator Link Count"){
            assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip') and contains(@style,'opacity: 1')]//*[@class='collaborator-section collaborator-links' and contains(.,'${params."Collaborator Link Count"} with ${params."Collaborator Link Name"}')]")==1,"Error - Incorrect Collaborator Link Count"
        }
        if(params."ToolTip Cross-Collaborators"){
            assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip') and contains(@style,'opacity: 1')]//*[@class='collaborator-section' and contains(.,'${params."ToolTip Cross-Collaborators"} Cross-Collaborators')]")==1,"Error - Incorrect ToolTip Cross-Collaborators"
        }      
    }
}