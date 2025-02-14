package actions.Widgets;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.Exists


class VerifyWidgetJiraIntegration{
    public void run(def params){
        def txt = "Authenticate your account"
        if(params."Authenticate your account"){
            assert Exists.run(ID:"//*[@id='jira-issues-widget']//A[contains(text(),'${txt}')]")==1, "Error - 'Authenticate your account' doesn't show"
        }else{
            assert Exists.run(ID:"//*[@id='jira-issues-widget']//A[contains(text(),'${txt}')]")==0, "Error - 'Authenticate your account' is displayed"            
        }
        
        def linkedIssues = []
        linkedIssues = Elements.findAll(ID:"//*[@id='jira-issues-widget']//*[contains(@class,'f-jira-linked-issue-list')]/A[contains(@class,'f-jira-linked-issue-link')]", Browser.Driver)
        if(params."Total Number of Issues"){assert linkedIssues.size()==params."Total Number of Items".toInteger(), "Error - total number of issues is ${linkedIssues.size()}"}
        
        if(params."List of Issues to verify"){
            def i = 0
            linkedIssues.each{link ->
                println("Matching ${i}")
                println ("${link.getText()} vs.${params."List of Issues to verify".split(',')[i]}")
                assert link.getText().trim().equals(params."List of Issues to verify".split(',')[i]), "Error - ${link.getText()} does not match ${params."List of Issues to verify".split(',')[i]}"
            }
            
        }
    }
}