package actions.selenium

class SwitchToDefaultContent{

    public static void run(def params){

        Browser.Driver.switchTo().defaultContent()

    }
}