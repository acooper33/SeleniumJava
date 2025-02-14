package actions.People;

import actions.selenium.Exists

class VerifyMessageonPeoplePillarUserMenuModal{
    public void run(def params){
        
        assert Exists.run(ID:"//*[contains(@class,'f-modal-body') and contains(.,\"${params."Message"}\")]")==1, "Error - 'Message not displayed"
    }
}