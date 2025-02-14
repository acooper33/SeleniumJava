package actions.Search;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.Click

class ViewiteminRecentlyViewedList{
    public void run(def params){

        Click.run(ID:"//*[@id='global-search-input']")
        sleep(2000)
        def verify = [:]
        verify.ID = "//*[@class='item-title' and text()='${params."Title"}']"        
        verify.IDChildren = []
        if(params."Image" !=null){
            def img
            if(params."Type" == "Idea"){
                if(params."Image"){img = "/*[@class='item-image' and contains(@src,'/ct/getfile.php')]"}
                else {img = "/*[@class='item-image' and contains(@src, 'default-idea-image')]"}
            } else if(params."Type" == "User"){
                if(params."Image"){img = "/*[@class='member-img' and contains(@src,'getfile.php')]"}
                else {img = "/*[@class='member-initial']"}
            }
            verify.IDChildren << "./../../${img}"
        }
        if(params."Type"){verify.IDChildren << "./../*[@class='item-type' and text()='${params."Type"}']"}
        if(params."Placement Number") {
            verify.ID="//*[@class='recent-list']/LI[${params."Placement Number"}]//*[@class='item-title' and text()='${params."Title"}']"
            VerifyNumberOfMatches.run(verify)
        }
        else{
            if(params."Number of Matches"){verify."Number of Matches" = params."Number of Matches".toInteger()}
            VerifyNumberOfMatches.run(verify)        
        }
    }
}