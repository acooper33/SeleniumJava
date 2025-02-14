package actions.selenium

class GoForward{
  
  public void run(def params){
    
    Browser.Driver.navigate().forward()
    
  }
}