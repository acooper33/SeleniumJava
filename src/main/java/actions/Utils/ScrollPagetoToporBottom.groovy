package actions.Utils


import org.openqa.selenium.Keys
import org.openqa.selenium.By
import actions.selenium.Browser

class ScrollPagetoToporBottom{
    public void run(def params){
        if(params."Top or Bottom"=="Top"){
            //ExecuteJavascript.run(Code:"window.scrollTo(100, 0);")
            Browser.Driver.findElement(By.tagName("body")).sendKeys(Keys.UP)
        } else {
            sleep(2000)
            Browser.Driver.findElement(By.tagName("body")).sendKeys(Keys.END)
        }
        
    }
}