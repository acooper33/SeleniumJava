package actions.IdeaBoard;
import actions.selenium.Click
import actions.selenium.Exists

class SetIdeaListViewinIdeaBoardPage{
    public void run(def params){

        def parentID = "//*[@class='il-lv-span-title' and text()='${params."Idea Name"}']"
        Click.run(ID:"//*[@id='list-view']")

        if(params."Mark/UnMark Favorite"!=null){
            if(params."Mark/UnMark Favorite" == "Mark"){
                if (Exists.run(ID:parentID+"/../../../DIV//DIV[@class='board-idea-fav']",Timeout:5)==1){
                    Click.run(ID:parentID+"/../../../DIV//DIV[@class='board-idea-fav']")
                }
            } else { 
                if (Exists.run(ID:parentID+"/../../../DIV//DIV[@class='board-idea-fav is-favorite']",Timeout:5)==1){
                    Click.run(ID:parentID+"/../../../DIV//DIV[@class='board-idea-fav is-favorite']")
                }
            }
        } 
        if(params."Subscribe/UnSubscribe"!=null){
            if(params."Subscribe/UnSubscribe"){
                if (Exists.run(ID:parentID+"/../../../DIV//DIV[@class='board-idea-subscribe']",Timeout:5)==1){
                    Click.run(ID:parentID+"/../../../DIV//DIV[@class='board-idea-subscribe']")
                }
            } 
        }
    }
}