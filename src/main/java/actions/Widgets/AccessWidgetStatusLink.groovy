package actions.Widgets;

import actions.selenium.Click

class AccessWidgetStatusLink{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'widget_container status_widget')]//A[text()='${params."Status"}']")
    }
}