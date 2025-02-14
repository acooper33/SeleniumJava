package actions.PipelineSidebar;

import actions.selenium.*

class ExpandCollapsePipelineSidebarFolder{
    public void run(def params){
        if(params."Expand or Collapse"=="Expand"){
            if(Exists.run(ID:"//*[@id='sidebar-pipelines']//DIV[@class='content-folder-title' and text()='${params."Folder Name"}']/..//DIV[@class='fa fa-folder-o']")>0){Click.run(ID:"//*[@id='sidebar-pipelines']//DIV[@class='content-folder-title' and text()='${params."Folder Name"}']/..//DIV[@class='fa fa-folder-o']")}
        }
        else{
            if(Exists.run(ID:"//*[@id='sidebar-pipelines']//DIV[@class='content-folder-title' and text()='${params."Folder Name"}']/..//DIV[@class='fa fa-folder-open-o']")>0){Click.run(ID:"//*[@id='sidebar-pipelines']//DIV[@class='content-folder-title' and text()='${params."Folder Name"}']/..//DIV[@class='fa fa-folder-open-o']")}
        }
        sleep(1500)
    }
}