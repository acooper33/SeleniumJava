package actions.PipelineSetup;

import actions.selenium.Exists
import actions.selenium.Click
import actions.selenium.ExecuteJavascript

class AddQuestionSaveFormScorecardTemlates{
    public void run(def params){
        if(params."Add Question"==true){
            println("Add Question==true")
            Click.run(ID:"//*[contains(@id,'question-btn')]", "Type of Click":"Javascript")
            sleep(2000)
            //ExecuteJavascript.run(Code:"window.scrollTo(100, 100);")
            //println("Scrolled")
            //sleep(5000)
        }
        if(params."Question to Edit"){
            Click.run(ID:"//*[@class='question_attributes']/H2[@class='eval_title' and contains(normalize-space(.),'${params."Question to Edit"}')]/../../*[@class='links']/A[@class='edit_link']")
            sleep(2000)
        }
        if(params."Question to Delete"){
            Click.run(ID:"//*[@class='question_attributes']/H2[@class='eval_title' and contains(normalize-space(.),'${params."Question to Delete"}')]/../../*[@class='links']/A[@class='delete_link']")
            sleep(2000)
        }
        
        if(params."Save Form"==true){
            Click.run(ID:"//*[@id='save-template-btn']")
            sleep(3000)
            
        } 
        
    }
}