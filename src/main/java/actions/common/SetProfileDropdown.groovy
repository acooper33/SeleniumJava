package actions.common;

import actions.selenium.Click

class SetProfileDropdown{
    public static void SetProfileDropdownOption(def params){
        Click.run(ID:"//*[contains(@class,'-menu')]//*[@id='profile-button' or contains(@aria-label,'Profile menu')]")
        switch(params.Tab){
            case "Home":
            Click.run(ID:"//*[contains(@class,'f-home-icon')]/..")
            break
            case "Profile":
            Click.run(ID:"//*[contains(@class,'fa-circle-user')]/..")
            break
            case "Explore Apps":
            Click.run(ID:"//*[contains(@class,'-pill')]")
            break
            case "Logout":
            Click.run(ID:"//*[contains(@class,'fa-right-from-bracket') or contains (@class,'fa fa-sign-out')]/..")
            break
        }
    }
}