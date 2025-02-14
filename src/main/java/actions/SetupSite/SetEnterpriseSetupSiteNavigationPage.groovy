package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.Exists
import actions.selenium.SelectItem

class SetEnterpriseSetupSiteNavigationPage{
    public void run(def params){

        if(Exists.run(ID:"//*[@class='bi-css-btn setup-secondary-btn' and contains(text(),'Add a Navigation Item')]")==0){
            SetupCommon.NavigateTab(Tab:"Site",Section:"Navigation")}
        def path
        if(params."Add Edit or Delete Navigation Item" == "Add"){
            path = "/LI[last()]"
            Click.run(ID:"//*[@class='bi-css-btn setup-secondary-btn' and contains(text(),'Add a Navigation Item')]")
        }
        else{path = "//LABEL[text()='${params."Title"}']/../.."}

        if(params."Title" && params."Add Edit or Delete Navigation Item" == "Add"){
            SetText.run(ID:"//*[@id='navigation_list']/LI[last()]//INPUT[contains(@id,'nav_title')]",Text:params."Title")
        }
        if(params."Link"){
            Click.run(ID:"//*[@id='navigation_list']${path}//DIV[contains(@style,'display:inline')]/A") 
            Click.run(ID:"//*[@id='admin_predefined_nav_url']/UL/LI[contains(@onclick,'${params."Link"}')]")
        }
        SetCheckBox.run(ID:"//*[@id='navigation_list']${path}//INPUT[contains(@id,'nav_new_window')]",Check:params."New Window")
        if(params."Permission"){
            SelectItem.run(ID:"//*[@id='navigation_list']${path}//SELECT[contains(@id,'nav_permission')]","Visible Text":params."Permission")
        }
        if(params."New Title"){
            SetText.run(ID:"//*[@id='navigation_list']//LABEL[text()='${params."Title"}']/../INPUT[contains(@id,'nav_title')]",Text:params."New Title")
        }
        if(params."Add Edit or Delete Navigation Item" == "Delete") {
            Click.run(ID:"//*[@id='navigation_list']${path}//IMG[contains(@id,'delete')]") 
            Click.run(ID:"//*[@id='gen_mess_message']//INPUT[@value='${params."Delete Action"}']")   
        }
        Click.run(ID:"//*[@id='save_button']") 
    }
}