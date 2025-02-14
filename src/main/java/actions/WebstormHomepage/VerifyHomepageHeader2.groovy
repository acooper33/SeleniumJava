package actions.WebstormHomepage


import actions.selenium.*
import actions.selenium.utils.Elements
import org.openqa.selenium.WebElement

class VerifyHomepageHeader2{
    public void run(def params){
        
        sleep(2000)
        if(params."Title"){
            ExplicitWait.run(ID:"//*[@id='homepage-htmlpreview-name']/*[text()='${params."Title"}']")
            assert Exists.run(ID:"//*[@id='homepage-htmlpreview-name']/*[text()='${params."Title"}']") == 1,"Error - Incorrect Title displayed"
        }
        if(params."Description"){
             assert Exists.run(ID:"//*[@id='homepage-htmlpreview-description']/*[contains(.,'${params."Description"}')]") == 1,"Error - Incorrect Description displayed"
        }
        if(params."Splash or Own Image Displayed"){
            if(params."Splash or Own Image Displayed"==true){
                assert Exists.run(ID:"//*[@class='f-homepage-hero-image' and contains(@style,'/ct/getfile.php')]") == 1, "Error- homepage image not displayed"
            } else {
               assert Exists.run(ID:"//*[@class='f-homepage-hero-image' and contains(@style,'/ct/getfile.php')]") == 0, "Error- homepage image should not be displayed" 
            } 
        }
        if(params."Preset Image"){
            assert Exists.run(ID:"//*[@class='f-homepage-hero-image' and contains(@style,'${params."Preset Image"}')]") == 1,"Error - Incorrect Presets Image displayed"
        }
        if(params."Idea Box Trial Image"==true){
            assert Exists.run(ID:"//*[@class='f-homepage-hero-image' and contains(@style,'/uploads/Test2')]") == 1,"Error - Incorrect Idea Box Trial Image displayed"
        }
        if(params."Readability"){
            WebElement opacity = Elements.find(["ID":"//*[@class='f-homepage-hero-overlay']"],Browser.Driver)
            println("STYLE: ${opacity.getAttribute("style")}")
            assert Exists.run(ID:"//*[@class='f-homepage-hero-overlay' and contains(@style,'${params."Readability"}')]") == 1,"Error - Incorrect opacity displayed"
        }
        if(params."Color of Submit Button"){
            ExplicitWait.run(ID:"//*[@id='homepage-button-submit' and contains(@style,'${params."Color of Submit Button"}')]")
            assert Exists.run(ID:"//*[@id='homepage-button-submit' and contains(@style,'${params."Color of Submit Button"}')]") == 1,"Error - Incorrect button color displayed for submit"
        }
        if(params."Submit Displayed"!=null){
            if(params."Submit Displayed"==true){
                assert Exists.run(ID:"//*[@id='homepage-button-submit']") == 1, "Error- Submit button not displayed"
            } else {
               assert Exists.run(ID:"//*[@id='homepage-button-submit']") == 0, "Error- Submit button displayed" 
            } 
        }
        if(params."Browse Displayed"!=null){
            if(params."Browse Displayed"==true){
                assert Exists.run(ID:"//*[@id='homepage-button-browse']") == 1, "Error- Browse button not displayed"
            } else {
               assert Exists.run(ID:"//*[@id='homepage-button-browse']") == 0, "Error- Browse button displayed"  
            } 
        }
        if(params."Registration" !=null){
            if(params."Registration"==true){
                assert Exists.run(ID:"//*[contains(@class,'f-join-event-btn')]") == 1, "Error- Registration button not displayed"
            } else {
                assert Exists.run(ID:"//*[contains(@class,'f-join-event-btn')]") == 0, "Error- Registration button displayed"
            }
        }
        
    }
}