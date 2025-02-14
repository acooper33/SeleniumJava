package actions.ViewIdea;

import actions.selenium.Click

class SelectCategoryStatusorTaginViewIdea{
    public void run(def params){
        if(params."Category, Status or Tag"=="Category"){Click.run(ID:"//*[@id='idea-category-title']","Type of Click": "Javascript")}
        else if(params."Category, Status or Tag"=="Status"){Click.run(ID:"//*[@id='idea-status-title']")}
        else if(params."Category, Status or Tag"=="Tag"){Click.run(ID:"//*[@id='idea-tags-container']//a[text()='${params."Tag Name"}']")}
    }
}