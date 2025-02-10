package actions.PipelineStepsView;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.*
    
class VerifyStepinPipelineStepspage{
    public void run(def params){
        //Map all values that will be used for verification for that instance
        def verify = [:]
        verify.ID= "//SPAN[@class='step_header_name' and text()='${params."Step Name"}']"        
        verify.IDChildren = []
        if(params."Stage Name step belongs to"){verify.IDChildren << "./../../../../../../DIV[contains(@class,'stage_name')]//DIV[text()='${params."Stage Name step belongs to"}']"} 
        if(params."Number of Ideas in a step"){verify.IDChildren << "./../SPAN[@class = 'step_header_count' and text()='(${params."Number of Ideas in a step"})']"} 
        if(params."Step Status"){
            switch(params."Step Status"){
                case "Automatic":
                	verify.IDChildren << "./../DIV[@class = 'indicator-icons']/DIV[contains(@class,'fa-clock-o')]"	
                	break
                case "Configured":
                println("test")
                	verify.IDChildren << "./../DIV[@class = 'indicator-icons']/DIV[contains(@class,'fa-check-circle')]"	
            		break
                case "Not Configured":
        			verify.IDChildren << "./../DIV[@class = 'indicator-icons']/DIV[contains(@class,'fa-exclamation-circle')]"	
                	break
                case "Locked":
        			verify.IDChildren << "./../DIV[@class = 'indicator-icons']/DIV[contains(@class,'fa-lock')]"	
                	break
            }
        }
        if(params."Step Description"){
            MouseOver.run(ID:verify.ID+"/..//*[contains(@class,'fa fa-info-circle')]")
            verify.IDChildren << "./../../../../../../../../../../../../../../..//*[@class='tooltip fade bs-tooltip-right show']//*[contains(text(),'${params."Step Description"}')]"} 
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)
    }
}