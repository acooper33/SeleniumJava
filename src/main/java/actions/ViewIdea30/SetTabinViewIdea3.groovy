package actions.ViewIdea30;

import actions.selenium.ExecuteJavascript
import actions.selenium.Click

class SetTabinViewIdea3{
    public static void run(def params){
        
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
        Click.run(ID:"//*[contains(@class, 'f-tabs-container')]//*[starts-with(text(),'${params."Tab"}')]/../..")
        
    }
}