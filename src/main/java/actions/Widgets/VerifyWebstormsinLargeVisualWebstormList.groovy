package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.VerifyText

class VerifyWebstormsinLargeVisualWebstormList{
    public void run(def params){

        //Map all values that will be used for verification for that instance
        def verify = [:]
        //verify.ID = "//*[@id='visual-large-webstorms-list']//*[@class='vwl-webstorm-title' and text()=\"${params."Webstorm Title"}\"]"    
        // Custom Initiative for Pipeline Setup Title Edited
        verify.ID = "//*[@id='visual-large-webstorms-list']//*[@class='vwl-webstorm-title' and .='${params."Webstorm Title"}']"
        verify.IDChildren = []
        if(params."Webstorm Image"!=null){
            def img
            if(params."Webstorm Image"){img = "//IMG[contains(@src,'/CT/getfile.php')]"}
            else{img = "//IMG[contains(@src,'/CORE/IMAGES/apps/')]"}
            verify.IDChildren << "./parent::DIV/parent::DIV${img}"
        }

        if(params."Webstorm Description"){verify.IDChildren << "./parent::DIV//DIV[@class='vwl-webstorm-description' and text()='${params."Webstorm Description"}']"}        
        if(params."Idea Count"){verify.IDChildren << "./parent::DIV//DIV[@class='vwl-idea-count count-item' and text()='${params."Idea Count"}']"}
        if(params."Comment Count"){verify.IDChildren << "./parent::DIV//DIV[@class='vwl-comment-count count-item' and text()='${params."Comment Count"}']"}
        if(params."User Count"){verify.IDChildren << "./parent::DIV//DIV[@class='vwl-user-count count-item' and text()='${params."User Count"}']"}

        if(params."Phase Title"){verify.IDChildren << "./parent::DIV//DIV[@class='vwl-content-footer']/DIV[not(contains(@class,'hide'))]//DIV[@class='vwl-phase-title' and text()='${params."Phase Title"}']"}
        if(params."Current Phase Number"){verify.IDChildren << "./parent::DIV//DIV[@class='vwl-content-footer']/DIV[not(contains(@class,'hide'))]//DIV[contains(@class,'vwl-phase-number') and text()='${params."Current Phase Number"}']"}
        if(params."Total Phases"){verify.IDChildren << "./parent::DIV//DIV[@class='vwl-content-footer']/DIV[not(contains(@class,'hide'))]//DIV[contains(@class,'vwl-total-phases') and text()='${params."Total Phases"}']"}

        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}