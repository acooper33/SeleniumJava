package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyandAccessEnterpriseCampaignList{
    public void run(def params){
        def title
        if(params."Widget"=='Campaign List'){title = "//*[contains(@class,'widget_container enterprise_campaign_list_widget widget_container_editing')]"}
        else{title = "//*[contains(@class,'widget_container enterprise_campaign_list_widget_wide_widget widget_container_editing')]"}
        def verify = [:]
        verify.ID = "${title}//A[contains(text(),'${params."Campaign name"}')]"
        verify.IDChildren = []
        if(params."Campaign Description"){
            if(params."Widget"=='Campaign List'){
                verify.IDChildren << "./../../*[contains(.,'${params."Campaign Description"}')]"
            }else{verify.IDChildren << "./../../../*[contains(.,'${params."Campaign Description"}')]"}
        }
        if(params."Idea Count"){verify.IDChildren << "./../../*[contains(.,'(${params."Idea Count"})')]"}   
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)    
        if(params."Access View/Post"){
            Click.run(ID:"//*[contains(@class,'widget_container enterprise_campaign_list_widget_wide_widget widget_container_editing')]//A[contains(text(),'${params."Campaign name"}')]/../../*[@id='ent_challengebtns']//A[text()='${params."Access View/Post"}']")
        }
         if(params."Access Campaign"==true){
            Click.run(ID:"${title}//A[contains(text(),'${params."Campaign name"}')]")
        }
    }
}
