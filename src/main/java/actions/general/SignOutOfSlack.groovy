package actions.general;

import actions.selenium.Click

class SignOutOfSlack{
    public void run(def params){
        Click.run(ID:"//DIV[contains(@class,'p-top_nav__right')]//BUTTON[@data-qa='user-button']", "Type of Click":"Javascript")
        sleep(2000)
        Click.run(ID:"//DIV[contains(@data-qa,'menu_items')]//BUTTON[@data-qa='menu_item_button']/DIV[contains(@class,'label') and contains(.,'Sign out')]", "Type of Click":"Javascript")
    	sleep(5000)
    }
}