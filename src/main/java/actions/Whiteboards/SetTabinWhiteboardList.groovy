package actions.Whiteboards;

import actions.selenium.*

class SetTabinWhiteboardList{
    public void run(def params){
        
        Click.run(ID:"//*[@class='fractal-widget-canvases']//*[@class='f-tabs-header-container']//*[@class='f-tab-underline' and .='${params."Tab"}']")
        
    }
}