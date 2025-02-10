package actions.general;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.Exists
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import actions.selenium.utils.Elements

class LoginEmail{
    public void run(def params){
        //Click.run(ID:"//SPAN[@class='x-menu-link-text']")
        Click.run(ID:"//A[contains(@class,'nav-login')]")
        SetText.run(ID:"//input[@id='many_login_email']", Text:"cwilliams@brightidea.com")
        SetText.run(ID:"//input[@id='many_login_password']", Text:"Inn0vat3!")
        Click.run(ID:"//A[contains(@class,'submit')]")
        //Click.run(ID:"//A[contains(@class,'nav-login')]")
        Click.run(ID:"//A[contains(.,'Public Inboxes')]")
        
        SetText.run(ID:"//INPUt[@id='inbox_field']", Text:"pipelinesponsor")
        Click.run(ID:"//BUTTON[contains(@class, 'primary-btn') and contains(.,'GO')]")
        Click.run(ID:"//TABLE[contains(@class,'table-striped')]")
        
        //def emailBody = Elements.find(ID:"//DIV[@id='pills-html']",Browser.Driver)
        //emailBody.sendKeys(Keys.PAGE_DOWN);
    }
}