package actions.Widgets;

import actions.selenium.*

class AccessWidgetUpdatesLink{
    public void run(def params){
        if(!params."Instance"){params."Instance"="1"}
        Click.run(ID:"(//*[@id='ws_updates_area']//A[text()='${params."Link Name"}'])[${params."Instance"}]")
    }
}