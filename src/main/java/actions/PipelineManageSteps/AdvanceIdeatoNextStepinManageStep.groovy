package actions.PipelineManageSteps;

import actions.selenium.SetCheckBox
import actions.selenium.Click

class AdvanceIdeatoNextStepinManageStep{
    public void run(def params){
        //select the idea
        if(params."Idea Name"){
            SetCheckBox.run(ID:"//*[@class='title-cell sortable renderable' and text()='${params."Idea Name"}']/../*[@class='select-row-cell renderable']/input",Check:true)
        }
        //click on advance to the next step button
        Click.run(ID:"//*[@id='advance-ideas-btn']")
        if(params."Action"=="Advance Ideas"){
            Click.run(ID:"//*[@class='bi_modal']//*[@id='bi-modal-button']")
        }
        else if(params."Action"=="Cancel"){
            Click.run(ID:"//*[@class='bi_modal']//A[@class='bimodal-secondary' and text()='Cancel']")
        }
    }
}