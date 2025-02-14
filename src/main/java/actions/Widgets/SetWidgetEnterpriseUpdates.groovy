package actions.Widgets;

import actions.selenium.*
    
class SetWidgetEnterpriseUpdates{
    public void run(def params){
        Click.run(ID:"//*[@class='widget_title']//*[text()='Enterprise Updates']/../..//A[@class='widget_edit_icon']","Type of Click":"Javascript")
        sleep(2000)
        SetText.run(ID:"//*[contains(@class,'title_back')]//DIV[contains(.,'Options')]/INPUT",Text:params."Options")
        Click.run(ID:"//INPUT[contains(@id,'title_edit') and @value='Enterprise Updates']/../../..//A[@class='widget_edit_icon']","Type of Click":"Javascript")
    }
}