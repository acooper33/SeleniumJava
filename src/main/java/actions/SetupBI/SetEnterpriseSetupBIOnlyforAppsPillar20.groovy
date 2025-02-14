package actions.SetupBI;

import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.common.SetupCommon
import java.lang.Boolean
import java.io.*


class SetEnterpriseSetupBIOnlyforAppsPillar20{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"BI Only",Section:"Apps Pillar")
        if(params.Apps){
            if(params.Visibility){
                params.Apps.eachWithIndex{app, i->
                    if(params.Visibility.split(",")[i]!='skip'){
                        SetCheckBox.run(ID:"//*[contains(@class,'visible-column')]/INPUT[@id='${app}']", Check:Boolean.parseBoolean(params.Visibility.split(",")[i]))
                    }
                }
            }
            if(params.Availability){
                params.Apps.eachWithIndex{app, i->
                    if(params.Availability.split(',')[i]!='skip'){
                        SetCheckBox.run(ID:"//*[contains(@class,'available-column')]/INPUT[@id='${app}']", Check:Boolean.parseBoolean(params.Availability.split(",")[i]))
                    }
                }
            }   
        }
        if(params.Action=='Save'){Click.run(ID:"//*[@id='bi_apps_save_button']")}
    }                                                               
}