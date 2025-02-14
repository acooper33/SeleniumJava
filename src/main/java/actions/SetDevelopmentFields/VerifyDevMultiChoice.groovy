package actions.SetDevelopmentFields;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class VerifyDevMultiChoice{
    public static void run(def params){
        if(params."Field Title"){
            //def answers = []
            def xpathCard = "//*[@id='proposal-content-sheet']//*[@id='questions']//*[@class='question-name' and contains(.,'${params."Field Title"}')]/..//INPUT[@checked]/following-sibling::LABEL[1]"
            def xpathAddtnlQstn = "//*[@id='additional-questions-container']//*[@class='question-title' and contains(.,'${params."Field Title"}')]/../following-sibling::DIV[@class='question-answer-wrapper']/DIV[@class='question-answer']"
            //if(params."Field Value"==null){assert answers.size()==0, "Error - Unexpected Number of Answers in ${params."Field Title"}"}
            //else {
                assert findMatch(params."Field Value", Elements.findAll(ID:xpathCard, Browser.Driver))==true, "Error - Expected Answer in Card Answers Not Found"
                assert findMatch(params."Field Value", Elements.findAll(ID:xpathAddtnlQstn, Browser.Driver))==true, "Error - Expected Answer in Additional Questions Not Found"
            //}
        }
    }
    private static boolean findMatch(String expectedValue, List<WebElement> actualValue){
        if(expectedValue==null){return (actualValue.size()==0)}
        if(!actualValue.size()==expectedValue.split(',').size()){return false}
        boolean matchFound=true
        for (int i=0; (i<expectedValue.split(',').size())&&matchFound; i++){
            matchFound=false
            actualValue.each{x ->
            	if(expectedValue.split(',')[i].trim().contains(x.getText().trim())){matchFound=true}
            }
        }
        return matchFound
    }
}