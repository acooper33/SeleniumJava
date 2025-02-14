package actions.PipelineStepsConfigure;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SelectItem
import actions.selenium.SetFocus
import actions.selenium.*
    
class ConfigureCategoryAssignmentInDevelopmentStep{
    public static void run(def params){

        if(params."Development Lead Category"){
            params."Development Lead Category".split(",").eachWithIndex{ category, x ->  
                def parentXpath = "//*[@class='category-name' and text()='${category}']"
                println("Category: ${category}")
                def developmentLead = params."Development Lead".split(",")  
                SelectItem.run(ID:"${parentXpath}/../..//*[@id='proposal-lead-dropdown']","Visible Text":developmentLead[x])
                if(developmentLead[x] == "Selected user"){
                            def selectedUsers = params."Selected user".split(",")
                            def selectedUsersAddOrRemove = params."Selected Users Add or Remove".split(",")
                            if(selectedUsersAddOrRemove[x] == "Add") {
                            println("Category: ${parentXpath}")
                            MoveToElementAndClick.run(ID:"${parentXpath}/../..//*[@id='lead_typeahead']//*[@id='member_search_input']")
                            SetText.run(ID:"${parentXpath}/../..//*[@id='lead_typeahead']//*[@id='member_search_input']",Text:selectedUsers[x])
                            sleep(2000)
                            Click.run(ID:"//DIV[@class='atwho-view' and contains(@style,'block')]//*[@data-value='${selectedUsers[x]}' or @email='${selectedUsers[x]}']/DIV/DIV")
                        }
                    else if(selectedUsersAddOrRemove[x] == "Remove") {
                            Click.run(ID:"${parentXpath}/../..//*[@id='ownerInput']//*[contains(@data-value,'${selectedUsers[x]}')]/A") 
                        }
                    }
                }
            }
        if(params."Development Team Category"){
            params."Development Team Category".split(",").eachWithIndex{ category, x -> 
                def parentXpath = "//*[@class='category-name' and text()='${category}']"
                def developmentTeamUsers = params."Development Team".split(",")
                def developmentTeamUsersAddOrRemove = params."Development Team Add or Remove".split(",")
                if(developmentTeamUsersAddOrRemove[x] == "Add") {
                    SetFocus.run(ID:"${parentXpath}/../..//*[@id='team_typeahead']//*[@id='member_search_input']")
                    SetText.run(ID:"${parentXpath}/../..//*[@id='team_typeahead']//*[@id='member_search_input']",Text:developmentTeamUsers[x])
                    sleep(2000)
                    Click.run(ID:"//DIV[@class='atwho-view' and contains(@style,'block')]//*[@data-value='${developmentTeamUsers[x]}' or @email='${developmentTeamUsers[x]}']/DIV/DIV")
                }
                else{
                    Click.run(ID:"${parentXpath}/../..//*[@id='teamInput']//*[contains(@data-value,'${developmentTeamUsers[x]}')]/A")                   
                }
            }
        }

    }
}