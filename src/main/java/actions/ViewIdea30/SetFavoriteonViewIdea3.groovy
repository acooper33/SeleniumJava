package actions.ViewIdea30;

import actions.selenium.Click

class SetFavoriteonViewIdea3{
    public void run(def params){
        
        if(params."Set Favorite" == true){
            Click.run(ID:"//*[@class='f-idea-page-content']//*[contains(@class,'f-idea-favorite') and @data-favorite='false']")
        } else {
            Click.run(ID:"//*[@class='f-idea-page-content']//*[contains(@class,'f-idea-favorite') and @data-favorite='true']")
        }
    }
}