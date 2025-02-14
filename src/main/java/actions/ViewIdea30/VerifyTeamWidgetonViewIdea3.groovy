package actions.ViewIdea30;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyTeamWidgetonViewIdea3{
    public void run(def params){
        params."User(s)".split(",").eachWithIndex{name, x ->
            def verify = [:]
            def teamMemberClass, memberImage
            
            if(params."Team Leader".split(",")[x]=="TRUE"){ teamMemberClass = "f-team-member f-leader-team" }
            else{ teamMemberClass = "f-team-member" }
            
            /*if(params."User Pic".split(",")[x]=="TRUE"){ memberImage = "//*[contains(@src,'ct/getfile.php')]" }
            else{ memberImage = "//*[@class='member-initial']" }*/
            
            if(params."Should User Exist".split(",")[x]=="TRUE"){ verify."Number of Matches" = 1 }
            else{ verify."Number of Matches" = 0 }
            
        	verify.ID = "//DIV[contains(@class,'f-idea-team')]//DIV[@class='f-team-list']//DIV[contains(@class,'${teamMemberClass}')]//SPAN[starts-with(.,'${name}')]"         

            VerifyNumberOfMatches.run(verify)
        }
    }
}