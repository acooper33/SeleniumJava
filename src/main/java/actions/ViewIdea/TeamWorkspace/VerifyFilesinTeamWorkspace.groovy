package actions.ViewIdea.TeamWorkspace;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.utils.Elements
import actions.common.TeamWorkspaceCommon
import actions.selenium.GetText
import actions.selenium.SwitchToFrame
import actions.selenium.SwitchToDefaultContent
import actions.selenium.Browser
//import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class VerifyFilesinTeamWorkspace{
    public void run(def params){
        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}
        def verify = [:]
        verify.IDChildren = []
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        if(params."Integrated with Box"){
        	SwitchToFrame.run(Name:"boxIframe")
            //Selenium with xPath would not work - dont know why
            def elem = Elements.findAll(ID:"//div[@class='file-list-name']/DIV[@class='item-name']/A", Browser.Driver )
            assert elem.size()>0, "Error - No Attachments Found"
            def count=0
            elem.each{ el -> 
                if(el.getText().trim().equals(params."Attachment Name")){count++}
            }
            assert count==verify."Number of Matches", "Error - Expected number of matches ${verify."Number of Matches"} not found, actual amount found is ${count}. "
            //verify.ID = "//div[@class='file-list-name']/DIV[@class='item-name']/A[contains(text(),'${params."Attachment Name"}')]"
            SwitchToDefaultContent.run()
		}
        //if not integrated with Box
        else{
           	verify.ID = "//*[contains(@class,'fractal-file')]//A[contains(@class,'filename')and text()='${params."Attachment Name"}']"
            if(params."Attachment Icon"){
                if(params."Attachment Icon"=="png" ||  params."Attachment Icon"=="gif" || params."Attachment Icon"=="jpg" || params."Attachment Icon"=="jpeg"){
                    verify.IDChildren << "./../..//*[contains(@class,'f-image-preview')]//*[contains(@style,'background-image: url')]"
                   } else {
                       verify.IDChildren << "./../..//*[contains(@class,'f-image-preview')]//*[text()='${params."Attachment Icon"}']"
                }
            }
        	verify.IDChildren << "./../..//I[contains(@class,'trash remove')]"
            VerifyNumberOfMatches.run(verify)
        }
    }
}