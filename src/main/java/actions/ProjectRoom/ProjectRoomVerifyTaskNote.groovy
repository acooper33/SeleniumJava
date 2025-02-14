package actions.ProjectRoom;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class ProjectRoomVerifyTaskNote{
    public void run(def params){
        def verify = [:]
        verify.IDChildren = []
        if(params."Placement Number"){
        	verify.ID = "//*[@id='f-notes-comment-list']//*[contains(@class,'f-note-container')][position()='${params."Placement Number"}']//*[starts-with(.,'${params.Note}')]"
        }else {
        	verify.ID = "//*[@id='f-notes-comment-list']//*[contains(@class,'f-note-container')]//*[starts-with(.,'${params.Note}')]"
        }
        if(params."Author"){verify.IDChildren << "./..//DIV[@class='f-member-name' and .='${params."Author"}']"}
        if(params."Timestamp"){verify.IDChildren << "./..//DIV[@class='f-comment-date' and contains(.,'${params."Timestamp"}')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)   
    }
}