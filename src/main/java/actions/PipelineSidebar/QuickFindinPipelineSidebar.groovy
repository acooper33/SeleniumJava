package actions.PipelineSidebar;

import actions.selenium.*

class QuickFindinPipelineSidebar{
    public void run(def params){
        Click.run(ID:"//*[@id='sidebar-image-search']")
        if(Exists.run(ID:"//*[@id='pipeline-search-input']")==0){Click.run(ID:"//*[@id='sidebar-image-search']")}
        SetText.run(ID:"//*[@id='pipeline-search-input']",Text:params."Quick Find Value")
        sleep(1500)
    }
}