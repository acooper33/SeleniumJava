package actions.ProjectRoom;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyTasksinProjectRoom{
    public void run(def params){
    
        def verify = [:]
        verify.ID = "//*[contains(@class,'fractal-input')]/*[@value=\"" + params."Task" + "\"]"
        verify.IDChildren = []

        if(params."Assignee"){verify.IDChildren << "./../../../..//*[contains(@class,'f-table-v2-assignee')]//*[@value='${params."Assignee"}' or @placeholder='${params."Assignee"}']"}
        if(params."Status"){verify.IDChildren << "./../../../..//*[contains(@class,'f-table-v2-status')]//*[@value='${params."Status"}' or @placeholder='${params."Status"}']"}
        if(params."Due Date"){verify.IDChildren << "./../../../..//*[@id='f-rule-trigger-date'and (@value='${params."Due Date"}' or @placeholder='${params."Due Date"}')]"}
        if(params."Notes Count"){verify.IDChildren << "./../../../..//*[contains(@class,'f-table-v2-add-note') and text()='${params."Notes Count"}']"}
        if(params."Marked Completed"){
            def mark
            if(params."Marked Completed"==true){mark = "//*[contains(@class,'fas fa-circle-check')]"}
            else {mark = "//*[contains(@class,'far fa-circle-check')]"}
            verify.IDChildren << "./../../../..${mark}"
        }
        if(params."Placement Number"){
            params."Number of Matches"=1
            verify.ID ="//*[contains(@class,'f-table-v2-body-wrapper')]//*[contains(@class,'f-table-v2-row-draggable')][" + params."Placement Number" + "]//*[contains(@class,'fractal-input')]/*[@value=\"" + params."Task" + "\"]"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)
        }
    }
}