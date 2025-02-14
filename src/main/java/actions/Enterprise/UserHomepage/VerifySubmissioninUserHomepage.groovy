package actions.Enterprise.UserHomepage;

import actions.selenium.utils.VerifyNumberOfMatches
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.GetText
import actions.selenium.Click

class VerifySubmissioninUserHomepage{
    public void run(def params){
        def verify = [:]
        sleep(2000)
        verify.ID = "//*[contains(@class,'fractal-secondary-ideas-view-grid')]/*[contains(@class,'ideaboard-card') and @data-title='${params."Submission Name"}']"
        verify.IDChildren = []
        if(params."Total Number of Submissions"){
            def submissions = Elements.findAll(ID:"//*[contains(@class,'fractal-secondary-ideas-view-grid')]/*[contains(@class,'ideaboard-card')]", Browser.Driver)
            assert submissions.size()==params."Total Number of Submissions".toInteger(), "Error - Total Number of Submissions on the page is ${submissions.size()}"
        }
        if(params."Image"){
            verify.IDChildren << ".//*[@class='f-card-image' and contains(@style,'/ct/getfile.php')]"
        }
        if(params."Description"){
            verify.IDChildren << ".//*[contains(@class,'f-card-description')]//*[text()='${params."Description"}']"
        }
        if(params."Status"){
            verify.IDChildren << ".//*[contains(@class,'f-status-indicator') and text()='${params."Status"}']"
        }
        if(params."Initiative Name"){
            verify.IDChildren << ".//*[contains(@class,'f-card-campaign-title') and text()='${params."Initiative Name"}']"
        }
        if(params."Comments"){
            verify.IDChildren << ".//*[contains(@class,'f-idea-scores')]/*[@data-comments='${params."Comments"}']"
        }
        if(params."Votes"){
            verify.IDChildren << ".//*[@class='f-idea-score-footer-text' and text()='${params."Votes"}']"
        }
        if(params."Hidden"==true){
            verify.IDChildren << ".//*[@class='f-hidden-indicator']/I[@class='fa fa-eye-slash f-card-eye']"
        }else if (params."Hidden"==false){
            verify.IDChildren << ".//DIV[not(following-sibling::I[@class='fa fa-eye-slash f-card-eye'])]"
        }
        if(params."Number of Matches"){
            verify."Number of Matches" = params."Number of Matches".toInteger()
        }
        VerifyNumberOfMatches.run(verify)
        if(params."Access Submission"==true){Click.run(verify)}
    }
}