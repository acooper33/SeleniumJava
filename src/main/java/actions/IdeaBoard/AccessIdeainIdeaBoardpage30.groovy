package actions.IdeaBoard;

import actions.selenium.Click

class AccessIdeainIdeaBoardpage30{
    public void run(def params){
        //Map all values that will be used for access of that instance
        def set = [:]
        set.ID= "//*[@class='f-card-title' and text()='${params."Idea Name"}']"        
        set.IDChildren = []        
        if(params."Status"){set.IDChildren << "./../..//*[contains(@class, 'f-status-indicator') and starts-with(text(),'${params."Status"}')]"}
        //If anonymous, then look with title name + anonymous otherwise its just a username
        if(params."Username"){
            if(params."Username".contains("Anonymous")){
                set.IDChildren << "./../..//*[@class='f-card-screenname' and text()='Anonymous: ${params."Username"}']"
            }
            else {set.IDChildren << "./../..//*[@class='f-card-screenname' and text()='${params."Username"}']"}
        }
        
        if(params."Description"){set.IDChildren << "./../../..//*[contains(@class,'f-card-description')]//*[contains(text(),'${params."Description"}')]"}        
        
        if(params."Votes") {set.IDChildren << "./../../..//*[@data-votes='${params."Votes"}']"}
        
        if(params."Comments"){set.IDChildren << "./../../..//*[@data-comments='${params."Comments"}']"}
        
        /*if(params."Description"){set.IDChildren << "./../../../*[@class='f-card-description']/DIV[starts-with(@id,'card-description')]//*[contains(text(),'${params."Description"}')]"}        
        
        if(params."Votes") {set.IDChildren << "./../../../*[@class='f-card-footer']//*[@data-votes='${params."Votes"}']"}
        
        if(params."Comments"){set.IDChildren << "./../../../*[@class='f-card-footer']//*[@data-comments='${params."Comments"}']"}*/
        
        if(params."Favorite" !=null){
            def fav
            if (params."Favorite"){fav="//DIV[@class='f-idea-score-favorite f-is-favorite']/I[@class='fa fa-star']"}
            else{fav= "//DIV[@class='f-idea-score-favorite ']/I[@class='fa fa-star-o']"}
            set.IDChildren << "./../../../*[@class='f-card-footer']${fav}"
        }
        if(params."Instance"){set."Instance"=params."Instance".toInteger()}
        set."Type of Click"="Javascript"
        Click.run(set)
    }
}