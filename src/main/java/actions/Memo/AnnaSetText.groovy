package actions.Memo;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SendKeys
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import actions.Whiteboards.SendKeysToWhiteboard
import java.lang.Number
import org.openqa.selenium.Keys
import org.openqa.selenium.interactions.Actions


/*import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Keys;
import actions.selenium.Browser
import java.awt.Robot;	
import java.awt.event.KeyEvent;*/

class AnnaSetText{
    public void run(def params){
        
        def textValue
        def parNumStr
        WebElement myPar
        List <WebElement> allPars
        WebElement myDoc
        Actions builder = new Actions(Browser.Driver)
        
        myDoc = Elements.find(ID:"//DIV[@role='textbox']/P",Browser.Driver)
        builder.moveToElement(myDoc).click().build().perform(); //set focus back on the document
        
        allPars = Elements.findAll(ID:"//DIV[@role='textbox']//P/P",Browser.Driver)
        println("Found ${allPars.size()} paragraphs of text")
        
      
        if(params."Focus on paragraph"==null || params."Focus on paragraph"=="First"){
            myPar = Elements.find(ID:"//DIV[@role='textbox']//P/P[1]/SPAN",Browser.Driver)
        
        } 
        else if(params."Focus on paragraph"=="Last"){
            parNumStr = allPars.size().toString()
            myPar = Elements.find(ID:"//DIV[@role='textbox']//P/P[${parNumStr}]/SPAN",Browser.Driver)
        }
        else {
            println("We are focusing on '${params."Focus on paragraph"}' paragraph")            
            myPar = Elements.find(ID:"//DIV[@role='textbox']//P/P[${params."Focus on paragraph"}]",Browser.Driver)
            
            //println("Text from myPar: ${myPar.getText()}")
			//builder.moveToElement(myPar).click().build().perform();
            //myPar.sendKeys(params."Text")
            //allPars.get(params."Focus on paragraph".toInteger()-1).click()
            //sleep(2000)
            //SendKeysToWhiteboard.run("Key(s) to send":"enter")
            //sleep(2000)
            
            
            //sleep(2000)
        }
        
        println("Text from myPar: ${myPar.getText()}")
        builder.moveToElement(myPar).click().build().perform();
        if(params."Text"){myPar.sendKeys(params."Text")}
        sleep(1000)
        
        /*
        Point parLoc = myPar.getLocation();
        println("MyPar location: ${parLoc}")
        builder.moveByOffset(parLoc.getX(),parLoc.getY())*/
        
        
        
        
        //SendKeys.run(ID:"//DIV[@role='textbox']//P", Text:params."Text")
         
        if(params."Key(s)"){SendKeysToWhiteboard.run("Key(s) to send":params."Key(s)")}
        sleep(1000)        
    }
}