package actions.Memo;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*
import actions.Utils.CalculatethenumberofDays
import actions.Utils.ReturnTodaysDateintheRequestedFormat

class VerifyMemoinTopIdeas{
    public void run(def params){
        
 		def verify = [:]
        if(params."Placement Number") {verify.ID = "//DIV[contains(@class,'f-idea f-idea-large')][${params."Placement Number"}]//DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Title"}')]"}
        else {verify.ID = "//DIV[contains(@class,'f-idea f-idea-large')]//DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Title"}')]"}
          
        verify.IDChildren = []
        if(params."Stack Name Memo belongs to"){verify.IDChildren << "./../../../../../..//DIV[contains(@class,'f-stack-title')]/SPAN[.= '${params."Stack Name Memo belongs to"}']"}
        if(params."Image"){
            if(params."Image"=="Memo"){
                verify.IDChildren << "./../..//*[contains(@src,'memo_image')]"
            } else {
                verify.IDChildren << "./../..//*[contains(@src,'idea-image')]"}
        }
     	//if(params."Score"){verify.IDChildren << "./../..//*[contains(@class,'f-round-score') and text()='${params.Score}']"} updated on Feb 21
        if(params."Score"){verify.IDChildren << "./../..//*[contains(@class,'score') and .='${params.Score}']"}
    	if(params."Score Container Color"){verify.IDChildren << "./../..//*[contains(@class,'f-round-score-container f-${params."Score Container Color"}')]"}
        if(params."Status"){verify.IDChildren << "./../../..//*[contains(@class,'status') and text()='${params."Status"}']"}
         if(params."Activity Indicator Displayed"==true){
             verify.IDChildren << "./../../..//*[contains(@class,'fas fa-heartbeat f-heartbeat-${params."Activity Indicator"}')]"          
         } else if (params."Activity Indicator Displayed"==false){
          verify.IDChildren << "./../../..//*[contains(@class,'f-card-row')][3]/*[not(contains(@class,'f-memo-thumbnail-date'))]"    
         }
         if(params."Last Activity Displayed"==true){
             verify.IDChildren << "./../../..//*[contains(@class,'f-memo-thumbnail-date') and contains(.,'${params."Last Activity"}')]"
         } else if (params."Activity Indicator Displayed"==false){
             verify.IDChildren << "./../../..//*[contains(@class,'f-card-row')][3]/*[not(contains(@class,'f-memo-thumbnail-date'))]"               
         }
        if(params."Progress Bar"){
             verify.IDChildren << "./../../..//*[contains(@class,'-progress-container')]//*[contains(@class,'f-step-${params."Progress Bar"} f-active-steps')]"
         } 
        if(params."Stage"){verify.IDChildren << "./../../..//*[contains(@class,'step-label') and contains(text(),'Stage')]/../..//*[contains(.,'Stage:${params."Stage"}')]"}
        if(params."Step"){verify.IDChildren << "./../../..//*[contains(@class,'step-label') and contains(text(),'Step')]/../..//*[contains(.,'${params."Step"}')]"}
        if(params."Days In Step"){
            if(params."Days In Step".contains("difference between today and")){
            	//params."Days In Step" = CalculatethenumberofDays.run("Start Date":params."Days In Step".substring(29), "End Date":ReturnTodaysDateintheRequestedFormat.run("Format":"MM-dd-yyyy"))  
        		params."Days In Step" = CalculatethenumberofDays.run("Start Date":params."Days In Step".substring(29), "End Date":"today")  
            }
            verify.IDChildren << "./../../..//*[contains(@class,'step-days') and contains(.,'for ${params."Days In Step"} day')]"
        }
        if(params."Open Action Items Count"){verify.IDChildren << "./../../..//*[contains(@data-tooltip-id,'f-clock-icon')]/../*[text()='${params."Open Action Items Count"}']"}
        if(params."Collaborator Count"){verify.IDChildren << "./../../..//*[contains(@data-tooltip-id,'f-users-icon')]/../*[text()='${params."Collaborator Count"}']"}
        if(params."Idea Code"){verify.IDChildren << "./../../..//*[contains(@class,'f-card-footer')]/*[@class='f-card-link' and text()='${params."Idea Code"}']"}
        if(params."Owner Display Picture"){
            if(params."Number of Matches"!="0"){
                SetFocus.run(ID:verify.ID+"/../../..//*[contains(@class,'f-member-wrapper')]/DIV")
                sleep(2000)
            }
            if(params."Owner Display Picture"=="TRUE" || params."Owner Display Picture"=="FALSE"){
             	verify.IDChildren << "./../../..//*[contains(@class,'f-member-wrapper')]//*[contains(@class,'react-tooltip') and contains(.,'Owner: ${params."Owner Name"}')]"              
         	} else if (params."Owner Display Picture"=="?"){
             	verify.IDChildren << "./../../..//*[contains(@class,'f-member-wrapper')]//*[contains(@class,'react-tooltip') and contains(.,'Owner: Not Assigned')]"    
         	}
        }
        
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        verify.Timeout=15
        VerifyNumberOfMatches.run(verify)
    }
}