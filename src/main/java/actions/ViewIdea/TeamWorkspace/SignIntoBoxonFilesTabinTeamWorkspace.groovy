package actions.ViewIdea.TeamWorkspace;

import actions.selenium.DragAndDrop
import actions.common.TeamWorkspaceCommon
import actions.selenium.SwitchWindow
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SwitchToFrame
import actions.selenium.Browser
import actions.selenium.SendKeys
import org.openqa.selenium.WebElement
import org.openqa.selenium.By;

class SignIntoBoxonFilesTabinTeamWorkspace{
    public void run(def params){
        if(params."Verify in Which Tab (optional)"){TeamWorkspaceCommon.NavigateTab(Tab:params."Verify in Which Tab (optional)")}
        sleep(3000)
        if(params."Sign In to Box Account Required"==true){
            String parentWinHandle = Browser.Driver.getWindowHandle() //need for switching back
            String frameHandles = Browser.Driver.getWindowHandles();
            println("Handles: ${frameHandles}")
            WebElement iframeElementOuter = Browser.Driver.findElement(By.id("f-boxIframe"));
			Browser.Driver.switchTo().frame(iframeElementOuter);
            WebElement iframeElementInner = Browser.Driver.findElement(By.id("box_embed"));
           	Browser.Driver.switchTo().frame(iframeElementInner);
            Click.run(ID:"*//button[contains(@data-testid,'EmbedLoginAccountSignIn-button')]")
			Browser.Driver.getWindowHandles()
            for (String winHandle : Browser.Driver.getWindowHandles()){
                Browser.Driver.switchTo().window(winHandle)
                if (Browser.Driver.getTitle().contains("Box | Login")) {break}
            }
            if(params."Box Account Email" && params."Box Account Password"){
                Click.run(ID:"//A[contains(text(),'Not a part of Brightidea')]")
                sleep(2000)
            }
            Browser.Driver.switchTo().window(parentWinHandle)
      }
    }
}