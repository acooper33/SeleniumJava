package actions.PipelineDashBoard;

import actions.selenium.*

class VerifyIdeabyStatusinOverallTabinPipelineDashboard{
    public void run(def params){

        assert Exists.run(ID:"//*[@id='${params."Status"}']//*[@class='fractal-legend-count' and contains(.,'${params."Number of Ideas"}')]")==1,"Error - Incorrect count of Ideas"
    }
}