package actions.ViewIdeaComment;

import actions.common.*
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*
import actions.selenium.Exists

class VerifyCommentinViewandNGAViewIdea{
    public void run(def params){

        if(params."View Idea or NGA"=="NGA"){
            NGAViewIdeaCommon.NavigateTab(Tab:"Description")
        } else if(params."View Idea or NGA"=="View Idea"){
            ViewIdeaCommon.NavigateTab(Tab:"Description")
        }

        sleep(3000)
        assert Exists.run(ID:"//*[contains(@class,'spinner-outer')]")==0,"Button is stuck in endless spinning mode"

        //Map all values that will be used for verification for that instance
        def path
        def verify = [:]
        verify.IDChildren = []
        if(params."Comment section"=="Parent Comment"){
            path = "//*[@data-test='f-test-comment-wrapper']/*[contains(.,'${params."Parent Comment"}')]"
        } else if(params."Comment section"=="Deleted Parent Comment"){
            path  = "//*[@data-class='f-rnw-web-text' and contains(text(),'This message was deleted.')]"
        } else {
            path = "//*[@data-test='f-test-comment-wrapper']/*[contains(.,'${params."Reply Comment"}')]"
        }
        verify.ID= "${path}"
        if(params."Comment Type"){
            if(params."Comment Type"=="Private"){
                verify.IDChildren << "./../../..//*[contains(@style,'250, 234, 169')][2]"
            } else if(params."Comment Type" == "Submitter Q&A"){
                verify.IDChildren << "./../../..//*[contains(@style,'180, 236, 204')][2]"  
            } else if (params."Comment Type" == "Pinned"){
                verify.IDChildren << "./../../..//*[contains(@style,'182, 218, 242')][2]"
            } else if (params."Comment Type" == "Hidden" ){
                if(params."Reply Comment"){
                    verify.IDChildren << "./../../..//*[contains(@style,'231, 233, 235')][2]"
                } else { verify.IDChildren << "./../../..//*[contains(@class,'f-status-indicator-solid') and .='${params."Comment Type".toUpperCase()}']"}
            } else { verify.IDChildren << "./../../..//*[contains(@style,'0, 0, 0, 0.03')][2]"}
        }   
        if(params."User"){verify.IDChildren << "./../../..//*[contains(@data-tooltip-id,'user-flyover') and text()='${params."User"}']"}
        if(params."User Image"){
            def img
            if(params."User Image"==true){img = "//*[contains(@style,'getfile.php') and contains(@style,'background')]"}
            else{img = "//*[contains(@style,'background')]/*[contains(@data-class,'web-text')]"}
            if(params."Reply Comment"){
                verify.IDChildren << "./../../..${img}"
            } else {
                verify.IDChildren << "./../../../../../../..${img}"
            }                
        }
        
        if(params."Edited Indicator"){
            def editedPath
            if(params."Edited Indicator"==true){editedPath = "/*[@data-tooltip-id='comment-long-date']//*[@data-class='f-rnw-web-text' and contains(.,'(Edited)')]"}
            else{editedPath = "/*[@data-tooltip-id='comment-long-date']//*[@data-class='f-rnw-web-text' and not(contains(.,'(Edited)'))]"}
            verify.IDChildren << "./${editedPath}"
        }
        //if(params."Promote Score"){verify.IDChildren << }
        //if(params."Demote Score"){verify.IDChildren << }
        if(params."Promoted Vote Users"){
            if(params."MouseHover Voting"==true){
            	SetFocus.run(ID:"${path}")
            	SetFocus.run(ID:"${path}/..//*[contains(@data-tooltip-id,'-promote-tooltip')]/DIV[@data-test='f-test-comment-promote-button']/..")
                ExplicitWait.run(ID:"//*[contains(@id,'promote-tooltip')]")
            }
            verify.IDChildren << "./../../..//*[contains(@class,'react-tooltip__show') and .='${params."Promoted Vote Users"}']"
        }
        if(params."Demoted Vote Users"){
            if(params."MouseHover Voting"==true){
            	SetFocus.run(ID:"${path}")
            	SetFocus.run(ID:"${path}/..//*[contains(@data-tooltip-id,'-demote-tooltip')]/DIV[@data-test='f-test-comment-demote-button']/..")
            	ExplicitWait.run(ID:"//*[contains(@id,'demote-tooltip')]")
            }
            verify.IDChildren << "./../../..//*[contains(@class,'react-tooltip__show') and .='${params."Demoted Vote Users"}']"
        }
        
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        if(params."Placement Number") {
            if(params."Comment section"=="Parent Comment"){
                verify.ID="//*[@id='comments-component-render' or contains(@id,'idea-comments-container')]/DIV[1]/DIV[last()]/DIV[not(contains(@data-focusable,'true'))][${params."Placement Number"}]${path}"
            } else if(params."Comment section"=="Reply"){
                if(params."Parent Comment"=="This message was deleted."){
                    verify.ID= "//*[@data-class='f-rnw-web-text' and contains(text(),'This message was deleted.')]/../../following-sibling::DIV[position()=${params."Placement Number"}]//*[contains(@data-tooltip-id,'user-flyover')]//*[contains(@style,'height: 40px;')]/../../../..//DIV[@data-class='f-comment-body' and contains(.,'${params."Reply Comment"}')]"
                } else {
                    verify.ID= "//*[@data-test='f-test-comment-wrapper']/*[contains(.,'${params."Parent Comment"}')]/../../../../following-sibling::DIV[position()=${params."Placement Number"}]//*[contains(@data-tooltip-id,'user-flyover')]//*[contains(@style,'height: 40px;')]/../../../..//DIV[@data-class='f-comment-body' and contains(.,'${params."Reply Comment"}')]"
                }
            }
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}