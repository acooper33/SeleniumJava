package actions.Webstorm;

import actions.selenium.VerifyText
import actions.selenium.Exists

class VerifySolveChallengeHome{
    public void run(def params){
        if(params."Should Homepage Exist"==false){
            assert Exists.run(ID:"//*[@id='homepage-htmlpreview-name']")==0,"Solve homepage displayed"
        } else{assert Exists.run(ID:"//*[@id='homepage-htmlpreview-name']")==1,"Solve homepage not displayed"}
        if(params."Description"){assert Exists.run(ID:"//*[@id='homepage-htmlpreview-description']")>0,"Error - Solve Description text not found"}
    }
}