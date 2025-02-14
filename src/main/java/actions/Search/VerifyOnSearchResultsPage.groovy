package actions.Search;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click


import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By


class VerifyOnSearchResultsPage{
    public void run(def params){
        def verify = [:]
        WebElement metaTitle = Browser.Driver.findElement(By.xpath("//*[contains(@class,'metadata-title')]"))
        println("Here is your text: ${metaTitle.getText()}")
        metaTitle = Browser.Driver.findElement(By.xpath("//*[contains(@class,'metadata-title')and .='${params."Item Type Title"}']/../../DIV"))
        println("Here is your Item Title: ${metaTitle.getText()}")
        if(params."Item Type Title"){
             verify.ID = "//*[contains(@class,'metadata-title')and .='${params."Item Type Title"}']/../..//*[contains(@class,'result-title') and contains(.,'${params."Item Title"}')]"  
        } else {
            verify.ID = "//*[contains(@class,'result-title') and contains(.,'${params."Item Title"})]"    
        }
        verify.IDChildren = []
        if(params."Description"){verify.IDChildren << "./../..//*[contains(@class,'search-result-description') and contains(.,'${params."Description"}')]"}
        if(params."Type Icon"){verify.IDChildren << "./..//*[contains(@class,'search-result-metadata')]//I[contains(@class,'${params."Type Icon"}')]"}
        if(params."Idea Code"){verify.IDChildren << "./..//*[contains(@class,'search-result-metadata')]//*[contains(@class,'metadata-idea-code') and .='${params."Idea Code"}']"}
        if(params."Submitter"){verify.IDChildren << "./..//*[contains(@class,'search-result-metadata')]//*[contains(@class,'submitter') and .='${params."Submitter"}']"}
        if(params."Campaign Name"){verify.IDChildren << "./..//*[contains(@class,'search-result-metadata')]//*[contains(@class,'metadata-campaign-name') and .='${params."Campaign Name"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
        if(params."Click on the result" == true){
            Click.run(verify)
        }
        
        
        
    }
}