package actions.EnterpriseBlogs;

import actions.selenium.Click

class DeleteBlogFromEnterpriseViewBlog{
    public void run(def params){
        
        Click.run(ID:"//*[@id='quoteAlt1']//A[contains(@href,'delete_blog')]")
    }
}