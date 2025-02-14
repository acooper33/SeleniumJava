package actions.Search;

import actions.selenium.*

class SearchEnterpriseWebstorm{
    public void run(def params){
        if(params."Remove WebStorm tag"){
            Click.run(ID:"//*[@id='global-search-input']")
            Click.run(ID:"//*[@id='global-search-input-tag']/SPAN")
        }
        SetText.run(ID:"//*[@id='global-search-input']",Text:params."Search Value")
        sleep(4000)
        if(params."Click View All Results after search"){Click.run(ID:"//*[@id='global-search-result-count']")}
    }
}