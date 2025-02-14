package actions.selenium

import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

class SetText{
    public static void run(def params){
        //Text = the text that will typed in (if null, then nothing will happen). <EMPTY> = will just clear everything in there without any value
        //Type of Clear (optional) = Cut (will cut values via keyboard shortcut rather than Clear()), None (will not do clear)
        
        if(params.Text){
            WebElement element = Elements.find(params,Browser.Driver)
            sleep(500)
            int iTimeout = 20
            while(iTimeout > 0){
                try{
                    element = Elements.find(params,Browser.Driver)
                    if(params."Type of Clear"){
                        if(params."Type of Clear"=="None"){}
                        else if(params."Type of Clear"=="Backspace"){ //used for Whiteboards, as the keys affect graphic elements
                            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                            element.sendKeys(Keys.chord(Keys.DELETE));
                        }
                        else{
                            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                            element.sendKeys(Keys.chord(Keys.CONTROL, "x"));
                        }
                    }
                    else{
                        element.clear()}
                    if(params.Text!="<EMPTY>"){
                        element.sendKeys(params."Text")
                    }
                    return
                }
                catch(Exception | Error e){
                    iTimeout--
                    if(iTimeout == 0){
                        throw e
                    }
                    sleep(1000)
                }
            }
        }
    }
}