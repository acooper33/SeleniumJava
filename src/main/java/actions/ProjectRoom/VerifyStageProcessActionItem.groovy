package actions.ProjectRoom;

import actions.selenium.Exists

class VerifyStageProcessActionItem{
    public void run(def params){
        
        if(params."Stage or Gate Name"){
            assert Exists.run(ID:"//*[@class='f-stage-title' and text()='${params."Stage or Gate Name"}']")==1, "Error - Incorrect stage or gate name"
        }
        if(params."Stage Heading"){
            def stageHeadings = params."Stage Heading".split(",")
            for (stageHeading in stageHeadings) {
                if (stageHeading.contains("due")) {
        			assert Exists.run(ID:"//*[@class='f-stage-reviews']/SPAN[contains(@class,'f-stage')]/../SPAN[2][contains(.,'${stageHeading}')]")==1,"Error - Stage/Gate Review has incorrect due date for ${stageHeading}"
                } else {
                    assert Exists.run(ID:"//*[@class='f-stage-reviews']//SPAN[contains(@class,'f-stage') and text()='${stageHeading}']")==1,"Error - Incorrect stage/gate review message for ${stageHeading}"
                }
            }
        }
        if(params."Due Date"){
            if(params."Due Date"=="EMPTY"){
                assert Exists.run(ID:"//*[@class='f-stage-reviews']/SPAN[contains(@class,'f-stage')][2]")==0, "Error - Stage/Gate Review should be empty but is not"
            } else {
                assert Exists.run(ID:"//*[@class='f-stage-reviews']/SPAN[contains(@class,'f-stage')]/../SPAN[2][.='${params."Due Date"}']")==1, "Error - Incorrect stage/gate review message"
            }
        }
        if(params."Stage or Gate Review Assigned To"){
             params."Stage or Gate Review Assigned To".split(',').each{items ->
                assert Exists.run(ID:"//*[@class='f-stage-assigned-to']/..//A[text()='${items}']")==1, "Error - ${items} not found"
            }
        }
        if (params."Items within Stage") {
            params."Items within Stage".split(',').each{items ->
                assert Exists.run(ID:"//*[@class='f-stage-item-list']/LI[text()='${items}']")==1, "Error - ${items} not found"
            }
        }
        if(params."Scorecard"){
            if(params."Scorecard"=="EMPTY"){
                assert Exists.run(ID:"//*[@class='f-gate-container']/SPAN[1]")==0, "Error - scorecard should be empty but is not"
            } else {
                assert Exists.run(ID:"//*[@class='f-gate-header']/..//*[text()='${params."Scorecard"}']")==1, "Error - Incorrect scorecard message"
            }
        }        
    }
}