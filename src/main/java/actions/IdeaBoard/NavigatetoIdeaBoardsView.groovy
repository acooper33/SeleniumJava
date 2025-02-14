package actions.IdeaBoard;

import actions.selenium.Click

class NavigatetoIdeaBoardsView{
    public void run(def params){
        
        Click.run(ID:"//*[@data-test='f-test-idea-board-dropdown']")
        Click.run(ID:"//*[contains(@class,'f-dropdown-options')]//*[text()='${params."View"}']")
        
    }
}