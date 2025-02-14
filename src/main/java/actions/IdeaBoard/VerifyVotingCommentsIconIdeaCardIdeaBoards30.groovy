package actions.IdeaBoard;

import actions.selenium.Exists;

class VerifyVotingCommentsIconIdeaCardIdeaBoards30{
    public void run(def params){
        sleep(5000)
        def simpleVotingPath = "//*[@class='f-idea-score-footer-item']/I[normalize-space(@class)='fa fa-arrow-up']"
        def chipVoitingPath = "//*[@class='f-idea-score-footer-item']/I[contains(normalize-space(@class),'fa-database')]"
        def commentPath = "//*[@class='f-idea-score-footer-item']/I[contains(@class,'fa-comment')]"
        def favoritesPath = "//*[contains(@class,'f-idea-score-favorite')]"
        
        if (params."Chips Voting"==true){
            assert Exists.run(ID:"${chipVoitingPath}")>0, "Error - Chips Voting Icon Not Found"
            assert Exists.run(ID:"${simpleVotingPath}")==0, "Error - Unexpected Simple Voting Icon Found"
            //*[@class='card-footer']//DIV[@class='f-idea-score-footer-item']/I[@class='fa fa-arrow-up']
            
       	}
        if (params."Simple Voting"==true){
            assert Exists.run(ID:"${simpleVotingPath}")>0, "Error - Simple Voting Icon Not Found"
            assert Exists.run(ID:"${chipVoitingPath}")==0, "Error - Unexpected Chips Voting Icon Found"
            
       	}
        if(params."Chips Voting"==false && params."Simple Voting"==false){
            assert Exists.run(ID:"${chipVoitingPath}")==0, "Error - Unexpected Chips Voting Icon Found"
            assert Exists.run(ID:"${simpleVotingPath}")==0, "Error - Unexpected Simple Voting Icon Found"
        }
        
        if(params."Comments"){
            if(params."Comments"==true){
                assert Exists.run(ID:"${commentPath}")>0, "Error - No Comments Icon Found"
            } else {
               assert Exists.run(ID:"${commentPath}")==0, "Error - Unexpected Comments Icon Found" 
            }
        }
            
        if(params."Favorites"){
            if(params."Favorites"==true){
                assert Exists.run(ID:"${favoritesPath}")>0, "Error - No favorites Icon Found"
            } else {
               assert Exists.run(ID:"${favoritesPath}")==0, "Error - Unexpected favorites Icon Found" 
            }
        }
    }
}