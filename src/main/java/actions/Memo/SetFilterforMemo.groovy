package actions.Memo;

import actions.selenium.*

class SetFilterforMemo{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-tabs-header-container']//*[@class='f-tab-underline' and .='${params."Tab"}']")
        sleep(2000)
        
    }
}