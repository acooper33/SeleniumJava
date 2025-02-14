package actions.ViewIdea30;

import actions.selenium.Click

class SetActionItemTabinViewIdea3{
    public void run(def params){
        
        if(params."Tab"){
            Click.run(ID:"//*[contains(@class,'f-btn-link-animated f-btn-sm') and contains(.,'${params."Tab"}')]")
        }
        if(params."Click on Action Item Type"){
         Click.run(ID:"//*[@class='f-action-item-type' and text()='${params."Click on Action Item Type"}']")
            sleep(2000)
        }
    }
}