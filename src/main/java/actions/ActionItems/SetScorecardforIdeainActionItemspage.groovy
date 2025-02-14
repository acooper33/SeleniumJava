package actions.ActionItems;

import actions.selenium.Click
import actions.selenium.Exists
import actions.ActionItems.SetGeneralEvaluationScorecardforIdeainActionItemspage
import actions.selenium.Browser
import org.openqa.selenium.JavascriptExecutor
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement


//remove this script once done with scorecard

class SetScorecardforIdeainActionItemspage{
    public void run(def params){
        //skip the tour (if there is option to take the tour)
        SetGeneralEvaluationScorecardforIdeainActionItemspage.skipTourScorecard()
    	sleep(3000)
        /*
        if(params."Multi Choice One Answer - Question"){
            //def question = [:]
            //question.ID = "//DIV[@id='action_item_scorecard_container']//FORM[@id='proposal_scorecard_form']//OL[@id='evalution_question_list']/LI[@class='eval_question//H2[@class='eval_title' and contains(text(),'${params."Multi Choice One Answer - Question"}')]']"
            def xPath = "//DIV[@id='action_item_scorecard_container']//FORM[@id='proposal_scorecard_form']//OL[@id='evalution_question_list']/LI[@class='eval_question']//H2[@class='eval_title' and contains(.,'${params."Multi Choice One Answer - Question"}')]"
            println("My params: ${params."Multi Choice One Answer - Answer(s)"}")
            if(params."Multi Choice One Answer - Answer(s)"){
                params."Multi Choice One Answer - Answer(s)".split(',').each{value ->
                    println("Setting ${value}")
                    def xPath1 = "${xPath}/following-sibling::DIV[@class='choice_div']/DIV[@class='choice_label_parent']/SPAN[contains(text(),${value})]/../../DIV[@class='choice_input_parent']/input"
					//def xPath1 = "${xPath}/following-sibling::DIV[@class='choice_div']/DIV[@class='choice_label_parent']/SPAN[contains(text(),${value})]"
                    println(xPath1)
                    SendKeys.run(ID:xPath1, Key:ENTER)
                    //Click.run(ID:xPath1)
                    //Click.run(ID:xPath1) 
                    
                    WebElement element = Elements.find(ID:xPath1,Browser.Driver)
                    JavascriptExecutor executor = (JavascriptExecutor) Browser.Driver;
                    
                    //WebElement element=Element.findElement(By.xpath("//span[@class='radio_state']"));
        			//JavascriptExecutor executor = (JavascriptExecutor) driver;
        			executor.executeScript("arguments[0].click();", element);
       				// System.out.println("Tried to click One Way");
                }
            }
        }
        */
        if(params."Multi Choice One Answer - Question"){
            def xPath = "//DIV[@id='action_item_scorecard_container']//FORM[@id='proposal_scorecard_form']//OL[@id='evalution_question_list']/LI[@class='eval_question']//H2[@class='eval_title' and contains(.,'${params."Multi Choice One Answer - Question"}')]"
            def xPath1 = "${xPath}/../..//*[@class='radio_label' and text()='two']/../../input"
            Click.run(ID:xPath1)
        }
        Click.run(ID:"//*[@id='commit_scorecard_button1']")
        sleep(2000)
    }    
}
