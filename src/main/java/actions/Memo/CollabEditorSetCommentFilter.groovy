package actions.Memo;

import actions.selenium.Click

class CollabEditorSetCommentFilter{
    public void run(def params){
    	if(params."Click Open/Close Comments in Top Bar"!=null){Click.run(ID:"//DIV[@class='f-memo-top-bar-right']//BUTTON[contains(@class,'f-comment-open-btn')]")}
        sleep(1000)
        if(params."Filter Option"){
            Click.run(ID:"//*[@class='f-slate-all-comments-list']//DIV[contains(@class,'fractal-clickoutside')]//DIV[contains(@class,'f-dropdown-btn')]//*[@class='fal fa-sliders-h']")
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]//LI[contains(.,'${params."Filter Option"}')]")
        }   
    }
}