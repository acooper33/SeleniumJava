package actions.selenium

class CloseWindow{
    public static void run(def params){
        //Browser.Driver.close()
        Browser.Driver.quit()
    }
}