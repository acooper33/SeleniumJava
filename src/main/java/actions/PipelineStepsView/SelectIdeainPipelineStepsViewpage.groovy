package actions.PipelineStepsView;

import actions.selenium.Click
import java.util.List
import org.openqa.selenium.interactions.Actions 
import org.openqa.selenium.WebElement

class SelectIdeainPipelineStepsViewpage{
    public void run(def params){
        //Map all values that will be used for access of that instance
        def set = [:]
        //set.ID= "//*[@id='content-inside']/*[text()='${params."Idea Name"}']" 
        set.ID = "//*[@id='content-inside']/DIV//P[contains(.,'${params."Idea Name"}')]"       
        set.IDChildren = []
        //if(params."Idea ID"){verify.IDChildren << "./parent::DIV//*[text()='${params."Idea ID"}']"} 
        //if(params."Step Name idea belongs to"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/parent::DIV/parent::DIV/parent::DIV/parent::DIV/parent::DIV//SPAN[@class='step_header_name' and text()='${params."Step Name idea belongs to"}']"} 
        if(params."Idea ID"){set.IDChildren << ".//A[normalize-space()='${params."Idea ID"}']"}
        if(params."Step Name idea belongs to"){set.IDChildren << "./../../../../../../../../../..//SPAN[@class='step_header_name' and text()='${params."Step Name idea belongs to"}']"}
        if(params."Instance"){set."Instance"=params."Instance".toInteger()}
        
        Click.run(set) 

    }
}