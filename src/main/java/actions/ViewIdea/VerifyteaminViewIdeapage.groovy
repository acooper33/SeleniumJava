package actions.ViewIdea;

import actions.selenium.*

class VerifyteaminViewIdeapage{
    public void run(def params){

        def mem = "//*[@class='team_member enhancement'][${params."Position"}]"
        if(params."Member Image"){
            if(params."Member Image"!="Image"){
                assert Exists.run(ID:"${mem}//*[@class='default_member_image']/*[text()='${params."Member Image"}']")==1,"Error - Expected default member image not found"
            } else {assert Exists.run(ID:"${mem}//*[@class='idea-details-team-photo']")==1,"Error - Expected member image not found"}
        }
        if(params."Team Member Name"){
            MouseOver.run(ID:"${mem}/A")
            assert Exists.run(ID:"//*[@class='user-name']/A[contains(text(),'${params."Team Member Name"}')]")==1,"Error - Expected team member not found"    
        }
        if (params."Team Owner"==true){
            assert Exists.run(ID:"${mem}//*[contains(@class,'idea_submitter')]")== 1,"Error - Failed to find Team Owner"}
        else if (params."Team Owner"==false){assert Exists.run(ID:"${mem}//*[contains(@class,'idea_submitter')]")== 0,"Error - Team Owner found but should NOT exist"}
    }
}