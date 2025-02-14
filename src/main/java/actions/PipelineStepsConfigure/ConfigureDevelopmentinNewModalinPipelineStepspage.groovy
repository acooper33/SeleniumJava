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
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import actions.selenium.WaitForElement


class ConfigureDevelopmentinNewModalinPipelineStepspage{
    public void run(def params){
        def parentXpath = ""
        if(params."Step Name to Configure (optional)"){
            SetStepDropdown.setDropdownOption("Step Name":params."Step Name to Configure (optional)","Step Dropdown Option":"Configure Development")
        }
        sleep(5000)
        
        /*List <WebElement> elems = Elements.findAll(ID:"//*[@id='f-action-assignment']/DIV[contains(@class,'f-dropdown-btn')]",Browser.Driver)
        println("Found ${elems.size()}")
        elems.each{ elem ->
            println("Dropdown text: ${elem.getText()}")
            println("Dropdown class: ${elem.getAttribute('class')}")
        }*/
        WaitForElement.run(ID:"//*[@id='f-action-assignment']/DIV[contains(@class,'f-dropdown-btn')]", "Timeout In Seconds":"15")
        if(Exists.run(ID:"//*[@id='f-action-assignment']/DIV[contains(@class,'f-dropdown-btn') and not(contains(@class,'f-dropdown-disabled'))]")>0){
           println("In dev step config. dropdown is not disabled")
           ConfigureStepModalCommon.ConfigureAssignmentMethodInStepModal("Assignment Method":params."Assignment Method") 
        }
        if(params."Assignment Method"=="Category Assignment"){
            //will iterate through each category set up for Dev Lead
            if(params."Development Lead"){
                params."Development Lead Category".split(",").eachWithIndex{ category, x ->
            		parentXpath = "//*[@class='f-category-name' and contains(.,'${category}')]/.."
                	//set Dev lead dropdown
                	Click.run(ID:"${parentXpath}//*[contains(@class,'fractal-dropdown f-dev-lead')]")
                	Click.run(ID:"${parentXpath}//*[contains(@class,'fractal-dropdown f-dev-lead')]//LI//*[text()='${params."Development Lead".split(',')[x]}']/..")
                	//set Team Lead if selected user
                	if(params."Development Lead".split(',')[x]=="Select a user"){
                		SetReactTags.setMemberTagsWithAddRemoveWithCustomxPath("User":params."Selected user".split(",")[x], "Add or Remove":params."Selected Users Add or Remove".split(',')[x], "Custom xpath":"${parentXpath}//*[contains(@class,'f-dev-lead-typeahead')]")
                    }
            	}
            }
            //will iterate through each category set up for Dev Team
            if(params."Development Team"){
                params."Development Team Category".split(",").eachWithIndex{ category, x ->
            		parentXpath = "//*[@class='f-category-name' and contains(.,'${category}')]/..//*[contains(@class,'f-dev-team')]"
                	//set Dev Team
                	SetReactTags.setMemberTagsWithAddRemoveWithCustomxPath("User":params."Development Team".split(",")[x], "Add or Remove":params."Development Team Add or Remove".split(",")[x], "Custom xpath":parentXpath)
               }
            }
        }
        else if(params."Assignment Method"=="Individual Assignment"){
            if(params."Development Lead"){
                //set Dev lead dropdown
                Click.run(ID:"${parentXpath}//*[contains(@class,'fractal-dropdown f-dev-lead')]")
            	Click.run(ID:"${parentXpath}//*[contains(@class,'fractal-dropdown f-dev-lead')]//LI//*[text()='${params."Development Lead"}']/..")
                if(params."Development Lead"=="Select a user"){
                    if(params."Selected user"){
                        params."Selected user".split(",").eachWithIndex{name, x->
                    		SetReactTags.setMemberTagsWithAddRemoveWithCustomxPath("User":params."Selected user".split(",")[x], "Add or Remove":params."Selected Users Add or Remove".split(',')[x], "Custom xpath":"${parentXpath}//*[contains(@class,'f-dev-lead-typeahead')]")
                    	}
                    }
                }
            }
            //set Dev Team
            if(params."Development Team"){
                params."Development Team Add or Remove".split(",").eachWithIndex{name, x->
                	SetReactTags.setMemberTagsWithAddRemoveWithCustomxPath("User":params."Development Team".split(",")[x], "Add or Remove":params."Development Team Add or Remove".split(",")[x], "Custom xpath":parentXpath) 
                }
            } 
		}
        Click.run(ID:"//*[contains(@class,'f-settings-btn')]")
        ConfigureStepModalCommon.ConfigureAdditionalActionItemItemsStepModal("Allow Assignees to Edit Idea Attributes":params."Idea Editing","Switch to static date":params."Switch to static date","Due Date":params."Due Date")
        if(params."Allow action item assignees to view Private Comments" == false){
        	Click.run(ID:"//*[@id='f-private-comments']/..")  //is selected is not recognized, cant use SetCheckbox action
        }
         if(params."Development Field"){
            params."Development Field".split(",").eachWithIndex{ name, x ->
                if(params."Development Field Included or Required".split(",")[x]=="Included"){
                    sleep(1000)
                    Click.run(ID:"//*[contains(@class,'f-quest-row')]//*[text()='${name}']/..//INPUT[contains(@id,'inc')]/..")
                    sleep(1000)
                }
                else{
                    sleep(1000)
                    Click.run(ID:"//*[contains(@class,'f-quest-row')]//*[text()='${name}']/..//INPUT[contains(@id,'req')]/..")
                    sleep(500)
                }
            }
        }
        ConfigureStepModalCommon.ConfigureNotificationItemsInStepModal("Email Alert":params."Email Alert","Send Alerts":params."Send Alerts","Subject":params."Subject","Email":params."Email")
        ConfigureStepModalCommon.ConfigureResultsAndRulesItemsInStepModal("Cancel Open Action Item":params."Cancel Open Action Item","Resend action items when submissions return to Step":params."Resend action items when submissions return to Step")
 		ConfigureStepModalCommon.ConfigureActionsInStepModal("Action":params."Action")
    }
}