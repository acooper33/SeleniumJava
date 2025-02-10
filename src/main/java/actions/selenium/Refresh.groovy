package actions.selenium

import actions.selenium.Browser

class Refresh{
  
  public static void run(def params){
    Browser.Driver.navigate().refresh()
    sleep(5000)
  }
}