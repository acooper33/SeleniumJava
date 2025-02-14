package actions.Enterprise.UserHomepage;

import actions.selenium.Click
import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.GetText

class VerifyFeaturedActivityinUserHomepage{
    public void run(def params){
        def verify = [:]
        if(params."Placement Number"){
            verify.ID = "//DIV[contains(@class,'f-campaign-card') and position()='${params."Placement Number"}']//*[@class='f-card-details']/*[@class='f-card-name' and text()='${params."Activity Name"}']"
            //verify.ID = "//*[@class='f-campaigns-grid']/DIV[contains(@class,'f-campaign-card') and position()='${params."Placement Number"}']//*[@class='f-card-details']/*[@class='f-card-name' and text()='${params."Activity Name"}']"
        
        }else{
            verify.ID = "//DIV[contains(@class,'f-campaign-card')]//*[@class='f-card-details']/*[@class='f-card-name' and text()='${params."Activity Name"}']"
        }
        
        
        verify.IDChildren = []
        if(params."Total Number of Activities on the page"){
            sleep(3000) 
            def activities = Elements.findAll(ID:"//DIV[contains(@class,'f-campaign-card')]", Browser.Driver)
            println("Total Num of Activities ---->")
            println(activities.size())
            assert activities.size()==params."Total Number of Activities on the page".toInteger(), "Error - Total Number of Activities on the page is invalid, '${activities.size()}'"
        }
        if(params."Image"){
            def img = "/*[@class='f-card-image' and contains(@style,'/ct/getfile.php')]"
            verify.IDChildren << "./../..${img}"
        }
        if(params."Description"){
            verify.IDChildren << "./../*[@class='f-card-description' and contains(.,'${params.Description}')]"
        }
        if(params."Pre-Launch"==true){
            verify.IDChildren << "./../*[@class='f-card-description']/../..//*[@class='f-card-pre-launch' and contains(.,'Activity will begin in:')]"
        }
        if(params."Countdown"){
            verify.IDChildren << "./../*[@class='f-card-description']/../..//*[@class='f-card-pre-launch' and contains(.,'${params.Countdown}')]"
        }
        if(params.Comments){
            verify.IDChildren << "./../*[@class='f-card-extra']//*[@data-test='comment-count' and text()='${params."Comments"}']"
        }
        if(params."Submissions"){
            verify.IDChildren << "./../*[@class='f-card-extra']//*[@data-test='idea-count' and text()='${params."Submissions"}']"
        }
        if(params."Users"){
           	verify.IDChildren << "./../*[@class='f-card-extra']//*[@data-test='visitor-count' and text()='${params."Users"}']"
        }
        if(params."Number of Matches"){
           	verify."Number of Matches" = params."Number of Matches".toInteger()
        }
        VerifyNumberOfMatches.run(verify) 
   }
}