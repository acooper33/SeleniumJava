package actions.Enterprise.UserHomepage;

import actions.selenium.Exists
import actions.selenium.Click

class VerifyLinkedSubmissionsonViewMyIdea{
    public void run(def params){
     if(params."Linked Submissions"){
            params."Linked Submissions".split(",").eachWithIndex{ submission, x ->
                if (params."Should Exist".split(",")[x]=="TRUE"){assert Exists.run(ID:"//*[@class='f-spark-edit-header' and text()='Linked Submissions']/..//A[text()='${submission}']")==1, "Error - Unexpected Linked Submissions"}
                else if(params."Should Exist".split(",")[x]=="FALSE"){assert Exists.run(ID:"//*[@class='f-spark-edit-header' and text()='Linked Submissions']/..//A[text()='${submission}']")==0, "Error - Unexpected Linked Submissions"}
            }
        }
        if(params."Name of the Linked Submission to Navigate to"){Click.run(ID:"//*[@class='f-spark-edit-header' and text()='Linked Submissions']/..//A[text()='${params."Name of the Linked Submission to Navigate to"}']")}
    }
}