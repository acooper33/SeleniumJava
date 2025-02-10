package actions.common;

import actions.selenium.*
    
class ActionItems{
    public static void SwitchToItemList(def params){
        //List = 'My Action Items' or 'Action Items Manager'
        
        if(params."List"=="My Action Items"){
            if(Exists.run(ID:"//*[@id='action_item_header_breadcrumb' and contains(.,'My Action Items')]")==0){
                Click.run(ID:"//*[@id='action_item_switch_scope']")
                sleep(1500)
            }
        } else if(params."List"=="Initiative Action Items Manager"){
             if(Exists.run(ID:"//*[contains(@class,'fractal-adminNav-selected-btn')]/*[@id='fractal-adminNav-selected-text' and text()='Action Items Manager']")==0){
                Click.run(ID:"//*[@id='fractal-adminNav-selected-btn']")
                Click.run(ID:"//*[contains(@class,'backbone-link') and .='Action Items Manager']")
                sleep(1500)
             } 
        } else {
            if(Exists.run(ID:"//*[@id='action_item_header_breadcrumb' and contains(.,'Action Items Manager')]")==0){
                Click.run(ID:"//*[@id='action_item_switch_scope']")
                sleep(1500)
            }
        }
    }
}