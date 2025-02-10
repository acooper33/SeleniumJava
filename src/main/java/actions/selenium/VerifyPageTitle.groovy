package actions.selenium

import actions.selenium.Browser
import actions.selenium.Click

class VerifyPageTitle{
  
  public void run(def params){
      println("Param Title: ${params.Title}")
      println("Got title: ${Browser.Driver.getTitle()}")
      
    assert params.Title == Browser.Driver.getTitle(),"Error: page title ${Browser.Driver.getTitle()} does not match expected title of: ${params.Title}"
  }
}