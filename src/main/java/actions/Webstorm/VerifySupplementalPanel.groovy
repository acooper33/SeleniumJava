package actions.Webstorm;

import actions.selenium.Exists

class VerifySupplementalPanel{
    public void run(def params){
        if(params."Sponsor Image"!=null){
            def img
            //if(params."Sponsor Image"==true){img = "/IMG[contains(@src,'/ct/getfile.php')]"}
            if(params."Sponsor Image"==true){img = "/IMG[contains(@src,'getfile.php')]"}
            else{img = "/IMG[contains(@src,'/CORE/IMAGES/profile_user')]"}
            assert Exists.run(ID:"//*[@id='homepage-htmlpreview-sponsor']//DIV${img}")==1, "Sponsor Image fractal not present"
            //assert Exists.run(ID:"//*[contains(@class,'fractal-homepage-body-sponsor')]//FIGURE${img}")==1, "Sponsor Image fractal not present"
            
        }
        if(params."Sponsor Name"){
            assert Exists.run(ID:"//*[@id='homepage-htmlpreview-sponsor']//IMG/following-sibling::P[text()='${params."Sponsor Name"}']")==1, "Sponsor Name is incorrect"
        }
        if(params."Launch Date"){
            assert Exists.run(ID:"//*[@id='homepage-htmlpreview-sponsor']//DIV[contains(text(),'Challenge Launch')]/SPAN[text()='${params."Launch Date"}']")==1, "Sponsor Name is incorrect"
        }
        if(params."Supplemental Panel Description"){
            assert Exists.run(ID:".//*[@id='homepage-htmlpreview-sponsor' and contains(.,'${params."Supplemental Panel Description"}')]")==1, "Supplemental Panel Description not found in Supplemental Panel"
        }
    }
}