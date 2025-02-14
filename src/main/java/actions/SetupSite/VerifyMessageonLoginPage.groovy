package actions.SetupSite;

import actions.selenium.Exists

class VerifyMessageonLoginPage{
    public void run(def params){
        
        if(params."Should the Message be Displayed" == true){
            assert Exists.run(ID:"//*[@class='alert alert-danger clearfix']//*[normalize-space(.)='${params."Message"}']")==1, "Error - 'Message not displayed"
        } else {
            assert Exists.run(ID:"//*[@class='alert alert-danger clearfix']//*[normalize-space(.)='${params."Message"}']")==0, "Error - 'Message should not be displayed but itis displayed"
        }
        
        
    }
}