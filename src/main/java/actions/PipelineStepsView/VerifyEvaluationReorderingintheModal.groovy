package actions.PipelineStepsView;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyEvaluationReorderingintheModal{
    public void run(def params){
        
        def verify = [:]
        if(params."Order"){verify.ID = "//*[@id='table-body-row-${params."Order".toInteger()-1}-cell-1']/..//*[contains(@class,'f-reorder-project-name') and .='${params."Project Name"}']"}	
        else{verify.ID = "//*[contains(@class,'f-reorder-project-name') and .='${params."Project Name"}']"}
        
        verify.IDChildren = []
        if(params."Idea Image" !=null){
            def img
            if(params."Idea Image"){img = "//*[contains(@id,'cell-2')]//*[contains(@src, '/ct/getfile.php')]"}
            else {img = "//*[contains(@id,'cell-2')]//*[contains(@src, 'default-idea-image.jpg')]"}
            verify.IDChildren << "./..${img}"
            println("img:'${img}'")
        }
        if(params."Completed Evaluations"){verify.IDChildren << "./../*[contains(@id,'cell-3') and .='${params."Completed Evaluations"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify) 
    }
}
