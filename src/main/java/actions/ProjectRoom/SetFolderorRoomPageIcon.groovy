package actions.ProjectRoom;

import actions.selenium.Browser
import org.openqa.selenium.JavascriptExecutor
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import actions.selenium.Click
import actions.selenium.*
import org.openqa.selenium.By

class SetFolderorRoomPageIcon{
    public void run(def params){
        Click.run(ID:"//LI[contains(@class,'f-room-item')]//*[text()='${params."Folder or Room Name"}']/../../..//*[@class='f-nav-item-icon']")
        String shadow = '''return arguments[0].shadowRoot'''
       	def parentElement = Browser.Driver.findElement(By.xpath("//*[contains(@class,'f-rooms-emoji-picker')]/DIV/EM-EMOJI-PICKER"))
		// Execute JavaScript to get the Shadow Root
		JavascriptExecutor executor = (JavascriptExecutor) Browser.Driver
		def shadowRoot = executor.executeScript(shadow, parentElement)
        def innerElement = executor.executeScript('return arguments[0].shadowRoot.querySelector("section:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > button:nth-child(5) > span:nth-child(2) > span:nth-child(1)")',parentElement)
		innerElement.click()  
    }
}