package actions.EnterpriseBlogs;

import actions.selenium.Click

class DeleteBlogTopicFromEnterpriseBlogList{
    public void run(def params){
        
        Click.run(ID:"//*[@id='ent_blog_topic_list']//A[text()='${params."Blog to be Deleted"}']")
        Click.run(ID:"//*[contains(@class,'widget_container enterprise_blog_list_widget')]//A[text()='Delete']")
        Click.run(ID:"//*[@id='gen_message_popup']//INPUT[@value='OK']")
    }
}