package actions.ActionItems;

import actions.selenium.Click
import actions.selenium.Exists

class SetJudgingforIdeainActionItemspage{
    public void run(def params){
        
         if(Exists.run(ID:"//*[@class='tour-tip']//*[text()='Start Quick Tour']",Timeout:4)>0){
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Start Quick Tour']")
            sleep(500)
            Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
            sleep(500)
            if(Exists.run(ID:"//*[contains(text(),'Skip Tour')]",Timeout:2)>0){
                Click.run(ID:"//*[contains(text(),'Skip Tour')]")
            }
            else{
                Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
                sleep(500)
                Click.run(ID:"//*[@class='tour-tip']//*[text()='Next']")
                sleep(500)
                Click.run(ID:"//*[@class='tour-tip']//*[text()='Finish']")
            }
        }
        
        if(params."What is the strategic impact"){Click.run(ID:"//*[@id='evalution_question_list']/LI[1]/H2[1]/..//*[@class='radio_label' and text()='${params."What is the strategic impact"}']/../..//INPUT")}
        if(params."What is the likely timeframe to implement"){Click.run(ID:"//*[@id='evalution_question_list']/LI[2]/H2[1]/..//*[@class='radio_label' and text()='${params."What is the likely timeframe to implement"}']/../..//INPUT")}
        if(params."What is the estimated level of enterprise benefit"){Click.run(ID:"//*[@id='evalution_question_list']/LI[3]/H2[1]/..//*[@class='radio_label' and text()='${params."What is the estimated level of enterprise benefit"}']/../..//INPUT")}
        if(params."What resource level would need to be dedicated"){Click.run(ID:"//*[@id='evalution_question_list']/LI[4]/H2[1]/..//*[@class='radio_label' and text()='${params."What resource level would need to be dedicated"}']/../..//INPUT")}
        if(params."What is the revenue potential of the idea"){Click.run(ID:"//*[@id='evalution_question_list']/LI[5]/H2[1]/..//*[@class='radio_label' and text()='${params."What is the revenue potential of the idea"}']/../..//INPUT")}
        
        Click.run(ID:"//*[@id='commit_scorecard_button']")
        sleep(2000)
    }
}