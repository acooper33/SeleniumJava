package actions.common;

import actions.selenium.*

class TeamWorkspaceCommon{
     public static void NavigateTab(def params){
        //Tab (required) = Milestones,Tasks,Risks
        switch(params.Tab){
            case "Milestones":
            	Click.run(ID:"//*[contains(@href,'milestones')]/div")
           		break
            case "To-dos":
            	Click.run(ID:"//*[contains(@href,'tasks')]/div")
            	break
            case "Business Model":
            	Click.run(ID:"//*[contains(@href,'business-model')]/div")
            	break
            case "Riskiest Assumptions":
            	Click.run(ID:"//*[contains(@href,'riskiest-assumptions')]/div")
            	break
            case "Business Impact":
            	Click.run(ID:"//*[contains(@href,'business-impact')]/div")
            	break
            case "Files":
            	Click.run(ID:"//*[contains(@href,'files')]/div")
            	break
             case "Settings":
            	Click.run(ID:"//*[contains(@href,'settings')]/div")
            	break
        }
    }
}