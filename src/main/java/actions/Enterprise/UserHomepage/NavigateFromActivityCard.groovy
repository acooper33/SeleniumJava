package actions.Enterprise.UserHomepage;

import actions.selenium.MouseOver
import actions.selenium.Click
import actions.selenium.Exists
import org.openqa.selenium.interactions.Actions

class NavigateFromActivityCard{
    public void run(def params){
        if(params."Active or Closed"){Click.run(ID:"//*[contains(@class,'f-tabs')]/BUTTON[contains(.,'${params."Active or Closed"}')]")}

        if(params."Navigate to"){
            println("Navigate to '${params."Navigate to"}' ")
            if(params."Navigate to"=="Topic"){
                Click.run(ID:"//DIV[contains(@class,'f-campaign-card')]//*[@class='f-card-details']/*[@class='f-card-name' and text()='${params."Activity Name"}']")
                //Click.run(ID:"//*[@class='f-campaigns-grid']/DIV[contains(@class,'f-campaign-card')]//*[@class='f-card-details']/*[@class='f-card-name' and text()='${params."Activity Name"}']")
            } else {
                Click.run(ID:"//DIV[contains(@class,'f-campaign-card')]//*[@class='f-card-details']/*[@class='f-card-name' and text()='${params."Activity Name"}']/../../DIV[@class='f-card-links']/A[span='${params."Navigate to"}']", "Type of Click":"Javascript")
                //Click.run(ID:"//*[@class='f-campaigns-grid']/DIV[contains(@class,'f-campaign-card')]//*[@class='f-card-details']/*[@class='f-card-name' and text()='${params."Activity Name"}']/../../DIV[@class='f-card-links']/A[span='${params."Navigate to"}']", "Type of Click":"Javascript")
            }  
        }
    }
}