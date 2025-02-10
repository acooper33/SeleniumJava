package actions.PipelineSetup;

import actions.selenium.SelectItem
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SetText


class SetMultiChoiceDropdownQuestionScorecardTemplate{
    public void run(def params){
        if(params."Question Type"){SelectItem.run(ID:"//SELECT[@name='type']", "Visible Text":params."Question Type")}
        SetCheckBox.run(ID:"//INPUT[@name='required']", Check:params."Required to Answer")
        if(params."Question"){SetText.run(ID:"//INPUT[@name='title']", Text:params."Question")}
        if(params."Short Name"){SetText.run(ID:"//INPUT[@name='short_question']", Text:params."Short Name")}
        if(params.Tooltip){SetText.run(ID:"//INPUT[@name='tooltip']", Text:params.Tooltip)}
        if(params.Answers){
            params.Answers.split(",").eachWithIndex{value, x ->
                println("Answers: Your X: ${x}")
                println("your value: ${value}")
                if(x>2){Click.run(ID:"//DIV[@id='add_answer_link']/A")}
                SetText.run(ID:"(//DIV[@class='answers']/DIV/INPUT[contains(@name,'option')])[${x+1}]", Text:value)                                   
            }
        }
        if(params.Points){
            params.Points.split(",").eachWithIndex{value, x ->
            	println("Seeting Points")
                println("Your X: ${x}")
                println("your value: ${value}")
                SetText.run(ID:"(//DIV[@class='answers']/DIV/INPUT[contains(@name,'point')])[${x+1}]", Text:value) 
            }
        }
        if(params.Action=='Save'){
            Click.run(ID:"//DIV[contains(@class,'save_btn')]")
        }
        else if(params.Action=='Cancel'){Click.run(ID:"//A[@class='cancel_link']")}
    }
}