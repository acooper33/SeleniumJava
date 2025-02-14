package actions.ViewIdea.TeamWorkspace;

import actions.selenium.MouseOver
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SendKeys
import actions.selenium.SetFocus
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor

class EditBusinessModelFieldsinTeamWorkspace{
    public void run(def params){
        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}
        if (params."Field to Edit"){
            def i = 1
        	if (params."Field to Edit" == "Customer Segment(s)" || params."Field to Edit" == "Product/Tech") {i = 2}
        	if (params."Field to Edit" == "Channels") {i = 3}
        	if (params."Field to Edit" == "Customer Relationships") {i = 4}
            if (params."Field to Edit" == "Revenue Streams") {i = 5}
            if (params."Field to Edit" == "Key Partners") {i = 6}
            if (params."Field to Edit" == "Key Activities") {i = 7}
            if (params."Field to Edit" == "Key Resources") {i = 8}
            if (params."Field to Edit" == "Cost Structure") {i = 9}
            MouseOver.run(ID:"//DIV[@class='question-name' and text()='${params."Field to Edit"}']")
            Click.run(ID:"(//*[@id='edit-button'])[${i}]", "Type of Click":"Javascript")
            WebElement element = Elements.find(ID:"//DIV[@class='question-name' and text()='${params."Field to Edit"}']/../..//DIV[contains(@class,'redactor-styles redactor-placeholder redactor-in redactor-in')]", Browser.Driver)
            element.sendKeys("${params."Text to Set"}")
            sleep(2000)
            
            if(params."Action"=="Save"){Click.run(ID:"(//*[@id='save-button'])")}
            if(params."Action"=="Cancel"){Click.run(ID:"(//A[@class='cancel-link' and text()='Cancel'])")}
        }
        sleep(3000)
     }
}