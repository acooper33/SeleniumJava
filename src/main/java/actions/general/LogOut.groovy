package actions.general;

import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.ExplicitWait
import actions.common.SetProfileDropdown

class LogOut{
    public static void run(def params){
        //on new react pages
/*        if(Exists.run(ID:"//*[contains(@class,'f-user-menu')]")>0){
            Click.run(ID:"//*[contains(@class,'f-user-menu')]//SPAN/*[contains(@class,'member-image-v1')]")
            Click.run(ID:"//*[@class='f-user-menu-links']//A[text()='Log Out']")
        }
        //old nav
        /*
		else{
            Click.run(ID:"//div[@id='account-dropdown']//*[@class='fa fa-caret-down']","Type of Click":"Javascript")
        	Click.run(ID:"//div[@class='nav-sub-menu']//*[text()='Log Out']","Type of Click":"Javascript")
        }
        */
/*        else{
            Click.run(ID:"//DIV[@id='account-dropdown']")
            //ExplicitWait.run(ID:"//DIV[@id='profile-dropdown-content']")
            sleep(2000)
            Click.run(ID:"//DIV[@id='profile-dropdown-content']//A[.='Log Out']")
        }
        sleep(2000) */
        SetProfileDropdown.SetProfileDropdownOption(Tab:"Logout")
    }
}