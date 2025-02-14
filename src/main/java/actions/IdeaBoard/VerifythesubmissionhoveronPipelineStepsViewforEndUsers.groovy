package actions.IdeaBoard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.MouseOver

class VerifythesubmissionhoveronPipelineStepsViewforEndUsers{
    public void run(def params){
   
        MouseOver.run(ID:"//*[@class='fractal-pipelineViewIdeas']/*[@class='idea']//SPAN[text()='${params."Idea Title"}']")
        def verify = [:]
        verify.ID = "//*[contains(@class,'fractal-pipelineViewRollover')]/*[@class='idea-title' and contains(text(),'${params."Idea Title"}')]"
        verify.IDChildren = []
        if(params."Idea Submitter"){
             if(params."Does it contain team name"==true){
                 verify.IDChildren << "./..//*[@class='member-description' and text()='${params."Idea Submitter"}']"
        } else {
            verify.IDChildren << "./..//*[@class='member-description']/*[contains(text(),'${params."Idea Submitter"}')]"}
        }
       
          if(params."Submitter Image" !=null){
            def img
            if(params."Submitter Image"){img = "//*[contains(@src,'getfile.php')]"}
            else {img = "//*[@class='member-initial']"}
            verify.IDChildren << "./..//*[@class='idea-member']${img}"
        }
        if(params."Submitted"){verify.IDChildren << "./..//*[@class='idea-creation']/*[contains(text(),'${params."Submitted"}')]"}
        if(params."Idea Status"){verify.IDChildren << "./..//*[@class='idea-status']/*[text()='${params."Idea Status"}']"}
        if(params."Idea Category"){verify.IDChildren << "./..//*[@class='idea-category']/*[contains(text(),'${params."Idea Category"}')]"}
        if(params."Idea Description"){verify.IDChildren << "./..//*[@class='idea-description' ]//*[contains(text(),'${params."Idea Description"}')]"}
        if(params."Votes"){verify.IDChildren << "./..//*[@class='fa fa-arrow-up' or @class='fa fa-database']/../*[@class='f-idea-score-footer-text' and text()='${params."Votes"}']"}
        if(params."Comments"){verify.IDChildren << "./..//*[@class='f-idea-score-footer-item' and @data-comments='${params."Comments"}']"}
         if(params."Favorite" !=null){
            def fav
            if (params."Favorite"){fav="/I[@class='fa fa-star']"}
            else{fav= "/I[@class='fa fa-star-o']"}
            verify.IDChildren << "./..//*[contains(@class,'f-idea-score-favorite')]${fav}"
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}