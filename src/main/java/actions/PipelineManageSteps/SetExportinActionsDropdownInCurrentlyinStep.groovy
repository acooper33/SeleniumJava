package actions.PipelineManageSteps;

import actions.selenium.Click

class SetExportinActionsDropdownInCurrentlyinStep{
    public void run(def params){
        
        Click.run(ID:"//*[@id='scores_actions_btn']")
        Click.run(ID:"//*[@id='export_idea_scores']")
        sleep(1000)
        if(params."Scorecard User Score Detail"){
            Click.run(ID:"//*[@id='export-multi-score']")
        }
        if(params."Scorecard Response Detail (Count)"){
            Click.run(ID:"//*[@id='export-scorecard-count']")
        }
        if(params."Scorecard Response Detail (Percentage)"){
            Click.run(ID:"//*[@id='export-scorecard-percentage']")
        }
        if(params."Scorecard Response Detail (Text)"){
            Click.run(ID:"//*[@id='export-scorecard-text']")
        }
        if(params."Scorecard Response Detail (Flag)"){
            Click.run(ID:"//*[@id='export-scorecard-flag']")
        }
        if(params."Action"){
            Click.run(ID:"//*[@class='bimodal-footer']//*[text()='${params."Action"}']")
        }
    }
}