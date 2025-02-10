package actions.selenium;

import actions.selenium.Browser
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import java.io.File;
import org.openqa.selenium.OutputType;
import javax.imageio.ImageIO;
import actions.selenium.utils.Elements
import org.openqa.selenium.Keys
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


class TakeScreenshotAShot{
    public static def run(def params){
        Screenshot screenshot
        def actualFileName = System.getProperty("user.home")+"\\Downloads"+"\\actualFullAshot.png"
        //WebElement element = Browser.Driver.findElement(By.xpath ("//DIV[@class='f-comment-popovers f-has-comments']"));
        
        WebElement element = Browser.Driver.findElement(By.xpath ("//DIV[contains(@class,'f-memo-thumb-wrapper')]"));

        //if(params."Element ID (optional)"){
            
        	//WebElement element = Elements.find(ID:params."Element ID (optional)", Browser.Driver)
            screenshot = new AShot().takeScreenshot(Browser.Driver,element);
        //}else{
            //screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Browser.Driver);
        //}
        ImageIO.write(screenshot.getImage(), "png", new File(actualFileName));
        //emailBody.sendKeys(Keys.PAGE_DOWN);
        
        
        //Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Browser.Driver);
        //Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Browser.Driver, element);
        //Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver,webElement);

        //File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);

    }
}