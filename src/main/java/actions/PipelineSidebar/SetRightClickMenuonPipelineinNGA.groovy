package actions.PipelineSidebar;

import actions.selenium.RightClick
import actions.selenium.Click
import actions.PipelineSetup.SetLeftSideTabInPipelineSetup

class SetRightClickMenuonPipelineinNGA{
    public void run(def params){
        
        RightClick.run(ID:"//*[@id='sidebar-pipelines']//*[@class='content-item-title' and text()='${params."Pipeline"}']/..")
        sleep(2000)
        Click.run(ID:"//*[@id='right-click-menu-template']//*[text()='${params."Option"}']/..")
        sleep(3000)
        if(params."Setup Tab Option"){
            SetLeftSideTabInPipelineSetup.run(Tab:params."Setup Tab Option")
        }        
    }
}