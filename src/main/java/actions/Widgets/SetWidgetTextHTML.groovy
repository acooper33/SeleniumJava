package actions.Widgets;

import actions.selenium.*

class SetWidgetTextHTML{
    public void run(def params){
        if(!params."Instance"){params."Instance"="1"}
        Click.run(ID:"(//*[contains(@class,' texthtml_widget ')]//A[@class='widget_edit_icon'])[${params."Instance"}]","Type of Click":"Javascript")
        SetText.run(ID:"//*[contains(@class,' texthtml_widget ')]//TEXTAREA[contains(@id,'_body_edit')]",Text:params."Text")
        Click.run(ID:"(//*[contains(@class,' texthtml_widget ')]//A[@class='widget_edit_icon'])[${params."Instance"}]","Type of Click":"Javascript")
        sleep(1000)
    }
}