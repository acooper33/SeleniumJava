package actions.PipelineSidebar;

import actions.selenium.*

class AddRemoveArchiveforPipelineinPipelineSidebar{
    public void run(def params){
        if(params."Add or Remove Archive"=="Add"){
            Click.run(ID:"//*[@id='sidebar-filter-wrapper']/DIV[text()='All']")
        }
        else{
            Click.run(ID:"//*[@id='sidebar-filter-wrapper']/DIV[text()='Archived']")
        }
        RightClick.run(ID:"//*[@id='sidebar-pipelines']//DIV[text()='${params."Pipeline Name"}']")
        Click.run(ID:"//*[@id='right-click-menu-template']//I[@class='fa fa-archive']")
        sleep(2000)
    }
}