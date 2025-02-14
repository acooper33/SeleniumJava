package actions.SetupEnterpriseWebStorms;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SetText
import actions.selenium.SelectItem

class ManageWebstormsfromEnterpriseSetuppage{
    public void run(def params){

        SetupCommon.NavigateTab(Tab:"Initiatives",Section:"Manage Initiatives")

        SetCheckBox.run(ID:"//*[@id='chk_scheduled_camp']",Check:params."Pre-Launch")
        SetCheckBox.run(ID:"//*[@id='chk_active_camp']",Check:params."Active")
        SetCheckBox.run(ID:"//*[@id='chk_closed_camp']",Check:params."Closed")
        SetCheckBox.run(ID:"//*[@id='chk_inactive_camp']",Check:params."Archived")

        SelectItem.run(ID:"//*[@id='camapaigns_list']","Visible Text":params."Webstorms")

        if(params."Go to Webstorm or Delete or Change") {Click.run(ID:"//*[@id='ent_ao_campaign_display']//*[text()='Change']")}

        SelectItem.run(ID:"//*[@id='camapaign_status_list']","Visible Text":params."Webstorm Status")

        if(params."Feedback" == true) {Click.run(ID:"//*[@class='manage-feedback-template-message']/A")}
        if(params."Disable Scheduler" == true) {Click.run(ID:"//*[@class='manage-webstorm-message']/A")}

        if(params."Group"){
            params."Group".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove Group".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@id='ent_groups_search']",Text:name)
                    if(params."Search or All") {Click.run(ID:"//*[@id='ent_ao_campaign_display']//*[text()='${params."Search or All"}']")}
                    Click.run(ID:"//*[@id='all_groups']//OPTION[text()='${name}']")
                    Click.run(ID:"//*[@id='ent_ao_campaign_display']//*[text()='>>']")
                }
                else {Click.run(ID:"//*[@id='campaign_groups']//OPTION[text()='${name}']")
                      Click.run(ID:"//*[@id='ent_ao_campaign_display']//*[text()='Remove Selected']")}
            }
        }

        Click.run(ID:"//*[@id='campaigns_save_button']")
    }
}