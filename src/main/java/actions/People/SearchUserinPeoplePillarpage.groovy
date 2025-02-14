package actions.People;

import actions.selenium.*
    
class SearchUserinPeoplePillarpage{
    public void run(def params){
       
        if(params."Search Value"){
            SetText.run(ID:"//*[@id='user-search-container']//input",Text:params."Search Value")
            sleep(5000)
        }
        if(params."Clear Search"==true){
            Click.run(ID:"//*[@id='user-search-container']//A")
            sleep(5000)
        }
    }
}