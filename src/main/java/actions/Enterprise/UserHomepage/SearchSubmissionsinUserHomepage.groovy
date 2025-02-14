package actions.Enterprise.UserHomepage;

import actions.selenium.SendKeys
import actions.selenium.Click

class SearchSubmissionsinUserHomepage{
    public void run(def params){
       
        if(params."Search Text"){
            SendKeys.run(ID:"//input[@id='filter-search']", Text:params."Search Text")
            sleep(3000)
        }
        if(params."Clear Search"==true){
            Click.run(ID:"//*[@data-tooltip-id='fractal-input-clear']/I")
            sleep(3000)
        }
    }
}