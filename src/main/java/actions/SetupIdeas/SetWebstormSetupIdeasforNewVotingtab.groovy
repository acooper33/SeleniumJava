package actions.SetupIdeas;

import actions.common.SetupCommon
import actions.selenium.DoubleClick
import actions.selenium.SetCheckBox
import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Exists

class SetWebstormSetupIdeasforNewVotingtab{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Voting")

        sleep(5000)
        
        if(params."Voting Checkbox"==true){
            Click.run(ID:"//*[@id='f-voting-checkbox']/../../../../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Voting']/..", "Type of Click":"Move to Element")
        } else if(params."Voting Checkbox"==false){
            Click.run(ID:"//*[@id='f-voting-checkbox']/../../../../DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//SPAN[text()='Voting']/..", "Type of Click":"Move to Element")
        }
       
        if(params."Hide Vote Count"){
        	if(params."Hide Vote Count"==true){
            	Click.run(ID:"//*[@id='f-voting-hide-count']/../../../../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Hide Vote Count']/..", "Type of Click":"Move to Element")
        	} else if(params."Hide Vote Count"==false){
            	Click.run(ID:"//*[@id='f-voting-hide-count']/../../../../DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Hide Vote Count']/..", "Type of Click":"Move to Element")
        	}
        }

        if(params."Type of Voting"){
            if(params."Type of Voting"=="Simple"){
                Click.run(ID:"//*[@id='f-simple-voting-radio']/..")
            } else if (params."Type of Voting"=="Chips"){
                Click.run(ID:"//*[@id='f-chip_voting']/..")
                if(params."Total number of chips per user"){SetText.run(Text:params."Total number of chips per user",ID:"//*[@id='f-voting-total_chips']")}
                if(params."Number of chips a user can give to an idea"){SetText.run(Text:params."Number of chips a user can give to an idea",ID:"//*[@id='f-voting-user_give_chips']")}
                if(params."Return chips when an idea reaches one of the following statuses") {
                    params."Return chips when an idea reaches one of the following statuses".split(",").eachWithIndex{ status, x ->
                        if(params."Add or Remove Statuses".split(",")[x]=="Add"){
                            SetCheckBox.run(ID:"//*[text()='${status}']/../..//INPUT/..",Check:true)
                            if(Exists.run(ID:"//*[contains(@class,'f-reset-content')]")==1){ 
                                Click.run(ID:"//*[@id='clickToConfirmOkButton']")
                            } 
                        } else {
                           SetCheckBox.run(ID:"//*[text()='${status}']/../..//*[contains(@class,'checked')]//INPUT/..",Check:true)
                             if(Exists.run(ID:"//*[contains(@class,'f-reset-content')]")==1){ 
                                Click.run(ID:"//*[@id='clickToConfirmOkButton']")
                            } 
                        }
                    }
                }
            } else { Click.run(ID:"//*[@id='f-voting-restrict']/..")}
        }
        if(params."Demote Voting Checkbox"==true){
            Click.run(ID:"//*[@id='f-voting-demote']/../../../../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Demote Voting']/..", "Type of Click":"Move to Element")
        } else if(params."Demote Voting Checkbox"==false) {
                Click.run(ID:"//*[@id='f-voting-demote']/../../../../DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//SPAN[text()='Demote Voting']/..", "Type of Click":"Move to Element")
        }
        if(params."Enable Promote Reason"==true){
            Click.run(ID:"//*[@id='f-voting-promote_reason']/../../../../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Promote Reason']/..", "Type of Click":"Move to Element")
        } else if(params."Enable Promote Reason"==false) {
                Click.run(ID:"//*[@id='f-voting-promote_reason']/../../../../DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//SPAN[text()='Promote Reason']/..", "Type of Click":"Move to Element")
        }
        if(params."Enable Demote Reason"==true){
            Click.run(ID:"//*[@id='f-voting-demote_reason']/../../../../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Demote Reason']/..", "Type of Click":"Move to Element")
        } else if(params."Enable Demote Reason"==false) {
                Click.run(ID:"//*[@id='f-voting-demote_reason']/../../../../DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//SPAN[text()='Demote Reason']/..", "Type of Click":"Move to Element")
        }
        if(params."Submitter auto-promote on submission"==true){
            Click.run(ID:"//*[@id='f-voting-submitter_promote']/../../../../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='Submitter auto-promote on submission']/..", "Type of Click":"Move to Element")
        } else if(params."Submitter auto-promote on submission"==false) {
                Click.run(ID:"//*[@id='f-voting-submitter_promote']/../../../../DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//SPAN[text()='Submitter auto-promote on submission']/..", "Type of Click":"Move to Element")
        }
        if(params."New Voting Buttons"==true){
            Click.run(ID:"//*[@id='f-new_voting_btn']/../../../../DIV[not(contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper'))]/..//SPAN[text()='New Voting Buttons']/..", "Type of Click":"Move to Element")
        } else if(params."New Voting Buttons"==false) {
                Click.run(ID:"//*[@id='f-new_voting_btn']/../../../../DIV[contains(@class,'f-checkbox-checked') and contains(@class,'f-checkbox-wrapper')]/..//SPAN[text()='New Voting Buttons']/..", "Type of Click":"Move to Element")
        }

        if(params."Reset All Votes"==true){
            Click.run(ID:"//*[contains(@class,'f-reset-votes-btn')]")
            if(params."Reset All Votes Action"=="Cancel"){
                Click.run(ID:"//*[contains(@id,'clickToConfirmCancelButton')]")
            } else if(params."Reset All Votes Action"=="Reset Votes"){
                 SetCheckBox.run(ID:"//*[contains(@id,'f-voting-understanding')]/..",Check:true)
                 Click.run(ID:"//*[contains(@id,'clickToConfirmOkButton')]")
            }
        }
        Click.run(ID:"//*[contains(@class,'f-submit-voting')]/BUTTON")
    }
}
