package actions.EnterpriseBlogs;

import actions.selenium.Click

class AccessBlogfromEnterpriseBlogList{
    public void run(def params){
        //Map all values that will be used for access of that instance
        def set = [:]
        set.ID= "//*[@id='blogsubject']/A[text()=\"${params."Blog Title"}\"]"        
        set.IDChildren = []
        if(params."Blog Topic"){set.IDChildren << "./parent::DIV/parent::DIV/SPAN[contains(text(),'Topic:')]/A[text()='${params."Blog Topic"}']"}
        Click.run(set) 
    }
}