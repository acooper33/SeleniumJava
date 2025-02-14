package actions.selenium;

import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.shooting.ShootingStrategies
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class TakeScreenshot{
    public void run(def params){
        def fileName, pathToFile
        String fileParam = params."File Name"
        
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
            pathToFile = System.getProperty("user.home")+'/'
        }else{
            pathToFile = System.getProperty("user.home")+"\\Downloads"+"\\"
        }
        fileName = pathToFile + fileParam
        if(params."Element ID (optional)"){
        	WebElement element = Browser.Driver.findElement(By.xpath(params."Element ID (optional)"));
           	//Dimension dim = element.getSize();
           	//System.out.println(dim);
            //screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Browser.Driver,element);
        	screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.25f), 1000)).coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Browser.Driver,element);

       	}else{
            screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.25f), 1000)).takeScreenshot(Browser.Driver);
       	}
        ImageIO.write(actualImg, "png", new File(actualFileName));
		expectedImg = ImageIO.read(new File(expectedFileName))
        
    }
}