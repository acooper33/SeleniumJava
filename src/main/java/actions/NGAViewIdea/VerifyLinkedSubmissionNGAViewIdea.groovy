package actions.NGAViewIdea;

import actions.selenium.Exists
import actions.selenium.Click
import actions.common.NGAViewIdeaCommon

class VerifyLinkedSubmissionNGAViewIdea{
    public void run(def params){
        sleep(3000)
        NGAViewIdeaCommon.NavigateTab(Tab:"Details")
        if(params."Linked Submissions"){
            params."Linked Submissions".split(",").eachWithIndex{name, x->
                if(params."Should Exist".split(",")[x]=="TRUE"){assert Exists.run(ID:"//*[@id='linked-idea-container']//*[@class='linked-idea']/A/DIV[contains(.,'${name}')]")==1, "Linked Submission ${name} not found"}
                else if(params."Should Exist".split(",")[x]=="FALSE"){assert Exists.run(ID:"//*[@id='linked-idea-container']//*[@class='linked-idea']/A[contains(.,'${name}')]")==0, "Linked Submission ${name} not expected, but present"}
            }
            if(params."Name of the Linked Submission to Navigate to"){Click.run(ID:"//*[@id='linked-idea-container']//*[@class='linked-idea']/A[contains(.,'${params."Name of the Linked Submission to Navigate to"}')]")}
        }
    }
}