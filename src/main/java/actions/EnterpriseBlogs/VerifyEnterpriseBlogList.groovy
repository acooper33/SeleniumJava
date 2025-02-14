package actions.EnterpriseBlogs;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyEnterpriseBlogList{
    public void run(def params){
        def verify = [:]
        verify.ID = "//*[@id='blogsubject']/A[text()=\"${params."Title"}\"]"        
        verify.IDChildren = [] 
        if(params."Topic"){verify.IDChildren << "./parent::DIV/parent::DIV/SPAN[contains(text(),'Topic:')]/A[text()='${params."Topic"}']"}
        if(params."Posted By"){verify.IDChildren << "./parent::DIV/parent::DIV/SPAN[contains(text(),'Posted')]/A[text()='${params."Posted By"}']"}
        if(params."Posted Date"){verify.IDChildren << "./parent::DIV/parent::DIV/SPAN[contains(.,'${params."Posted Date"}')]"}
        if(params."Tags"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/following-sibling::*[2]//*[@class='minitext']//TD[contains(text(),'${params."Tags"}')]"}
        if(params."Content"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/following-sibling::DIV//*[text()='${params."Content"}']"}
        if(params."Comment Count"){verify.IDChildren << "./parent::DIV/parent::DIV/parent::DIV/following-sibling::P//A[1][contains(text(),'${params."Comment Count"}')]"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
        VerifyNumberOfMatches.run(verify)      
    }
}