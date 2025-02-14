package actions.ViewIdea;

import actions.common.ViewIdeaCommon
import actions.selenium.Exists
import actions.selenium.GetText

class VerifyEvaluationstabRibboninVewIdeapage{
    public void run(def params){

        if(params."Click on Evaluation Tab on View Idea 2"==true || params."Click on Evaluation Tab on View Idea 2"==null){
            ViewIdeaCommon.NavigateTab(Tab:"Evaluations", "Type of Click":"Javascript")
        }        
        def position
        if(params."Position Number"==null){
            position=1
        } else {
            position=params."Position Number"
        }
        if(params."Overall Score"){
           assert GetText.run(ID:"//*[@class='fractal-widget-evaluation-instance'][${position}]//DIV[@class='ribbonWrapper']/DIV[@class='ribbonBox']").replaceAll("\\s","").contains(params."Overall Score".replaceAll("\\s","")), "Error - Overall Score incorrect"
        }
        if(params."Total Evaluation"){
            assert GetText.run(ID:"//*[@class='fractal-widget-evaluation-instance'][${position}]//DIV[@class='ribbonWrapper']/DIV[@class='progress']").replaceAll("\\s","").contains(params."Total Evaluation".replaceAll("\\s","")), "Error - Total Evaluation incorrect"
        }
        if(params."Completed Evaluation"){
           assert GetText.run(ID:"//*[@class='fractal-widget-evaluation-instance'][${position}]//DIV[@class='ribbonWrapper']/DIV[@class='ribbonBox'][2]").replaceAll("\\s","").contains(params."Completed Evaluation".replaceAll("\\s","")), "Error - Completed Evaluation incorrect"
        }
    }
}