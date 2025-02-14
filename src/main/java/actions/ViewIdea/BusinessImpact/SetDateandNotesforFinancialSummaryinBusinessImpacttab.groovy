package actions.ViewIdea.BusinessImpact;

import actions.selenium.Click
import actions.selenium.SetText

class SetDateandNotesforFinancialSummaryinBusinessImpacttab{
    public void run(def params){

        if(params."Date"){
            SetText.run(ID:"//*[@id='financial-impact-start-date']",Text:params."Date","Type of Clear":"Cut")
            Click.run(ID:"//*[@class='datepicker-label']")}
        if(params."Notes"){
            SetText.run(ID:"//*[@id='financial-impact-notes']",Text:params."Notes")
        }
        if(params."Revision History"){
            Click.run(ID:"//*[contains(@class,'financial-impact-versions')]//span[@class='chevron bottom']")
            Click.run(ID:"//*[@class='fractal-droplist financial-impact-versions-droplist']//SPAN[contains(text(),'${params."Revision History"}')]")
            sleep(2000)
        }
    }
}