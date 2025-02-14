package actions.ViewIdea30;

import actions.SetScorecardFields.SetMultiChoiceOneAnswer
import actions.selenium.Click

class SetGeneralEvaluationScorecardforIdeainViewIdea3{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-scorecard-show-btn')]")
        if(params."What is the strategic impact"){
            SetMultiChoiceOneAnswer.run("Page":"View Idea3", "Field Name":"What is the strategic impact/alignment with our enterprise objectives?", "Field Value":params."What is the strategic impact")  
        }
        if(params."What is the likely timeframe to implement this idea?"){
            SetMultiChoiceOneAnswer.run("Page":"View Idea3", "Field Name":"What is the likely timeframe to implement this idea?", "Field Value":params."What is the likely timeframe to implement this idea?")   
        }
        if(params."What is the estimated level of enterprise benefit?"){
            SetMultiChoiceOneAnswer.run("Page":"View Idea3", "Field Name":"What is the estimated level of enterprise benefit?", "Field Value":params."What is the estimated level of enterprise benefit?")  
        }
        if(params."What resource level would need to be dedicated to implement the idea?"){
            SetMultiChoiceOneAnswer.run("Page":"View Idea3", "Field Name":"What resource level would need to be dedicated to implement the idea?", "Field Value":params."What resource level would need to be dedicated to implement the idea?")  
        }
        if(params."What is the revenue potential of the idea?"){
            SetMultiChoiceOneAnswer.run("Page":"View Idea3", "Field Name":"What is the revenue potential of the idea?", "Field Value":params."What is the revenue potential of the idea?") 
            
        }
        Click.run(ID:"//*[contains(@class,'f-scorecard-submit')]")       
        sleep(2000)
    }
}