package actions.ViewIdea.BusinessImpact;

import actions.selenium.Exists

class VerifyDateandNotesforFinancialSummaryinBusinessImpactTab{
    public void run(def params){

        if(params.Date){
            assert Exists.run(ID:"//*[@class='financial-impact-date' and contains(.,'${params.Date}')]")==1,"Error - Incorrect Date ${params.Date}"
        }
        if(params.Notes){
            if(params.Notes == "<EMPTY>") {
                assert Exists.run(ID:"//*[@class='financial-impact-notes financial-impact-notes-preview' and contains(.,'')]")==1,"Error - Notes is not null"
            } else {
                assert Exists.run(ID:"//*[contains(@class,'notes') and contains(.,'${params.Notes}')]")==1,"Error - Incorrect Date ${params.Notes}"
            }
        }
    }
}