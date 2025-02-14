package actions.ViewIdea30;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class VerifyLinkedSubmissionsVI3{
    public void run(def params){
        if(params."Linked Idea(s)"){
            params."Linked Idea(s)".split(",").eachWithIndex{name, x->
                def linkedIdea = [:]
                linkedIdea.IDChildren = []
                linkedIdea.ID = "//UL[@class='f-linked-idea-list']/LI//SPAN[@class='f-linked-title' and .='${name}']"
                if(params."Linked Idea(s) Status"){
                    linkedIdea.IDChildren << "./../../../SPAN[contains(@class,'f-linked-status') and .='${params."Linked Idea(s) Status".split(",")[x]}']"
                }
                if(params."Should Exist".split(",")[x].equalsIgnoreCase("TRUE")){linkedIdea."Number of Matches" = 1} 
                else {linkedIdea."Number of Matches" = 0}
                VerifyNumberOfMatches.run(linkedIdea) 
            }
        }
        if(params."Linked Idea to Click On (optional)"){Click.run(ID:"//UL[@class='f-linked-idea-list']/LI//SPAN[@class='f-linked-title' and .='${params."Linked Idea to Click On (optional)"}']")
        }
    }
}