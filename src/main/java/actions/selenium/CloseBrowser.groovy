package actions.selenium

class CloseBrowser{
  public void run(def params){
    if(Browser.Driver) Browser.Driver.quit()
  }
}