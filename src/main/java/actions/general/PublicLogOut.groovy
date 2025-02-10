package actions.general;

import actions.selenium.Click

class PublicLogOut{
    public void run(def params){
        
        	Click.run(ID:"//DIV[@id='account-dropdown']")
            sleep(2000)
            Click.run(ID:"//DIV[@id='profile-dropdown-content']//A[contains(.,'Login')]")
       		sleep(2000)
    }
}