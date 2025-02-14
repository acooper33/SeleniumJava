package actions.SetupUsers;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click

class SetWebstormSetupUsersAdministratorspage{
    public static void run(def params){
        SetupCommon.NavigateTab(Tab:"Users",Section:"Administrators")
        
        if(params."WebStorm Sponsor"){
            Click.run(ID:"//*[@title='Edit Sponsor']")
            SetText.run(ID:"//*[@id='sys_sponsor_input_xml']",Text:params."WebStorm Sponsor")
            sleep(2000)
            Click.run(ID:"//*[@id='as_ul']//*[text()='${params."WebStorm Sponsor"}']")
            Click.run(ID:"//*[@id='edit_sps']/DIV[1]/FORM[1]/INPUT[3]")
        }
        if(params."WebStorm Administrators"){
            params."WebStorm Administrators".split(",").eachWithIndex{ name, x ->
                if(params."WebStorm Administrators Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@id='camp_admin_input_xml']",Text:name)
                    sleep(2000)
                    Click.run(ID:"//*[@id='as_ul']//*[text()='${name}']")
                    Click.run(ID:"//*[@id='administrators_content']/DIV[2]/DIV[2]/DIV[4]/FORM[1]/BUTTON[1]")
                }
                else{
                    Click.run(ID:"//*[@id='sb_campaign_admin_list']//*[contains(text(),'${name}')]/..//I[@title='Remove Administrator']")
                    //Click.run(ID:"//*[@id='sb_campaign_admin_list']//*[contains(text(),'${name}')]/..//*[@title='Remove Administrator' and contains(@src,'images/delete_light.png')]")
                }
            }
        }
        if(params."Moderators"){
            params."Moderators".split(",").eachWithIndex{ name, x ->
                if(params."Moderators Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@id='moderator_input_xml']",Text:name)
                    sleep(2000)
                    Click.run(ID:"//*[@id='as_ul']//*[text()='${name}']")
                    Click.run(ID:"//*[@id='administrators_content']/DIV[2]/DIV[3]/DIV[4]/FORM[1]/BUTTON[1]")
                }
                else{
                    //Click.run(ID:"//*[@id='sb_moderator_list']//*[contains(text(),'${name}')]/..//*[@title='Remove Administrator' and contains(@src,'images/delete_light.png')]")
                    Click.run(ID:"//*[@id='sb_moderator_list']//*[contains(text(),'${name}')]/..//I[@title='Remove Administrator']")
                }
            }
        }
          if(params."Analysts"){
            params."Analysts".split(",").eachWithIndex{ name, x ->
                if(params."Analysts Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@id='read_only_admin_input_xml']",Text:name)
                    sleep(2000)
                    Click.run(ID:"//*[@id='as_ul']//SMALL[contains(text(),'${name}')]")
                    Click.run(ID:"//*[@id='administrators_content']/DIV[3]/DIV[4]/FORM/BUTTON[1]")
                }
                else{
                    //Click.run(ID:"//*[@id='read_only_admin_list']//*[contains(text(),'${name}')]/..//*[@title='Remove Administrator' and contains(@src,'images/delete_light.png')]")
                    Click.run(ID:"//*[@id='read_only_admin_list']//*[contains(text(),'${name}')]/..//I[@title='Remove Administrator']")
                }
            }
        }
    }
}