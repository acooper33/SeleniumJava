package actions.selenium

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement

class VerifyAttribute{
  
  public static void run(def params){
    WebElement element = Elements.find(params,Browser.Driver)
    if(params."Attribute Name"=="Size"){
          //will add code to verify size
    }else if(params."Attribute Name"){
          assert params.Value == element.getAttribute(params."Attribute Name"), "Error: value ${element.getAttribute(params."Attribute Name")} of the attribute: ${params."Attribute Name"} does not match expected value of: ${params.Value}"
    }
    if(params."CSS Property Name"){
          assert params.Value == element.getCssValue(params."CSS Property Name"), "Error: value ${element.element.getCssValue(params."CSS Property Name")} of the css property: ${params."CSS Property Name"} does not match expected value of: ${params.Value}"
      }
  }
}
