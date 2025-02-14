package actions.SetupUsers;

import actions.common.SetupCommon
import actions.selenium.SetText
import actions.selenium.Click

class SetEnterpriseSetupUsersAdministratorspage{
    public static void run(def params){
        SetupCommon.NavigateTab(Tab:"Users",Section:"Administrators")
        
        if(params."Affiliate Sponsor"){
            Click.run(ID:"//*[@title='Edit Sponsor']")
            SetText.run(ID:"//*[@id='sys_sponsor_input_xml']",Text:params."Affiliate Sponsor")
            sleep(2000)
            Click.run(ID:"//*[@id='as_ul']//*[text()='${params."Affiliate Sponsor"}']")
            Click.run(ID:"//*[@id='edit_sps']/DIV[1]/FORM[1]/BUTTON[1]")
        }
        if(params."System Administrators"){
            params."System Administrators".split(",").eachWithIndex{ name, x ->
                if(params."System Administrators Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@id='sys_admin_input_xml']",Text:name)
                    sleep(2000)
                    if(params."User Available"==true || params."User Available"==null){
                    Click.run(ID:"//*[@id='as_ul']//*[text()='${name}']")
                    Click.run(ID:"//*[@id='sys_admins']/DIV[1]/DIV[4]/DIV[1]/FORM[1]/BUTTON[1]") 
                    }
                }
                else{
                    //Click.run(ID:"//*[@id='sb_system_admin_list']//*[contains(text(),'${name}')]/..//*[@title='Remove Administrator' and contains(@src,'images/delete_light.png')]")
                    Click.run(ID:"//*[@id='sb_system_admin_list']//*[contains(text(),'${name}')]/..//I[@title='Remove Administrator']")
                }
            }
        }
    }
}