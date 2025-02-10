package actions.common;

import actions.selenium.Click

class ViewIdea3Common{
    
    public static void DescriptionAction(def params){
        if(params.Action=="Save"){Click.run(ID:"//*[@class='f-edit-textarea-btns']//*[@class='far fa-check']/..")}
        else{Click.run(ID:"//*[@class='f-edit-textarea-btns']//*[@class='far fa-times']/..")}
    }
}
       