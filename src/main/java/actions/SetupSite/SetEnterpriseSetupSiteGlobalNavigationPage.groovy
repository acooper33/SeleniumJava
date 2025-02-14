package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import java.nio.file.Paths
import actions.selenium.SendKeys

class SetEnterpriseSetupSiteGlobalNavigationPage{
    public void run(def params){

        SetupCommon.NavigateTab(Tab:"Site",Section:"Global Navigation")
        sleep(2000)
        SetCheckBox.run(ID:"//*[@id='global-navigation-checkbox']",Check:params."Enable Global Navigation")
        
        if(params."Global Navigation Search"){
            if(params."Global Navigation Search" == "Show Personalized Quick Results with Search"){
                Click.run(ID:"//*[@id='CB_PERSONALIZED_SEARCH_RESULTS']")
            } else if(params."Global Navigation Search" == "Show Recently Viewed Items"){
                Click.run(ID:"//*[@id='CB_RECENTLY_VIEWED_ITEMS']")
            } else {
                Click.run(ID:"//*[@id='CB_ONLY_ALLOW_SEARCH']")
            }
        }

        //MastHead
        SetCheckBox.run(ID:"//*[@id='global-navigation-hide-masthead-checkbox']",Check:params."Hide Masthead")

        //Masthead Background
        if(params."Background Color"){
            SetText.run(ID:"//*[@id='background-color-selection']",Text:params."Background Color")
        }       
        if(params."Text Color"){
            SetText.run(ID:"//*[@id='text-color-selection']",Text:params."Text Color")
        }

        //Masthead Logo
        if(params."Masthead Logo"){
            Click.run(ID:"//input[@name='masthead-logo-option']/../../TD[contains(.,'${params."Masthead Logo"}')]/../TD/INPUT")  
            if(params."Masthead Logo" == "Custom HTML") {
                SetText.run(ID:"//*[@id='masthead-custom-html']",Text:params."Custom HTML Text")
            }
            if(params."Masthead Logo" == "Text") {
                SetText.run(ID:"//*[@id='masthead-text']",Text:params."Enter the text you would like to use as the logo")
            }
            if(params."Masthead Logo" == "Upload Logo") {
                def fileName = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\${params."Logo Image"}"
                //Now send a file to the 'fallback_input' element
                SendKeys.run(ID:"//*[@id='file_upload']",Text:fileName)
                sleep(3000)   
                Click.run(ID:"//*[@id='gn-masthead-upload-logo-btn']") 
            }
        }

        //Global Bar
        SetCheckBox.run(ID:"//*[@id='global-navigation-hide-logo']",Check:params."Global Bar Hide Logo")
        if(params."Global Bar Background Color"){
            SetText.run(ID:"//*[@id='gn-background-color-selection']",Text:params."Global Bar Background Color")
        }
        if(params."Global Bar Icon Color"){
            SetText.run(ID:"//*[@id='gn-icon-color-selection']",Text:params."Global Bar Icon Color")
        }
        if(params."Global Bar Icon Hover Color"){
            SetText.run(ID:"//*[@id='gn-icon-hover-color-selection']",Text:params."Global Bar Icon Hover Color")
        }
        if(params."Global Bar Icon Selected Color"){
            SetText.run(ID:"//*[@id='gn-icon-selected-color-selection']",Text:params."Global Bar Icon Selected Color")
        }
        Click.run(ID:"//*[@id='global_nav_save_button']")  
        sleep(3000)
    }
}