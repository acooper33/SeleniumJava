package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SelectItem
import actions.selenium.ExecuteJavascript
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class SetWebstormSetupSiteInfoPage{
    public void run(def params){

        SetupCommon.NavigateTab(Tab:"Site",Section:"Info")
        SetText.run(ID:"//*[@id='webstorm_title']",Text:params."Webstorm Title")
        SetText.run(ID:"//*[@id='webstorm_description']",Text:params."Webstorm Description")
        if(params."Use Default Image" == true){
            Click.run(ID:"//*[@id='campaign_default_image_btn']")
        }
        SelectItem.run(ID:"//*[@id='campaign_host']","Visible Text":params."Vanity URL")
        SetText.run(ID:"//*[@id='campaign_identifier']",Text:params."Campaign Identifier")
        
        WebElement button = Elements.find(ID:"//*[@id='info_save_button']",Browser.Driver)
        
        //ExecuteJavascript.run(Code:"window.scrollTo(0, document.body.scrollHeight)")
        ExecuteJavascript.run(Code:"arguments[0].scrollIntoView(true);", "Arguments":button)

        //Click.run(ID:"//*[@id='info_save_button']")  
        Click.run(ID:"//*[@id='info_save_button']", "Type of Click":"Move to Element") 
        sleep(4000)
        Click.run(ID:"//*[@id='info_save_button']", "Type of Click":"Move to Element") 
    }
}