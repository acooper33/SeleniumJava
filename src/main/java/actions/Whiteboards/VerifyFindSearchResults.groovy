package actions.Whiteboards;

import screens.WhiteboardLocators
import actions.selenium.*

class VerifyFindSearchResults{
    public void run(def params){
        
        println("FindSearchResultsXpath: ${WhiteboardLocators.findResults}")
        //VerifyText.run(ID:"//*[contains(@class,'f-text-search-footer-text')]",Text:params."ExpectedValue" + " results")
        VerifyText.run("ID Type":"By",By:WhiteboardLocators.findResults,Text:params."ExpectedValue" + " results")
    }
}