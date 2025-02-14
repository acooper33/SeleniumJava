package actions.IdeaBoard;

import actions.selenium.Click
import actions.selenium.Exists

class SetIdeainIdeaBoardPage30{
    public void run(def params){
        def parentID = "//*[@class='f-card-title' and text()='${params."Idea Name"}']"
        
        if(params.Favorite!=null){
            if(params.Favorite==true){
                println("in the Favorite == TRUE")
                //if (Exists.run(ID:parentID+"/../../DIV[@class='f-card-footer']//DIV[contains(@class,'f-idea-score-favorite') and @data-favorite='0']",Timeout:5)==1){ //check if idea is not favorited, if it's not then favorite it
                if (Exists.run(ID:parentID+"/../..//DIV[contains(@class,'f-idea-favorite') and not(contains(@class,'f-idea-favorite-selected'))]/I",Timeout:5)==1){ //check if idea is not favorited, if it's not then favorite it
						println("Will click on Favorite icon!")
                    	Click.run(ID:parentID+"/../..//DIV[contains(@class,'f-idea-favorite') and not(contains(@class,'f-idea-favorite-selected'))]/I")
                    }
            }else{
                if (Exists.run(ID:parentID+"/../..//DIV[contains(@class,'f-idea-favorite') and contains(@class,'f-idea-favorite-selected')]/I",Timeout:5)==1){ //check if idea is favorited, if yes, unfavorite it
                    Click.run(ID:parentID+"/../..//DIV[contains(@class,'f-idea-favorite') and contains(@class,'f-idea-favorite-selected')]/I")
                }
            }
            sleep(1000)
        }
    }
}