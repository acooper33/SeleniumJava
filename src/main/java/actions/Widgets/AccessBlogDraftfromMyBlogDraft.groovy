package actions.Widgets;

import actions.selenium.Click

class AccessBlogDraftfromMyBlogDraft{
    public void run(def params){
        
        Click.run(ID:"//*[@id='my_blog_drafts_container']//A[contains(text(),'${params."Blog Draft"}')]")
    }
}