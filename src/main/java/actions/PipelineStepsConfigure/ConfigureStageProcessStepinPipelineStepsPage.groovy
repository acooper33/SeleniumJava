package actions.PipelineStepsConfigure;

import actions.selenium.Click
import actions.selenium.SetFocus
import actions.selenium.SetText
import actions.selenium.Exists
import actions.selenium.SetCheckBox
import actions.PipelineStepsView.SetStepDropdown
import actions.common.AppsCommon
import actions.common.ConfigureStepModalCommon
import actions.selenium.SetReactTags


class ConfigureStageProcessStepinPipelineStepsPage{
    public void run(def params){
        def parentXpath = ""
        if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Stage")
        }
        sleep(5000)

        
        if(Exists.run(ID:"//*[@id='f-action-assignment']/DIV[contains(@class,'f-dropdown-btn') and not(contains(@class,'f-dropdown-disabled'))]")>0){
           ConfigureStepModalCommon.ConfigureAssignmentMethodInStepModal("Assignment Method":params."Assignment Method") 
        }
        if(params."Assignment Method"=="Category Assignment"){
            //will iterate through each category set up for Stage Lead
            if(params."Stage Lead"){
                params."Stage Lead Category".split(",").eachWithIndex{ category, x ->
            		parentXpath = "//*[@class='f-category-name' and contains(.,'${category}')]/.."
                	//set Stage lead dropdown
                	Click.run(ID:"${parentXpath}//*[contains(@class,'fractal-dropdown f-dev-lead')]")
                	Click.run(ID:"${parentXpath}//*[contains(@class,'fractal-dropdown f-dev-lead')]//LI//*[text()='${params."Stage Lead".split(',')[x]}']/..")
                	//set Team Lead if selected user
                	if(params."Stage Lead".split(',')[x]=="Select a user"){
                		SetReactTags.setMemberTagsWithAddRemoveWithCustomxPath("User":params."Selected user".split(",")[x], "Add or Remove":params."Selected Users Add or Remove".split(',')[x], "Custom xpath":"${parentXpath}//*[contains(@class,'f-dev-lead-typeahead')]")
                    }
            	}
            }
            //will iterate through each category set up for Stage Team
            if(params."Stage Team"){
                params."Stage Team Category".split(",").eachWithIndex{ category, x ->
            		parentXpath = "//*[@class='f-category-name' and contains(.,'${category}')]/..//*[contains(@class,'f-dev-team')]"
                	//set Stage Team
                	SetReactTags.setMemberTagsWithAddRemoveWithCustomxPath("User":params."Stage Team".split(",")[x], "Add or Remove":params."Stage Team Add or Remove".split(",")[x], "Custom xpath":parentXpath)
               }
            }
        }
        else if(params."Assignment Method"=="Individual Assignment"){
            if(params."Stage Lead"){
                //set Stage lead dropdown
                Click.run(ID:"${parentXpath}//*[contains(@class,'fractal-dropdown f-dev-lead')]")
            	Click.run(ID:"${parentXpath}//*[contains(@class,'fractal-dropdown f-dev-lead')]//LI//*[text()='${params."Stage Lead"}']/..")
                if(params."Stage Lead"=="Select a user"){
                    if(params."Selected user"){
                        params."Selected user".split(",").eachWithIndex{name, x->
                    		SetReactTags.setMemberTagsWithAddRemoveWithCustomxPath("User":params."Selected user".split(",")[x], "Add or Remove":params."Selected Users Add or Remove".split(',')[x], "Custom xpath":"${parentXpath}//*[contains(@class,'f-dev-lead-typeahead')]")
                    	}
                    }
                }
            }
            //set Stage Team
            if(params."Stage Team"){
                params."Stage Team Add or Remove".split(",").eachWithIndex{name, x->
                	SetReactTags.setMemberTagsWithAddRemoveWithCustomxPath("User":params."Stage Team".split(",")[x], "Add or Remove":params."Stage Team Add or Remove".split(",")[x], "Custom xpath":"${parentXpath}//*[contains(@class,'f-dev-team')]") 
                }
            } 
		}
        Click.run(ID:"//*[contains(@class,'f-settings-btn')]")
        ConfigureStepModalCommon.ConfigureProjectRoomTemplateAndFolderMapping("Project Room Template":params."Project Room Template","Folder mapping":params."Folder mapping","Folder Mapping Placement Number":params."Folder Mapping Placement Number")       
        ConfigureStepModalCommon.ConfigureAdditionalActionItemItemsStepModal("Allow Assignees to Edit Idea Attributes":params."Idea Editing","Switch to static date":params."Switch to static date","Due Date":params."Due Date")       
        ConfigureStepModalCommon.ConfigureNotificationItemsInStepModal("Email Alert":params."Email Alert","Send Alerts":params."Send Alerts","Subject":params."Subject","Email":params."Email")
        ConfigureStepModalCommon.ConfigureResultsAndRulesItemsInStepModal("Cancel Open Action Item":params."Cancel Open Action Item")
 		ConfigureStepModalCommon.ConfigureActionsInStepModal("Action":params."Action")
    }
}