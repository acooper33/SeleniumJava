package actions.Widgets;

import actions.selenium.*


class SetResponsetoUpdateFeedPost{
    public void run(def params){
        
        if(params."Update Feed Post"){
            def ID = "//DIV[@id='ws_updates_area']//DIV[contains(@id,'twork')]//DIV[text()='${params."Update Feed Post"}']"
            if(params.Action){
                def IDAction = ID+"/../..//DIV[@class='updates-timestamp']/DIV//A[text()='${params.Action}']"
                println("Printing ID: ${IDAction}")
                Click.run(ID:ID+"/../..//DIV[@class='updates-timestamp']/DIV//A[text()='${params.Action}']")
                if(params.Comment){
                    SetText.run(ID:ID+"/../..//DIV[contains(@id,'add_comment_textbox_div')]", Text:params.Comment, "Type of Clear":"Cut")
                    Click.run(ID:ID+"/../..//DIV[contains(@id,'display_add_comment_button')]//A[contains(@id,'comment_submit')]")
                }
                
            }
            
            //../..//DIV[@class='updates-timestamp']/DIV//A[text()='${params.Action}']
            
            //E24BD482-A4B6-11E8-AFEA-126F771A855E_add_comment_textbox_div
            
            //core_tworker_comment_pic
            
            
            
            
        }
        
    }
}