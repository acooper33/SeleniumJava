package actions.PipelineTopIdeas;

import actions.selenium.Click
import actions.selenium.Exists

class TriggerMyLists{
    public void run(def params){
        if(params."Click My Lists" == true){
            println("Clicking on Lists!")
            Click.run(ID:"//*[@class='f-best-idea-top-right-bar']//BUTTON[contains(@class,'f-my-lists-btn')]", "Type of Click":"Javascript")}
        sleep(1000)
        if(params."Quick My Lists Button Should Be Active After Click" == true){
            assert Exists.run(ID:"//*[@class='f-best-idea-top-right-bar']//BUTTON[contains(@class,'f-my-lists-btn f-btn-active')]")==1, "Error - My List is Inactive"
        }
        else if(params."Quick My Lists Button Should Be Active After Click" == false){
            assert Exists.run(ID:"//*[@class='f-best-idea-top-right-bar']//BUTTON[contains(@class,'f-my-lists-btn f-btn-active')]")==0, "Error - My List is Active"
        }
        
    }
}