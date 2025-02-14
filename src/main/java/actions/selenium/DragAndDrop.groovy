package actions.selenium

import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class DragAndDrop{

    public static void run(def params){
        
        WebElement element = Elements.find(["ID":params."From ID","ID Type":params."From ID Type"],Browser.Driver)
        WebElement target = Elements.find(["ID":params."To ID","ID Type":params."To ID Type"],Browser.Driver)
        Actions builder = new Actions(Browser.Driver)
        if(params."Type of Drag and Drop"=="Dragging"){
             builder.dragAndDrop(element,target);        
        } else{
             builder.clickAndHold(element);
        	 builder.moveToElement(target, 15, 5);
        	 builder.perform();
        	 sleep(1000)
        	 builder.release(element);            
         }
         builder.perform()
    }
}