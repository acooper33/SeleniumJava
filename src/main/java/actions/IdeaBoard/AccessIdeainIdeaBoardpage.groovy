package actions.IdeaBoard;

import actions.selenium.Click

class AccessIdeainIdeaBoardpage{
    public void run(def params){
        //Map all values that will be used for access of that instance
        def set = [:]
        //set.ID= "//*[@class='idea-title' and text()='${params."Idea Name"}']"  
        set.ID= "//*[contains(@class,'title') and text()='${params."Idea Name"}']"   
        set.IDChildren = []
        if(params."Status"){set.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//*[text()='${params."Status"}']"}
        if(params."Username"){set.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//*[text()='${params."Username"}']"}
        if(params."Description"){set.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//*[text()='${params."Description"}']"}        
        if(params."Votes"){set.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//SPAN[@my-vote='${params."Votes"}']"}
        if(params."Comments"){set.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//DIV[@class='board-idea-comment-count']/SPAN[text()='${params."Comments"}']"}
        if(params."Favorite"!=null){
            def fav
            if(params."Favorite"){fav = "//DIV[@class='board-idea-fav is-favorite']"}
            else{fav = "//DIV[@class='board-idea-fav']"}
            set.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV${fav}"
        }
        if(params."Instance"){set."Instance"=params."Instance".toInteger()}
        Click.run(set) 
    }
}