package actions.Enterprise.UserHomepage;

import actions.selenium.Click

class NavigatetoHighlightsTab{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-tabs']//*[text()='${params."Tab"}']")
    }
}