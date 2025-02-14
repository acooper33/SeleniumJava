package actions.People;

import actions.common.PeopleCommon
import actions.selenium.Click

class SetITManagerinPeoplePillar{
    public void run(def params){
        
        PeopleCommon.NavigateTab(Tab:"Licenses")
        sleep(4000)
        if(params."Expand License Breakdown"== true || params."Expand License Breakdown"== null){
            PeopleCommon.ExpandLicenseBreakdown(License:"Idea Box Manager License Type")
        }        
        if(params."IT Manager"== true){Click.run(ID:"//*[@class='admin-left-column' and text()='${params."User"}']/..//*[@class='f-toggle-input' and @value='false']/..//*[@class='f-toggle-inner']")}
        if(params."IT Manager"== false){Click.run(ID:"//*[@class='admin-left-column' and text()='${params."User"}']/..//*[@class='f-toggle-input' and @value='true']/..//*[@class='f-toggle-inner']")}
    }
}
 