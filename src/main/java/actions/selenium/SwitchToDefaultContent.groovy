package actions.selenium

import actions.selenium.Browser

class SwitchToDefaultContent{

    public static void run(def params){

        Browser.Driver.switchTo().defaultContent()

    }
}