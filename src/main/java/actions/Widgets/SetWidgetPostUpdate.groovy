package actions.Widgets;

import actions.selenium.*

class SetWidgetPostUpdate{
    public void run(def params){
        Click.run(ID:"//*[@id='post_twork_textbox_inner_div']")
        SetText.run(ID:"//*[@id='post_twork_textbox_inner_div']",Text:params."What are you working on")
        Click.run(ID:"//*[@id='postTworkBtnSpan']/DIV[4]")
    }
}