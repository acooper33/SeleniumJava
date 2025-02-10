package actions.selenium
import actions.selenium.Browser

class CloseWindow{
    public static void run(def params){
        //Browser.Driver.close()
        Browser.Driver.quit()
    }
}