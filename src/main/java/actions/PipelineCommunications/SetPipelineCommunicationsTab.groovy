package actions.PipelineCommunications;

import actions.selenium.SendKeys
import actions.selenium.SelectItem
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.SetFocus

class SetPipelineCommunicationsTab{
    public void run(def params){
        if(params."Select Tab"){Click.run(ID:"//*[@class='tab-group-header' and text()='Communications']/../*[@tab='communication${params."Select Tab"}']")}
        sleep(3000)
        if(params."Email" && params."Email Recipient"){Click.run(ID:"//*[@id='communications-alert-list']//div[@class='communications-alert-list-item-details']/span[text()='${params."Email"}']/../span[text()='${params."Email Recipient"}']")}
        if(params."Email Subject"){SetText.run(ID:"//*[@id='communications-alert-editor-email']//*[@id='communications-alert-editor-email-body']//input[@id='editor-email-subject']", Text:params."Email Subject")}
        if(params."Email Body"){
            SetFocus.run(ID:"//*[contains(@class,'redactor-styles redactor-in redactor-in')]")
            SetText.run(ID:"//*[contains(@class,'redactor-styles redactor-in redactor-in')]", Text:params."Email Body")
            sleep(1000)
        }
        if(params."Enable this email alert"==true){
            Click.run(ID:"//*[@id='toggle-alert-btn-wrapper']/DIV[contains(@class,'toggle btn btn-default off')]")
        }
        else if (params."Enable this email alert"==false){
            Click.run(ID:"//*[@id='toggle-alert-btn-wrapper']/DIV[contains(@class,'toggle btn btn-primary')]")
        }
        //add dynamic field to email subject
        if(params."Add Dynamic Fields to"=="Email Subject"){
            sleep(1000)
            Click.run(ID:"//*[@id='communications-alert-editor-email']//*[@id='communications-alert-editor-email-body']//input[@id='editor-email-subject']")
        }
        //add dynamic field to email body
        else if(params."Add Dynamic Fields to"=="Email Body"){
            sleep(1000)
            Click.run(ID:"//*[contains(@class,'redactor-styles redactor-in redactor-in')]")
        }
        if(params."Dynamic Fields"){
            SelectItem.run(ID:"//*[@id='communications-alert-editor-email-footer']/div[@class='right']/select[@class='form-control']", "Visible Text":params."Dynamic Fields")
            Click.run(ID:"//*[@id='communications-alert-editor-email-footer']//*[@id='communications-alert-editor-email-footer-tag-button']")
        }
        
        //setting Settings tab
        if(params."Contact Name"){SetText.run(ID:"//*[@id='contact-name']", Text:params."Contact Name")}        	
        if(params."Contact Email"){SetText.run(ID:"//*[@id='contact-email']", Text:params."Contact Email")}
        if(params."Enable or disable sending Email Alerts to your Pipeline participants"==true){
            Click.run(ID:"//*[@id='communications-settings']//*[contains(@class,'toggle btn btn-default off')]")
        }else if(params."Enable or disable sending Email Alerts to your Pipeline participants"==false){
            Click.run(ID:"//*[@id='communications-settings']//*[contains(@class,'toggle btn btn-primary')]")
		}
        sleep(1000)
        if(params."Action"=="Save" && params."Select Tab"=="Settings"){Click.run(ID:"//*[@id='save-contact-btn']")}
        if(params."Action"=="Save" && params."Select Tab"=="Emails"){Click.run(ID:"//*[@id='save-email-template-btn']")}
        sleep(3000)
    }
}