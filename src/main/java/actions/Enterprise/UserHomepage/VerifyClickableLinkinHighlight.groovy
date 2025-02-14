package actions.Enterprise.UserHomepage;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.Exists
import actions.selenium.Click

class VerifyClickableLinkinHighlight{
    public void run(def params){
        
        def highlightsItems = []
        highlightsItems = Elements.findAll(ID:"//*[@class='f-activity-items']//li[@class='f-activity-item']", Browser.Driver)
        println("Sise of highlights: "+highlightsItems.size())
        
        if(params."Highlights Item Header"){
            def numOfMatches = 0
            def myIndex = 0
            def index = 0
            highlightsItems.each{item ->
                index++
                if(item.getText().trim().contains(params."Highlights Item Header".trim())){
                    //found our header
                    //get its position
                    //verify our link is there 
                    if (Exists.run(ID:"//*[@class='f-activity-items']//li[${index}]/*[@class='f-body-text']/A[.='${params."Clickable Link Text in Content to Verify"}']")){
                        myIndex = index
                        numOfMatches++
                    }
                }
        	    
        	}
            if(params."Number of Matches"){assert numOfMatches==params."Number of Matches".toInteger(),"Error - Number of Matches is Incorrect"}
            if(params."Click on it?"){Click.run(ID:"//*[@class='f-activity-items']//li[${myIndex}]/*[@class='f-body-text']/A[.='${params."Clickable Link Text in Content to Verify"}']")}

        }
    }
}