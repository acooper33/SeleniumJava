package actions.WebstormHomepage;

import java.text.SimpleDateFormat

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import actions.selenium.Browser
import actions.selenium.Click

class HackAppClickVerifyJoinEventWidget{
    public void run(def params){
        if(params."Verify Join Event Date"){
            if(params."Verify Join Event Date"=="today"){
			SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        	String todayDate = dateFormat.format(new Date());
            println("Todays date: ${todayDate}")
            String xpathExpression = "//*[@id='join_event_widget']//P[@class='f-joined-date' and contains(.,'${todayDate}')]";
            WebElement element = Browser.Driver.findElement(By.xpath(xpathExpression));
        	}
        }
        if(params."Click Join Event")Click.run(ID:"//BUTTON[contains(@class,'join-event-btn') and text()='Registration']") 
        if(params."Update or Leave Event")Click.run(ID:"//*[contains(@id,'join_event_widget')]/BUTTON[contains(@class,'join-event-btn') and text()='Update or Leave Event']")            
    }
}