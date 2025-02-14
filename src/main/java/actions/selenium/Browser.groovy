package actions.selenium
import org.openqa.selenium.WebDriver
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.GeckoDriverService
import org.openqa.selenium.firefox.FirefoxOptions;

//import org.openqa.selenium.firefox.internal.ProfilesIni

import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.ie.InternetExplorerDriverService
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import actions.selenium.utils.GetIPAddress
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException

import java.util.concurrent.TimeUnit;

class Browser {

//test
    public static WebDriver Driver = null
    public static MainWinHandle = null
    private static Browser instance = null

    // Private constructor to prevent instantiation
    private Browser() {}

    // Static method to get the single instance of the class
    public static Browser getInstance() {
        if (instance == null) {
            instance = new Browser()
            WebDriverManager.chromedriver().setup()
            Driver = new ChromeDriver()
        }
        return instance
    }
    public static void run(def params) {
        Driver.get(params.URL);
    }
    public static void quit(def params) {
        Driver.quit();
    }


}