package actions.IdeaBoard;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*

class VerifyPinnedCommentinIdeaBoardsListView{
    public void run(def params){
        
        def path
        def verify = [:]
        verify.IDChildren = []
        path =  "//*[contains(@class,'fractal-secondary-ideas-view-list')]//*[text()='${params."Idea"}']/../..//*[@data-class='f-comment-wrapper-pinned' and contains(@style,'rgb(235, 245, 251)')]"
        verify.ID= "${path}"
        if(params."Comment"){verify.IDChildren << ".//*[@data-class='f-comment-body' and text()='${params."Comment"}']"}
        if(params."Comment Submitter"){verify.IDChildren << "./../..//*[contains(@data-class,'f-member-flyover-tooltip') and text()='${params."Comment Submitter"}']"}
        if(params."Comment Submitter Image" !=null){
            def img
            if(params."Comment Submitter Image"){img = "//*[@data-class='f-comment-avatar']//*[contains(@style,'getfile.php?')]"}
            else {img = "//*[@data-class='f-comment-avatar']//*[@data-class='f-rnw-web-text']"}
            verify.IDChildren << "./../..${img}"
        }
        if(params."Comment Date Displayed" !=null){
            def date
            if(params."Comment Date Displayed"){date = "[@data-class='f-comment-date' and string-length(@data-tooltip-content) > 0]"}
            verify.IDChildren << "./../..//*${date}"
        }
        if(params."Edited Comment" !=null){
            def edited
            if(params."Edited Comment"){edited = "[@data-class='f-comment-date']//*[@data-class='f-comment-edited']"}
            else {edited = "[@data-class='f-comment-date']//*[@data-class='f-rnw-web-text' and not(contains(text(),'edited'))]"}
            verify.IDChildren << ".//*${edited}"
        }
        if(params."Attachments"){
          params."Attachments".split(",").eachWithIndex{ attachment, x ->
               verify.IDChildren << "./..//*[@class='f-filedisplay-image-slide']//*[text()='${attachment}']"
          }
        }
        if(params."User Tags"){
          params."User Tags".split(",").eachWithIndex{ tags, x ->
               verify.IDChildren << ".//*[@data-class='f-comment-body']//*[@data-tooltip-id='comments-tagged-user-flyover' and text()='${tags}']"
          }
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
        if(params."Click on User Tag"==true){
            Click.run(ID:"${path}//*[@data-class='f-comment-body']//*[@data-tooltip-id='comments-tagged-user-flyover' and text()='${params."User Tags"}']")
        }
    }
}