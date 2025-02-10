package actions.Webstorm;

import actions.selenium.Exists

class VerifyChallengeBriefDescripton{
    public void run(def params){
        assert Exists.run(ID:".//*[@id='homepage-htmlpreview-brief' and contains(.,'${params."Challenge Brief Description"}')]")==1, "Description not found in Challenge Brief"
    }
}