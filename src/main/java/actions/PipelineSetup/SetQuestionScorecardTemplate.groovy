package actions.PipelineSetup;

import actions.selenium.SelectItem
import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SetText

class SetQuestionScorecardTemplate{
    public void run(def params){
        if(params."Question Type"){SelectItem.run(ID:"(//*[contains(@class,'setup-scorecard-question')]//SELECT[@name='type'])[${params."Added Question Order Number"}]", "Visible Text":params."Question Type")}
        SetCheckBox.run(ID:"(//*[contains(@class,'setup-scorecard-question')]//INPUT[@name='required'])[${params."Added Question Order Number"}]", Check:params."Required to Answer")
        if(params."Question"){SetText.run(ID:"(//*[contains(@class,'setup-scorecard-question')]//INPUT[@name='title'])[${params."Added Question Order Number"}]", Text:params."Question")}
        if(params."Short Name"){SetText.run(ID:"(//*[contains(@class,'setup-scorecard-question')]//INPUT[@name='short_question'])[${params."Added Question Order Number"}]", Text:params."Short Name")}
        if(params.Tooltip){SetText.run(ID:"(//*[contains(@class,'setup-scorecard-question')]//INPUT[@name='tooltip'])[${params."Added Question Order Number"}]", Text:params.Tooltip)}
        if(params.Answers){
            params.Answers.split(",").eachWithIndex{value, x ->
                if(x>2){Click.run(ID:"(//*[contains(@class,'setup-scorecard-question')]//DIV[@id='add_answer_link']/A)[${params."Added Question Order Number"}]")}
                SetText.run(ID:"(//*[contains(@class,'setup-scorecard-question')][${params."Added Question Order Number"}]//INPUT[contains(@name,'option')])[${x+1}]",Text:value)
            }
        }
        if(params.Points){
            params.Points.split(",").eachWithIndex{value, x ->
                SetText.run(ID:"(//*[contains(@class,'setup-scorecard-question')][${params."Added Question Order Number"}]//INPUT[contains(@name,'point')])[${x+1}]", Text:value) 
            }
        }
        if(params.Action=='Save'){
            Click.run(ID:"(//*[contains(@class,'setup-scorecard-question')]//DIV[contains(@class,'save_btn')])[${params."Added Question Order Number"}]")
        }
        else if(params.Action=='Cancel'){Click.run(ID:"(//*[contains(@class,'setup-scorecard-question')]//A[@class='cancel_link'])[${params."Added Question Order Number"}]")}
    }
}