package actions.selenium

class GoBack{
  
  public void run(def params){
    
    Browser.Driver.navigate().back()
    
  }
}