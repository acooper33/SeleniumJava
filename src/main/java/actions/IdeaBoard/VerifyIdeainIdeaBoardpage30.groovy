package actions.IdeaBoard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.VerifyText
import actions.selenium.Click
import actions.selenium.Exists

class VerifyIdeainIdeaBoardpage30{
    public static void run(def params){
        sleep(3000)
        if(params.Tab){
            if(params.Tab=='Random'){
                Click.run(ID:"//*[@id='ideaboard-filter-button-random']")
            }
            if(params.Tab=='Recent'){
                Click.run(ID:"//*[@id='ideaboard-filter-button-recent']")
            } else {
                Click.run(ID:"//*[@id='ideaboard-filter-button-active' and .='${params.Tab}'] ")
            }
            sleep(3000)
        }
        
        //Map all values that will be used for verification for that instance
        def verify = [:]
        if(params."View Type"=="List"){
         verify.ID = "//*[contains(@class,'fractal-secondary-ideas-view-list')]//*[@class='f-card-title' and text()='${params."Idea Name"}']"
        } else {
        verify.ID = "//*[contains(@class,'fractal-secondary-ideas-view-grid')]//*[@class='f-card-title' and text()='${params."Idea Name"}']"       
        }
        verify.IDChildren = []
        if(params."Image" !=null){
            def img
            if(params."Image"){img = "//*[@class='f-card-image' and contains(@style,'/ct/getfile.php')]"}
            else {img = "//*[@class='f-card-image' and contains(@style, 'default-idea-image.jpg')]"}
            verify.IDChildren << "./../../..${img}"
            println("img:'${img}'")
        }
        //if(params."Status"){verify.IDChildren << "./..//*[@class='f-card-status']/span[text()='${params."Status"}']"}
        if(params."Status"){verify.IDChildren << "./../..//DIV[contains(@class, 'f-status-indicator') and text()='${params."Status"}']"}
        //f-status-indicator f-status-indicator-primary f-status-indicator-solid f-card-status
        
        //If anonymous, then look with title name + anonymous otherwise its just a username. class name changes when Anonymous
        if(params."Username"){
            if(params."Username".contains("Anonymous")){
                verify.IDChildren << "./../..//*[contains(@class,'f-card-screenname') and normalize-space()='${params."Username"}']"
            }
            else {verify.IDChildren << "./../..//*[contains(@class,'f-card-screenname') and text()='${params."Username"}']"}
        }
		
        if(params."Date"){verify.IDChildren << "./../..//*[@class='f-card-screenname' and text()='${params."Date"}']"}
        //if(params."Description"){verify.IDChildren << "./../../*[@class='card-description']/DIV[starts-with(@id,'card-description')]//*[text()='${params."Description"}']"}   
        //if(params."Description"){verify.IDChildren << "./../../..//*[contains(@id,'card-description') and text()='${params."Description"}']"}
        /*for old cards*/ if(params."Description"){verify.IDChildren << "./../../..//*[contains(@id,'card-description') and .='${params."Description"}']"}
        if(params."Votes"){verify.IDChildren << "./../../..//*[@data-votes='${params."Votes"}']"}
        if(params."Comments"){verify.IDChildren << "./../../..//*[@data-comments='${params."Comments"}']"}
        if(params."Favorite" !=null){
            def fav
            if (params."Favorite"){fav="//DIV[@data-favorite='true' or @data-favorite='1']"}
            else{fav= "//DIV[@data-favorite='false' or @data-favorite='0']"}
            verify.IDChildren << "./../../..${fav}"
        }
        if(params."Chip Vote Count"){verify.IDChildren << "./../../..//*[@class='f-vote-chip-count' and text()='${params."Chip Vote Count"}']"}
        if(params."Vote Count on Voting UI"){verify.IDChildren << "./../../..//*[@class='f-vote-count' and text()='${params."Vote Count on Voting UI"}']"}
        if(params."Placement Number") {
            verify.ID="(//*[contains(@class,'ideaboard-card')])[${params."Placement Number"}]//*[@class='f-card-title' and text()='${params."Idea Name"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
   }
}