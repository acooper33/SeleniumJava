package actions.WebstormHomepage;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import actions.selenium.utils.VerifyMatchingItems

class HackVerifyPariticipant{
    public void run(def params){
        def verify = [:]
        verify.IDChildren = []
        def xpath
        if(params."Participant is the current user" && params."Placement Number"){
       		verify.ID = "//DIV[contains(@class,'ideas-view-grid')]/DIV[contains(@class,'f-participant-card') and contains(@class,'f-participant-member') and position()='${params."Placement Number"}']"
        }else if (params."Placement Number"){
        	verify.ID = "//DIV[contains(@class,'ideas-view-grid')]/DIV[contains(@class,'f-participant-card') and position()='${params."Placement Number"}']"
       	}else if (params."Participant is the current user"){
        	verify.ID = "//DIV[contains(@class,'ideas-view-grid')]/DIV[contains(@class,'f-participant-card') and contains(@class,'f-participant-member')]"
       	}else{
        	verify.ID = "//DIV[contains(@class,'ideas-view-grid')]/DIV[contains(@class,'f-participant-card')]//DIV[contains(@class,'f-participant-user-info')]//DIV[contains(@class,'f-participant-name')]//DIV[contains(@class,'f-participant-name-header')]/*[normalize-space(.)='${params."Username"}']/../../../../../.."
        }
        xpath = verify.ID
        println("Verifying ${params."Username"}")
        
        if(params."Username"){verify.IDChildren << ".//DIV[contains(@class,'f-participant-user-info')]//DIV[contains(@class,'f-participant-name')]//DIV[contains(@class,'f-participant-name-header')]/*[normalize-space(.)='${params."Username"}']"}
        if(params."Profile Image"){verify.IDChildren << ".//DIV[contains(@class,'f-participant-user-info')]//DIV[contains(@class,'f-img-user')]/IMG"}
        if(params."Location"){verify.IDChildren << ".//DIV[contains(@class,'f-participant-user-info')]//DIV[contains(@class,'f-participant-name')]/*[normalize-space(.)='${params."Location"}']"}
        if(params."Available to join teams"){verify.IDChildren << ".//DIV[contains(@class,'f-participant-user-info')]//DIV[contains(@class,'actions')]//*[normalize-space(.)='${params."Available to join teams"}']"} 
        if(params."Expertise"){ 
            if(params."Number of Matches"!="0"){
                WebElement expertiseText = Elements.find(ID:xpath+"//DIV[contains(@class,'f-participant-expertise-container')]//DIV[contains(@class,'f-participant-expertise')]/P",Browser.Driver)
                assert (expertiseText.getText().replaceAll('\\s+',"").equals(params."Expertise".replaceAll("\\s+",""))), "Error - Unexpected Exprtise: ${expertiseText.getText().replaceAll('\\s+',"")}"
            }
            //verify.IDChildren << ".//DIV[contains(@class,'f-participant-expertise-container')]//DIV[contains(@class,'f-participant-expertise')]/*[contains(normalize-space(text()),'${expertise}')]"                
        }
        if(params."Projects"){
            if(params."Number of Matches"!="0"){
                WebElement projectText = Elements.find(ID:xpath+"//DIV[contains(@class,'f-participant-expertise-container')]//DIV[contains(@class,'f-participant-projects')]/P",Browser.Driver)
            	String[] actualProjects = projectText.getText().replaceAll('\\s+',"").split(',')
                String unexpectedProject = VerifyMatchingItems.run(expected:params."Projects".replaceAll('\\s+',"").split(","), actual:actualProjects, contains:false)
                assert unexpectedProject==null, "Error - Unxpected Project: ${unexpectedProject}"		
                //assert (projectText.getText().replaceAll('\\s+',"").equals(params."Projects".replaceAll("\\s+",""))), "Error - Unexpected Porjects: ${projectText.getText().replaceAll('\\s+',"")}"
            }
            //verify.IDChildren << ".//DIV[contains(@class,'f-participant-expertise-container')]//DIV[contains(@class,'f-participant-projects')]/*[contains(normalize-space(),'${project}')]"                
        }
        if(params."Certifications Count"){ 
            if(params."Certifications Count"=="0" && params."Number of Matches"!="0"){
                assert Exists.run(ID:xpath+"//DIV[contains(@class,'f-participant-expertise-container')][2]/DIV[not(contains(@class,'f-participant-certs'))]")==0, "Error - 'certification count should not be displayed"
            } else {
                verify.IDChildren << ".//DIV[contains(@class,'f-participant-expertise-container')]//DIV[contains(@class,'f-participant-certs')][contains(.,'Certifications (${params."Certifications Count"})')]"
            }              
        }
        if(params."Certifications"){ 
            if(params."Certifications"=="EMPTY" && params."Number of Matches"!="0"){
                assert Exists.run(ID:xpath+"//DIV[contains(@class,'f-participant-expertise-container')][2]/DIV[not(contains(@class,'f-participant-certs'))]")==0, "Error - 'certifications should not be displayed"
            } else {
                verify.IDChildren << ".//DIV[contains(@class,'f-participant-expertise-container')]//DIV[contains(@class,'f-participant-certs')]/P[.='${params."Certifications"}']"
            }              
        }
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}