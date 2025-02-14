package actions.selenium

import actions.selenium.utils.Elements
import org.openqa.selenium.interactions.Actions

class DoubleClick{
  
  public static run(def params){
      	//WebElement element;
      	Actions action = new Actions(Browser.Driver)
      	if(params.ID){params."Element" = Elements.find(params,Browser.Driver)}
    	//action.doubleClick(element)
      	action.doubleClick(params."Element")
  		action.perform()
  }
}