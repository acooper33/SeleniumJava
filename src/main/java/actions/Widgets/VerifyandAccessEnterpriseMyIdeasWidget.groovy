package actions.Widgets;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click
import actions.selenium.Exists

class VerifyandAccessEnterpriseMyIdeasWidget{
    public void run(def params){

        def verify = [:]
        verify.ID = "//*[@id='my_ideas_container']/A[text()='${params."Idea Name"}']"        
        if(params."Status"){assert Exists.run(ID:"//*[@id='my_ideas_container' and contains(text(),'${params."Status"}')]/A[text()='${params."Idea Name"}']") == 1 ,"Error - Incorrect Status"}
        if(params."Comment Count"){assert Exists.run(ID:"//*[@id='my_ideas_container' and contains(text(),'${params."Comment Count"}')]/A[text()='${params."Idea Name"}']") == 1,"Error - Incorrect Comment Count"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)        
        if(params."Access the Idea Name"==true){
            Click.run(ID:"//*[@id='my_ideas_container']/A[text()='${params."Idea Name"}']")}
    }
}
