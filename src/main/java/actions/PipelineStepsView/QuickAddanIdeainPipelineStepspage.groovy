package actions.PipelineStepsView;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.ExplicitWait

class QuickAddanIdeainPipelineStepspage{
    public void run(def params){
        Click.run(ID:"//*[@id='quick-idea-add-btn']")
        ExplicitWait.run(ID:"//*[@id='quick-idea-title']") 
        SetText.run(ID:"//*[@id='quick-idea-title']",Text:params."Title")
        sleep(3000)
        if(params.Action){
            if(params.Action=="Cancel"){Click.run(ID:"//*[@id='quick-add-popup']//*[text()='Cancel']")}
            else{Click.run(ID:"//*[@id='quick-add-popup']//*[text()='Submit']")}
            sleep(5500)
        }
    }
}