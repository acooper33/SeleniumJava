package actions.ViewIdea.TeamWorkspace;

import actions.common.TeamWorkspaceCommon
import actions.selenium.Exists
import actions.selenium.GetText



class VerifySimpleBusinesModelinTeamWorkspace{
    public void run(def params){
        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}
        
        if(params."Market/Demand Value"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Market/Demand']/following-sibling::DIV[@id='question-answer']/DIV")
            println("Getting text...")
            println(GetText.run(ID:"//DIV[@class='question-name' and text()='Market/Demand']/following-sibling::DIV[@id='question-answer']/DIV"))
            assert text.equals(params."Market/Demand Value"), "Error - Market/Demand Value is not what expected"
            //assert Exists.run(ID:"//DIV[@class='question-name' and text()='Market/Demand']/following-sibling::DIV[@id='question-answer']/DIV[text()='${params."Market/Demand Value"}']")>0, "Error - Market/Demand Value is not what expected"
        }
        if(params."Product/Tech Value"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Product/Tech']/following-sibling::DIV[@id='question-answer']/DIV")
            assert text.equals(params."Product/Tech Value"), "Error - Product/Tech Value is not what expected"
            //assert Exists.run(ID:"//DIV[@class='question-name' and text()='Product/Tech']/following-sibling::DIV[@id='question-answer']/DIV[text()='${params."Product/Tech Value"}']")>0, "Error - Product/Tech Value is not what expected"
        }
    }
}