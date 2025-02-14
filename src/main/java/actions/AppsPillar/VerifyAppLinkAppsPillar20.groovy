package actions.AppsPillar;

import actions.selenium.Exists

class VerifyAppLinkAppsPillar20{
    public void run(def params){
        println("placement number: ${params."Placement Number"}")
        
        if(params."Placement Number"){
            assert Exists.run(ID:"//*[@class='backbone-link app-link'][${params."Placement Number"}]//*[@class='app-card-name' and text()='${params.'App Name'}']")==1, "Error - Expected App is not found"
        }
        else{
            assert Exists.run(ID:"//*[@class='backbone-link app-link']//*[@class='app-card-name' and text()='${params.'App Name'}']")==1, "Error - Expected App is not found"
        }
    }
}