package actions.IdeaBoard;

import actions.selenium.Click
import actions.selenium.SendKeys
//import actions.selenium.SetText

class SearchIdeainIdeaBoards30{
    public void run(def params){
        if(params."Search Value"){
            SendKeys.run(ID:"//input[contains(@class,'filter-search-input')]", Text:params."Search Value")
            sleep(5000)
        }
        if(params."Clear Search"==true){
            Click.run(ID:"//*[@data-tooltip-id='fractal-input-clear']/I")
            sleep(3000)
        }
        
    }
}