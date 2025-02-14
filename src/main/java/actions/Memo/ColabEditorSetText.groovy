package actions.Memo;
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SendKeys
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import actions.Whiteboards.SendKeysToWhiteboard
/*import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Keys;
import actions.selenium.Browser
import java.awt.Robot;	
import java.awt.event.KeyEvent;*/
class ColabEditorSetText{
    public void run(def params){
        
        List <WebElement> allPars = Elements.findAll(ID:"//DIV[@role='textbox']//P",Browser.Driver)
        println("Found ${allPars.size()} paragraphs of text")
        allPars.eachWithIndex{par,i->
            println("#${i} is \'${par.getText()}\' ")
        }
        
        
        if(params."Focus on paragraph"==null || params."Focus on paragraph"=="First"){Click.run(ID:"//DIV[@role='textbox']//P")
                                                                                     sleep(3000)}
        else if(params."Focus on paragraph"=="Last"){Click.run(ID:"//DIV[@role='textbox']//P[position()='${allPars.size()-1}']")} //it select all the text as an extra paragraph
        else {Click.run(ID:"//DIV[@role='textbox']//P[position()='${params."Focus on paragraph"}']")}
        
        SendKeys.run(ID:"//DIV[@role='textbox']//P", Text:params."Text")
        sleep(1000) 
        if(params."Key(s)"){SendKeysToWhiteboard.run("Key(s) to send":params."Key(s)")}
        sleep(1000)        
    }
}