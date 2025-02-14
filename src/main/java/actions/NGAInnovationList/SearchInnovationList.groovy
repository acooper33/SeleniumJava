package actions.NGAInnovationList;

import actions.selenium.*

class SearchInnovationList{
    public void run(def params){

        if(params."Clear Search"==true){
            Click.run(ID:"//*[@id='idea-list-clear-search']")
            sleep(3000)
        }
        if(params."Search Field"){
            SetText.run(ID:"//*[@id='search_holder']/FORM/INPUT",Text:params."Search Field")
            SendKeys.run(ID:"//*[@id='search_holder']/FORM/INPUT",Key:"ENTER")
            sleep(3000)
        }
    }
}