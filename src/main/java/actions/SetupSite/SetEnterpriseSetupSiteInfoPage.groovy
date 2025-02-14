package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.*
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements

class SetEnterpriseSetupSiteInfoPage{
    public String run(def params){
        SetupCommon.NavigateTab(Tab:"Site",Section:params."Info")

        SetText.run(ID:"//*[@id='affiliate_name']",Text:params."Affiliate Name")
        WebElement element = Elements.find(ID:"//*[@id='domain_name_container']/DIV[1]/INPUT",Browser.Driver)
        def existingDomain = element.getAttribute("value").toString()
        def newDomain = "test"+System.currentTimeMillis().toString()+existingDomain.toString()
        if(params."Add New Domain Name"==true){
            Click.run(ID:"//*[@id='add_host_name']")
            SetText.run(ID:"//*[@id='domain_name_container']/DIV[2]/INPUT[1]",Text:newDomain)
            sleep(2000)
        }
        Click.run(ID:"//*[@id='site_info_save_button']")
        sleep(1000)
        return newDomain
    }
}