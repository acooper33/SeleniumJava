package actions.EnterpriseBlogs;

import actions.selenium.SetText
import actions.selenium.Click

class AddCommentinEnterpriseViewBlog{
    public void run(def params){

        SetText.run(ID:"//*[@id='comment']",Text:params.Comment)
        Click.run(ID:"//*[@id='button_add_comment']")
        sleep(2000)
    }
}