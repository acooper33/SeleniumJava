package actions.Enterprise.UserHomepage;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.Click
import java.lang.Math
import java.util.ArrayList
import actions.selenium.ExecuteJavascript

class VerifyHighlightsItemonUserHomepage{
    public void run(def params){
        
        def highlightsItems = []
        highlightsItems = Elements.findAll(ID:"//*[@class='f-activity-items']//li[@class='f-activity-item']", Browser.Driver)
        if(params."Total Number of Items"){assert highlightsItems.size()==params."Total Number of Items".toInteger(), "Error - total number of items is ${highlightsItems.size()}"}

        if(params."Highlights Item Header"){
            def numOfMatches = 0
            highlightsItems.each{item -> 
                if(item.getText().trim().contains(params."Highlights Item Header".trim())){
                    if(params."Highlights Item Content"){
                        if(item.getText().trim().contains(params."Highlights Item Content".trim())){
                        	numOfMatches++
                         }
                    }else{
                    	numOfMatches++
                    }
            	}
        	
        	}
            if(params."Number of Matches"){assert numOfMatches==params."Number of Matches".toInteger(),"Error - Number of Matches is Incorrect"}
         }
	}
}
