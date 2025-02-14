package actions.PipelineDashBoard;

import actions.selenium.*
    
class VerifyDetailstabontheSubmissionHoverinBusinessImpactTab{
    public void run(def params){

        if(params."Description"){
            assert Exists.run(ID:"//*[@id='idea-description-0']/DIV[contains(text(),'${params."Description"}')]")==1,"Error - Incorrect Description"
        }

        if(params."Status"){
            assert Exists.run(ID:"//*[@class='idea-status' and text()='${params."Status"}']")==1,"Error - Incorrect Description"
        }

        if(params."Date became Active"){
            assert Exists.run(ID:"//*[@class='idea-details-tab']//span[contains(text(),'Date became Active')]/../*[contains(text(),'${params."Date became Active"}')]")==1,"Error - Incorrect date"
        }

        if(params."Time in Stage"){
            assert Exists.run(ID:"//*[@class='idea-details-tab']//span[contains(text(),'Time in Stage')]/../*[contains(text(),'${params."Time in Stage"}')]")==1,"Error - Incorrect days in Stage"
        }

        if(params."Go to Project"==true){
            Click.run(ID:"//*[@class='idea-details-tab']//A","Type of Click":"Javascript")
        }
    }
}