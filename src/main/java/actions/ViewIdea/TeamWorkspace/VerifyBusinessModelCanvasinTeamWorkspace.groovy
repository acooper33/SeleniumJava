package actions.ViewIdea.TeamWorkspace;

import actions.common.TeamWorkspaceCommon
import actions.selenium.Exists
import actions.selenium.GetText


class VerifyBusinessModelCanvasinTeamWorkspace{
    public void run(def params){
        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}
        if(params."Custom Question Title"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='${params."Custom Question Title"}']/following-sibling::DIV[@id='question-answer']/DIV")
            assert text.equals(params."Custom Question Default Text"), "Error - '${params."Custom Question Title"}' is not what expected"

        }
        if(params."Value Proposition"){
			def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Value Proposition']/following-sibling::DIV[@id='question-answer']/DIV")
			assert text.equals(params."Value Proposition"), "Error - Value Proposition is not what expected"
        }
        if(params."Customer Segment(s)"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Customer Segment(s)']/following-sibling::DIV[@id='question-answer']/DIV")
            assert text.equals(params."Customer Segment(s)"), "Error - Customer Segment(s) is not what expected"
        }
        if(params."Channels"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Channels']/following-sibling::DIV[@id='question-answer']/DIV")
            assert text.equals(params."Channels"), "Error - Channels is not what expected"
        }
        if(params."Customer Relationships"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Customer Relationships']/following-sibling::DIV[@id='question-answer']/DIV")
            assert text.equals(params."Customer Relationships"), "Error - Customer Relationships is not what expected"            
        }
        if(params."Revenue Streams"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Revenue Streams']/following-sibling::DIV[@id='question-answer']/DIV")
            assert text.equals(params."Revenue Streams"), "Error - Revenue Streams is not what expected"
        }        
        if(params."Key Partners"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Key Partners']/following-sibling::DIV[@id='question-answer']/DIV")
            assert text.equals(params."Key Partners"), "Error - Key Partners is not what expected"
        }
        if(params."Key Activities"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Key Activities']/following-sibling::DIV[@id='question-answer']/DIV")
            assert text.equals(params."Key Activities"), "Error - Key Activities is not what expected"
        }
        if(params."Key Resources"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Key Resources']/following-sibling::DIV[@id='question-answer']/DIV")
            assert text.equals(params."Key Resources"), "Error - Key Resources is not what expected"
        }
        if(params."Cost Structure"){
            def text = GetText.run(ID:"//DIV[@class='question-name' and text()='Cost Structure']/following-sibling::DIV[@id='question-answer']/DIV")
            assert text.equals(params."Cost Structure"), "Error - Cost Structure is not what expected"
        }
   	}
}