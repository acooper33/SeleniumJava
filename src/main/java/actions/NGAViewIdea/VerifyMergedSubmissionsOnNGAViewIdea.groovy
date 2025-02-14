package actions.NGAViewIdea;

import actions.selenium.Exists
import actions.selenium.Click
import actions.common.NGAViewIdeaCommon

class VerifyMergedSubmissionsOnNGAViewIdea{
    public void run(def params){
        sleep(3000)
        NGAViewIdeaCommon.NavigateTab(Tab:"Details")
        if(params."Merged Submissions"){
            params."Merged Submissions".split(",").eachWithIndex{name, x->
                if(params."Should Exist".split(",")[x]=="TRUE"){assert Exists.run(ID:"//*[@id='merged-idea-container']//*[@class='merged-idea']/A[contains(.,'${name}')]")==1, "Merged Submission ${name} not found"}
                else if(params."Should Exist".split(",")[x]=="FALSE"){assert Exists.run(ID:"//*[@id='merged-idea-container']//*[@class='merged-idea']/A[contains(.,'${name}')]")==0, "Merged Submission ${name} not expected, but present"}
            }
            if(params."Name of the Merged Submission to Navigate to"){Click.run(ID:"//*[@id='merged-idea-container']//*[@class='merged-idea']/A[contains(.,'${params."Name of the Merged Submission to Navigate to"}')]")}
        }
    }
}