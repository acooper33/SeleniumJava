package actions.PipelineSidebar;

import actions.selenium.*
import actions.PipelineStepsView.SetDeleteIdea

class DeletePipelineorFolderinPipelineSidebar{
    public void run(def params){
        
        sleep(3000)
        RightClick.run(ID:"//*[@id='sidebar-pipelines']//DIV[text()='${params."Pipeline or Folder Name"}']")
        Click.run(ID:"//*[@id='right-click-menu-template']//DIV[text()='Delete']")
        /*
        if(params."Action"){
        	//SetCheckBox.run(ID:"//*[@id='confirm-pipeline-delete-checkbox']",Check:params."I understand")
        	//if(params."Action"=="Cancel"){Click.run(ID:"//*[@class='bimodal-secondary' and text()='Cancel']")}
        	//else{Click.run(ID:"//*[@id='bi-modal-button']/*[text()='Delete']")}
        }*/
        sleep(2000)
    }
}