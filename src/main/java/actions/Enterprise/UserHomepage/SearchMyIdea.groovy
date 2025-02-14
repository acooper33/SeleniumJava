package actions.Enterprise.UserHomepage;

import actions.selenium.*
    
class SearchMyIdea{
    public void run(def params){

        if(params."Clear Field"==true){
            Click.run(ID:"//*[@class='fractal-input-clear']/I")
            sleep(3000)
        }
        if(params."Search Field"){
            SetText.run(ID:"//*[@id='category-table-search']",Text:params."Search Field")
            SendKeys.run(ID:"//*[@id='category-table-search']",Key:"ENTER")
            sleep(3000)
        }
    }
}