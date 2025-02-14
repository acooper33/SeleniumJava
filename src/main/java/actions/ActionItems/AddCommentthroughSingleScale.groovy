package actions.ActionItems;

import actions.selenium.Click

class AddCommentthroughSingleScale{
    public void run(def params){
        Click.run(ID:"//*[@id='idea_sme_comment_btn']")
    }
}