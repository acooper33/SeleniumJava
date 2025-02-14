package actions.EnterpriseBlogs;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import java.util.List

class VerifyNumberofBlogTopics{
    public void run(def params){

        def blogListRecords = []
        def blogPostRecords = []
        blogListRecords = Elements.findAll(ID:"//*[@id='ent_blog_topic_list']/DIV", Browser.Driver)
        blogPostRecords = Elements.findAll(ID:"//*[@id='blogsubject']", Browser.Driver)
        if(params."Total Number of Blog List Records"){assert blogListRecords.size()==params."Total Number of Blog List Records".toInteger(), "Error - number of blog list records is ${blogListRecords.size()}"}
        if(params."Total Number of Blog Post Records"){assert blogPostRecords.size()==params."Total Number of Blog Post Records".toInteger(), "Error - number of blog post records is ${blogPostRecords.size()}"}

    }
}