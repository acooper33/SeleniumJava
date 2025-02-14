package actions.IdeaBoard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.VerifyText
import actions.selenium.Click

class VerifyIdeainIdeaBoardpage{
    public static void run(def params){
        if(params.Tab){
            Click.run(ID:"//div[contains(@class,'menu-item')]//*[text()='${params.Tab}']")
            sleep(2000)
        }
        
        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.ID = "//*[@class='idea-title' and text()=\"${params."Idea Name"}\"]"        
        verify.IDChildren = []
        if(params."Image"!=null){
            def img
            if(params."Image"){img = "/IMG[contains(@src,'/ct/getfile.php')]"}
            else{img = "/IMG[contains(@src,'default-idea-image.jpg')]"}
            verify.IDChildren << "./parent::A/parent::DIV/parent::DIV${img}"
        }
        if(params."Status"){verify.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//*[text()='${params."Status"}']"}
        //If anonymous, then look with title name + anonymous otherwise its just a username
        if(params."Username"){
            if(params."Username".contains("Anonymous")){VerifyText.run(ID:verify.ID+"/parent::A/parent::DIV/parent::DIV/parent::DIV/DIV[@class='board-bottom']//SPAN","Contains Text":params."Username")}
            else {verify.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//*[text()='${params."Username"}']"}
        }
        if(params."Description"){verify.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//*[contains(text(), '${params."Description"}')]"}        
        //if(params."Votes"){verify.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//SPAN[@my-vote='${params."Votes"}']"}
        if(params."Votes"){verify.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//SPAN[@class='promote-count' and text()='${params."Votes"}']"}
        if(params."Comments"){verify.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV//DIV[@class='board-idea-comment-count']/SPAN[text()='${params."Comments"}']"}
        if(params."Favorite"!=null){
            def fav
            if(params."Favorite"){fav = "//DIV[@class='board-idea-fav is-favorite']"}
            else{fav = "//DIV[@class='board-idea-fav']"}
            verify.IDChildren << "./parent::A/parent::DIV/parent::DIV/parent::DIV${fav}"
        }        
        
        if(params."Placement Number"){
            params."Number of Matches"=1
            verify.ID = "(//*[@class='view-selected']/DIV[@class='idea-board'])[${params."Placement Number"}]//*[@class='idea-title' and text()='${params."Idea Name"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}