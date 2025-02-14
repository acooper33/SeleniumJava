package actions.EnterpriseBlogs;

import actions.selenium.utils.VerifyNumberOfMatches

class VerifyCommentinEnterpriseViewBlog{
    public void run(def params){
        
        def verify = [:]
        verify.ID= "//*[@id='comment_container']//div[contains(text(),'${params."Comment"}')]"        
        verify.IDChildren = []
        if(params."User"){verify.IDChildren << "./../DIV/A[text()='${params."User"}']"}
        if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}

        VerifyNumberOfMatches.run(verify)  
    }
}