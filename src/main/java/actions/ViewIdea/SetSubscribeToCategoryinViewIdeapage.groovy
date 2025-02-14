package actions.ViewIdea;

import actions.selenium.*

class SetSubscribeToCategoryinViewIdeapage{
    public void run(def params){

        MouseOver.run(ID:"//*[@id='idea-category-title']")
        if (Exists.run(ID:"//*[text()='Subscribe' and @id='category-subscription-fly-btn']",Timeout:5)==1){
            Click.run(ID:"//*[text()='Subscribe' and @id='category-subscription-fly-btn']")
        }
        else if (Exists.run(ID:"//*[text()='Unsubscribe' and @id='category-subscription-fly-btn']",Timeout:5)==1){
            Click.run(ID:"//*[text()='Unsubscribe' and @id='category-subscription-fly-btn']")
        }
    }
}
