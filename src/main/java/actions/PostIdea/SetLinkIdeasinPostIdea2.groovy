package actions.PostIdea;

import actions.selenium.SetText
import actions.selenium.Click

class SetLinkIdeasinPostIdea2{
    public void run(def params){
        
        if (params."Link Ideas"){
            params."Link Ideas".split(",").eachWithIndex{ idea, x ->
                if(params."Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[contains(@id,'linked-ideas')]/..//INPUT[2]",Text:idea,"Type of Clear":"None")                   
                    sleep(3000)
                    Click.run(ID:"//*[contains(@class,'linked-idea-name') and contains(text(),'${idea}')]/..")   
                }	
                else{
                    Click.run(ID:"//*[contains(@class,'tag label label-info') and contains(.,'${idea}')]//*[contains(@class,'fa fa-times')]")
                }
            } 
        }
        
    }
}