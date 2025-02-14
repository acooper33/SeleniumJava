package actions.SetupEnterpriseWebStorms;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SelectItem
import actions.selenium.Exists
import actions.selenium.ExplicitWait

class CreateWebStormfromEnterpriseSetuppage{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Initiatives",Section:"Create Initiative")

        SetText.run(ID:"//*[@id='webstorm_name']",Text:params."WebStorm Name")
        if(params."Sponsor"){
            params."Sponsor".split(",").eachWithIndex{ name, x ->
                SetText.run(ID:"//*[@id='webstorm_sponsor']",Text:name)
                sleep(2000)
                Click.run(ID:"//*[@id='ent-email-list-nano-wrapper']//*[starts-with(text(),'${name}')]")
            }
        }
        SetText.run(ID:"//*[@id='webstorm_description']",Text:params."Topic")
        if(params."Access Group"){
            params."Access Group".split(",").eachWithIndex{ name, x ->
                SetText.run(ID:"//*[@id='access-group-input']",Text:name)
                sleep(2000)
                Click.run(ID:"//*[@id='ent-user-group-list-nano-wrapper']//*[starts-with(text(),'${name}')]")
            }
        }
        SelectItem.run(ID:"//*[@id='current-host-id']","Visible Text":params."URL")
        SetText.run(ID:"//*[@id='vanity_url']",Text:params."URL2")
        SelectItem.run(ID:"//*[@id='webstorm-template-id']","Visible Text":params."Template")
        //SetCheckBox.run(ID:"//*[@id='webstorm-schedule-checkbox']",Check:params."")
        if(params."Pipeline"){
            if(params."Pipeline"=="Copy the existing Pipeline with this WebStorm"){Click.run(ID:"//*[@id='create-ws-content']/DIV[8]/DIV[2]/DIV[1]/LABEL[1]/INPUT[1]")}
            else{Click.run(ID:"//*[@id='create-ws-content']/DIV[8]/DIV[2]/DIV[2]/LABEL[1]/INPUT[1]")}
        }

        Click.run(ID:"//*[@id='create-ws-btn']")
        //sleep(15000)
        ExplicitWait.run(ID:"//*[@id='create-ws-confirmation-wrapper' and contains(@style,'display: block')]")
    }
}