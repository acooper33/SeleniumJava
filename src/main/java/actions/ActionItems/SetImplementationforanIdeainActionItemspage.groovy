package actions.ActionItems;

import actions.selenium.Click

class SetImplementationforanIdeainActionItemspage{
    public void run(def params){
        if(params."Implementation Action"=="Mark Implemented"){
            Click.run(ID:"//*[@id='idea-implement-accept']")
        } else if(params."Implementation Action"=="Mark Not Pursued"){
            Click.run(ID:"//*[@id='idea-implement-decline']")
        } else {Click.run(ID:"//*[@id='idea-implement-return']")}
    }
}