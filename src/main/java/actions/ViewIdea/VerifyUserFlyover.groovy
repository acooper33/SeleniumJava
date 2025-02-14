package actions.ViewIdea;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyUserFlyover{
    public void run(def params){

        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.ID = "//*[@class='user-name']/A[contains(text(),'${params."User Name"}')]"        
        verify.IDChildren = []
        if(params."User Profile Picture"!=null){
            def img
            if(params."User Profile Picture"){img = "/IMG[contains(@src,'getfile.php')]"}
            else{img = "/IMG[not(contains(@src,'getfile.php'))]"}
            verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV//DIV[@class='user-profile-img']${img}"
        }
        if(params."Ideas Count"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/parent::DIV//DIV[@class='bi-user-fly-footer']//I[contains(@class,'lightbulb')]/parent::SPAN/*[text()='${params."Ideas Count"}']"}
        if(params."Designation"){verify.IDChildren << "./parent::DIV/parent::DIV/DIV[@class='user-designation' and contains(text(),'${params."Designation"}')]"}
        if(params."Follower Count"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/parent::DIV//DIV[@class='bi-user-fly-footer']//*[@id='follower-count' and text()='${params."Follower Count"}']"}
        if(params."Messages Count"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/parent::DIV//DIV[@class='bi-user-fly-footer']//I[contains(@class,'comments')]/parent::SPAN/*[text()='${params."Messages Count"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)  
    }
}