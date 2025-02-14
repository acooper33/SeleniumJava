package actions.IdeaBoard;

import actions.selenium.Click
import actions.selenium.SendKeys

class SearchIdeaBIW{
    public void run(def params){
        if(params."Search Value"){
            SendKeys.run(ID:"//input[contains(@id,'filter-search')]", Text:params."Search Value")
            sleep(2000)
        }
        if(params."Clear Search"==true){
            Click.run(ID:"//*[@data-for='fractal-input-clear']/I")
            sleep(3000)
        }
    }
}