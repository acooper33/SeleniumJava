package actions.Anna;

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService

class MultiUser{
    public void run(def params){
        
        System.setProperty("webdriver.chrome.driver", "chromedriver124.exe");
        File chromedriver = new File("chromedriver124.exe")
        chromedriver.setExecutable(true)
        
        service = new ChromeDriverService.Builder().withVerbose(false).withWhitelistedIps("13.0.2.69").usingPort(9518).usingDriverExecutable(chromedriver).build()
    	
        //WebDriver driver1 = new ChromeDriver();
        //WebDriver driver2 = new ChromeDriver();
        
        driver1.manage().window().maximize();
        //driver2.manage().window().maximize();
        
        driver1.get("https://anna96.brightideatest.com");
       	//driver2.get("https://anna96.brightideatest.com");
        
    }
}