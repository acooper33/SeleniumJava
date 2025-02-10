package actions.selenium;

import actions.selenium.Browser
import java.io.File;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;


class CaptureScreenshot{
    public static def run(def params){
        TakesScreenshot screenshot = (TakesScreenshot) Browser.Driver;
        File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(params.File);
        //File DestFile=new File("c://expectedFull.png");
        FileUtils.copyFile(SrcFile, DestFile);
        return SrcFile
    }
}