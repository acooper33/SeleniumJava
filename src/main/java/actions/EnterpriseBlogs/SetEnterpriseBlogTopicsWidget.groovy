package actions.EnterpriseBlogs;

import actions.selenium.*

class SetEnterpriseBlogTopicsWidget{
    public void run(def params){

        Click.run(ID:"//*[contains(@class,'enterprise_blog_topics_widget')]//A[contains(text(),'+ New Blog')]")
        SetText.run(ID:"//*[@id='blog_topic_title']",Text:params."Blog Topic")
        Click.run(ID:"//*[@value='${params."Action"}']")
    }
}
