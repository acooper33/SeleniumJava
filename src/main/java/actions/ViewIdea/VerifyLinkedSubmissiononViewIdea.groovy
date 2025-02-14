package actions.ViewIdea;

import actions.selenium.Exists
import actions.selenium.Click


class VerifyLinkedSubmissiononViewIdea{
    public void run(def params){
        if(params."Linked Submissions"){
            params."Linked Submissions".split(",").eachWithIndex{ name, x ->
                if (params."Should Exist".split(",")[x]=="TRUE"){assert Exists.run(ID:"//*[@id='linked_ideas']/DIV[@class='linked-idea']//TD[@class='linked-idea-title-holder']/A[text()='${name}']")==1, "Error - Unexpected Linked Submissions"}
                else if(params."Should Exist".split(",")[x]=="FALSE"){assert Exists.run(ID:"//*[@id='linked_ideas']/DIV[@class='linked-idea']//TD[@class='linked-idea-title-holder']/A[text()='${name}']")==0, "Error - Unexpected Linked Submissions"}
            }
        }
        if(params."Name of the Linked Submission to Navigate to"){Click.run(ID:"//*[@id='linked_ideas']/DIV[@class='linked-idea']//TD[@class='linked-idea-title-holder']/A[text()='${params."Name of the Linked Submission to Navigate to"}']")}
    }
}