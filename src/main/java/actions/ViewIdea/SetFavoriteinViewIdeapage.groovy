package actions.ViewIdea;

import actions.selenium.Click
import actions.selenium.Exists

class SetFavoriteinViewIdeapage{
    public void run(def params){
        if(params.Favorite){
            if (Exists.run(ID:"//*[@tooltip-text='Add Idea to Favorites']",Timeout:5)==1){
                Click.run(ID:"//*[@tooltip-text='Add Idea to Favorites']")
            }
        }
        else{
            if (Exists.run(ID:"//*[@tooltip-text='Remove Idea from Favorites']",Timeout:5)==1){
                Click.run(ID:"//*[@tooltip-text='Remove Idea from Favorites']")
            }
        }
        sleep(2000)
    }
}