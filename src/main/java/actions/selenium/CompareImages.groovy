package actions.selenium;

import java.awt.image.BufferedImage

import org.openqa.selenium.WebElement

import javax.imageio.ImageIO
import java.nio.file.Paths
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.comparison.PointsMarkupPolicy
import org.openqa.selenium.By
import actions.Email.EmailAttachment

class CompareImages{
    public void run(def params){
        BufferedImage expectedImg, actualImg, diffImage = null;
        File actualFile;
        Screenshot screenshot;
        def expectedFileName, actualFileName, pathToExpectedFile, pathToActualFile
        
        def os = System.getProperty("os.name").toLowerCase();
       
        String expFile = params."Expected Image File"
        String actFile = params."Actual Image Name"
        if(os.contains("nix") || os.contains("nux")||os.contains("aix")){
        	pathToExpectedFile = Paths.get(".").toAbsolutePath().normalize().toString()+'/TestCaseResourceFiles/'
            pathToActualFile = System.getProperty("user.home")+'/'
        }else{
            pathToExpectedFile = Paths.get(".").toAbsolutePath().normalize().toString()+"\\TestCaseResourceFiles\\"
            pathToActualFile = System.getProperty("user.home")+"\\Downloads"+"\\"
        }
        expectedFileName = pathToExpectedFile + expFile
        actualFileName = pathToActualFile + actFile
        
        println("Expected file path: ${expectedFileName}")
        println("Actual file path: ${actualFileName}")
       if(params."Element ID (optional)"){
           println("Taking a screenshot of element with id ${params."Element ID (optional)"}")
            WebElement element = Browser.Driver.findElement(By.xpath(params."Element ID (optional)"));
           	//Dimension dim = element.getSize();
           	//System.out.println(dim);
           if(params."Do Not Scroll"==true){
               println("Do Not Scroll is set to TRUE")
               screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Browser.Driver,element);
           }else{
               println("Do Not Scroll not set")
           		screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Browser.Driver,element);
           		//screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.25f), 1000)).coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Browser.Driver,element);
           }
       }else{
           println("Taking a screenshot of a full page")
           if(params."Do Not Scroll"==true){
               	println("Do Not Scroll is set to TRUE")
           		screenshot = new AShot().takeScreenshot(Browser.Driver);
           }else{
               println("Do Not Scroll not set")
               screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.25f), 1000)).takeScreenshot(Browser.Driver);
          	}
        }     
        //read the image from screenshot
        actualImg = screenshot.getImage()
        println("Screenshot Width and Height: ${actualImg.getWidth()} and ${actualImg.getHeight()} ...")
        
       	//crop if needed
        if(params."Crop Screenshot Start at X"){
            int coordX = params."Crop Screenshot Start at X".toInteger()
            int coordY = params."Crop Screenshot Start at Y".toInteger()
            int width = params."Crop Screenshot Width".toInteger()
            int height = params."Crop Screenshot Height".toInteger()
            println("Width and Height: ${width} and ${height} ...")
            BufferedImage croppedImg = actualImg.getSubimage(coordX, coordY, width, height);
            actualImg = croppedImg
        }
        //write image into file
        ImageIO.write(actualImg, "png", new File(actualFileName));
		expectedImg = ImageIO.read(new File(expectedFileName))
        
        PointsMarkupPolicy diffMarkupPolicy = new PointsMarkupPolicy()
        int diffAllowed = (params."Allowed Number of Different Pixels"!=null) ? params."Allowed Number of Different Pixels".toInteger() : 0
        println("Will allow ${diffAllowed} different pixels")
        diffMarkupPolicy.setDiffSizeTrigger(diffAllowed);
        ImageDiffer imgDiff = new ImageDiffer().withDiffMarkupPolicy(diffMarkupPolicy);
        ImageDiff diff = imgDiff.makeDiff(actualImg, expectedImg);
        expectedImg = null; 
        actualImg = null;
        
        //compare with expected
        if(diff.hasDiff()){
            diffImage = diff.getDiffImage();
            pathToActualFile
            ImageIO.write(diff.getMarkedImage(),"PNG", new File(pathToActualFile+"difference.png"));
            diffImage = null;
        }
        //params."Temporary Pause Verification; Email Screenshot to" = ""
        if(params."Temporary Pause Verification; Email Screenshot to"!=null){ //used when updating screenshots
            EmailAttachment.run(
                "Sender's Email":"annabrightidea1@yahoo.com",
                "Sender's Password":"coothhthkgxqqztx",
                "Sender Host":"smtp.mail.yahoo.com",
                "To Email":params."Temporary Pause Verification; Email Screenshot to",
                "Email Subject":params."Actual Image Name",
                "Email Body":params."Actual Image Name",
                "File Name":params."Actual Image Name"
            )
            EmailAttachment.run(
                "Sender's Email":"annabrightidea1@yahoo.com",
                "Sender's Password":"coothhthkgxqqztx",
                "Sender Host":"smtp.mail.yahoo.com",
                "To Email":params."Temporary Pause Verification; Email Screenshot to",
                "Email Subject":params."Actual Image Name"+" Difference",
                "Email Body":params."Actual Image Name"+" Difference",
                "File Name":"difference.png"
            )
        }else{
            assert diff.hasDiff()==false, "Error - Actual Image Is Not What's Expected"
        }
    }
}