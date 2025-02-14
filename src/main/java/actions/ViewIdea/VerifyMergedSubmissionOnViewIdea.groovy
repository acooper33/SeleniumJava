package actions.ViewIdea;

import actions.selenium.Exists
import actions.selenium.Click

class VerifyMergedSubmissionOnViewIdea{
    public void run(def params){
        if(params."Merged Submissions"){
            params."Merged Submissions".split(",").eachWithIndex{ name, x ->
                //if (params."Should Exist".split(",")[x]=="TRUE"){assert Exists.run(ID:"//*[@id='linked_ideas']/DIV[@class='linked-idea']//TD[@class='linked-idea-title-holder']/A[text()='${name}']")==1, "Error - Unexpected Linked Submissions"}
                if (params."Should Exist".split(",")[x]=="TRUE"){assert Exists.run(ID:"//*[@id='merged_ideas']/DIV[@class='merge-idea']//TD[@class='merge-idea-title-holder']/A[text()='${name}']")==1, "Error - Merged Submission ${name} Not Found"}
                else if(params."Should Exist".split(",")[x]=="FALSE"){assert Exists.run(ID:"//*[@id='merged_ideas']/DIV[@class='merge-idea']//TD[@class='merge-idea-title-holder']/A[text()='${name}']")==0, "Error - Unexpected Merged Submission ${name} Found"}
            }
        }
        if(params."Name of the Merged Submission to Navigate to"){Click.run(ID:"//*[@id='linked_ideas']/DIV[@class='merge-idea']//TD[@class='merge-idea-title-holder']/A[text()='${params."Name of the Merged Submission to Navigate to"}']")}
    }
}