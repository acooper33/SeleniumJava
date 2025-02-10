package actions.PipelineStepsView;

import actions.selenium.*


class SearchPipelineStepsView{
    public void run(def params){
        if(params."Search Value"){
            Click.run(ID:"//*[@id='idea-list-search']//input[@class='search-input']")
            SetText.run(ID:"//*[@id='idea-list-search']//input[@class='search-input']",Text:params."Search Value")
            sleep(5000)
        }
        if(params."Clear Search"==true){
            Click.run(ID:"//*[@id='search-clear-button']")
            sleep(5000)
        }
    }
}