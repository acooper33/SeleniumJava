package actions.EnterpriseBlogs;

import actions.selenium.Exists

class VerifyEnterpriseViewBlog{
    public void run(def params){

        if(params."Title"){assert Exists.run(ID:"//*[@id='blogsubject' and text()='${params."Title"}']") == 1,"Error - Incorrect Title ${params."Title"}"}
        if(params."Topic"){assert Exists.run(ID:"//*[@id='blog_title_small']/a[contains(text(),'${params."Topic"}')]") == 1,"Error - Incorrect Topic for ${params."Title"}"}
        if(params."Posted By"){assert Exists.run(ID:"//*[@id='blog_title_small']/a[@class='user-flyover' and contains(text(),'${params."Posted By"}')]") == 1,"Error - Incorrect Posted By for ${params."Title"}"}
        if(params."Posted Date"){assert Exists.run(ID:"//*[@id='blog_title_small' and contains(.,'${params."Posted Date"}')]") == 1,"Error - Incorrect Posted Date for ${params."Title"}"}
        if(params."Tags"){assert Exists.run(ID:"//*[@class='minitext']//TD[contains(text(),'${params."Tags"}')]") == 1,"Error - Incorrect Tags for ${params."Title"}"}
        if(params."Content"){assert Exists.run(ID:"//*[@id='quoteAlt1']//td[text()='${params."Content"}']") == 1,"Error - Incorrect Content for ${params."Title"}"}     
    }
}
