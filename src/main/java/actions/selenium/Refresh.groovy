package actions.selenium

class Refresh{
  
  public static void run(def params){
    Browser.Driver.navigate().refresh()
    sleep(5000)
  }
}