package actions.SetupImageLibrary;

import actions.selenium.*

class VerifyImageLoads{
    public void run(def params){
        
        if(params."Image Displayed" == true){
            assert Exists.run(ID:"//IMG[contains(@src,'')]") == 1,"Error - Failed to find Image"
        }
        else{
            assert Exists.run(ID:"//IMG[contains(@src,'')]") == 0,"Error - No Image is not loaded"
        }
    }
}