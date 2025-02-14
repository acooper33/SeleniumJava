package actions.ActionItems;

import actions.selenium.Click
import actions.selenium.DragAndDrop
import actions.selenium.SetText

class SetStackRankforIdeainActionItemspage{
    public void run(def params){

        if(params."Idea"){
            DragAndDrop.run("From ID":"//*[@id='content-inside']//*[@class='stack-rank-idea-title' and text()='${params."Idea"}']", "To ID":"//*[@class='idea_rank_num' and text()='${params."New Order"}']/..//SPAN[@class='stack-rank-idea-title']") 
        }
        
        if(params.Action){
            if(params.Action=="Save"){Click.run(ID:"//*[@id='stack_rank_btn_save']")}
            else{Click.run(ID:"//*[@id='stack_rank_btn_complete']")}
            sleep(4000)
        }
        
        if(params."Search Idea"){
            SetText.run(ID:"//*[@id='stack_rank_search_input']",Text:params."Search Idea","Type of Clear":"Cut")
        }
    }
}