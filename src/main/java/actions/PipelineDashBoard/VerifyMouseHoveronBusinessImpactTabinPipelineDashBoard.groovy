package actions.PipelineDashBoard;

import actions.selenium.*
import java.awt.Robot
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class VerifyMouseHoveronBusinessImpactTabinPipelineDashBoard{
    public void run(def params){

        SelectItem.run(ID:"//*[@id='select-gross-benefits-chart-type']","Visible Text":params."Chart View")    
        sleep(5000)
        Actions a = new Actions(Browser.Driver)
        if(params."Year"){
            params."Year".split(",").eachWithIndex{ year, x ->
                SetFocus.run(ID:"//*[contains(@id,'highcharts')]")
                WebElement element = Elements.find(ID:"//*[contains(@id,'highcharts')]//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[${x+1}][@text-anchor='middle' and text()='${year}']",Browser.Driver)
                a.moveToElement(element, 0, -205).build().perform() // workaround for C130777
                List <WebElement> elementList = Elements.findAll(ID:"//*[contains(@id,'highcharts')]//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[@text-anchor='middle']",Browser.Driver)
                println("found: ${elementList.size} labels")
                
                elementList.each{item -> 							// workaround for C130777
                	println("label text: ${item.getText()}")
                    if(item.getText().contains(year)){
                        println("moving to the label")
                        a.moveToElement(item, 0, -205).build().perform()
                    }
        		}
                //Click.run(ID:"//*[contains(@id,'gross-benefits-over-time-chart')]")
                //SetFocus.run(ID:"//*[contains(@id,'highcharts')]")
                //WebElement element = Elements.find(ID:"//*[contains(@id,'highcharts')]//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[${x+1}][@text-anchor='middle' and text()='${year}']",Browser.Driver)
                //new Robot().mouseMove(element.getLocation().getX()+25, element.getLocation().getY()-205)
                //Actions a = new Actions(Browser.Driver)
                //a.moveToElement(element, 0, -205).build().perform()
                sleep(2000)
                if(params."Projected"){
                    def projected = params."Projected".split(";")
                    println("Projected: ${projected[x]}")
                     if(projected[x] =="<EMPTY>"){
                        assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')]//*[contains(.,'Projected: ${projected[x]}') and not(contains(@style,'Lucida Grande'))]")==0,"Error - Projected Benefit should not be displayed for ${year} but is displayed"
                    } else {
                    	assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')]//*[contains(.,'Projected: ${projected[x]}') and not(contains(@style,'Lucida Grande'))]")==1,"Error - Incorrect Projected Benefit for ${year}"}
                }                          
                if(params."Actual"){
                    def actual  = params."Actual".split(";")
                    println("Actual: ${actual[x]}")
                    if(actual[x] =="<EMPTY>"){
                        assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')]//*[contains(.,'Actuals: ${actual[x]}') and not(contains(@style,'Lucida Grande'))]")==0,"Error - Actual Benefit should not be displayed for ${year} but is displayed"
                    } else {
                    	assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')]//*[contains(.,'Actuals: ${actual[x]}') and not(contains(@style,'Lucida Grande'))]")==1,"Error - Incorrect Actual Benefit for ${year}"}
                }                           
                if(params."Target"){
                    def target  = params."Target".split(";")
                    println("Target: ${target[x]}")
                    if(target[x] =="<EMPTY>"){
                        assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')]//*[contains(.,'Target: ${target[x]}') and not(contains(@style,'Lucida Grande'))]")==0,"Error - Target should not be displayed for ${year}but is displayed"
                    } else {
                    	assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')]//*[contains(.,'Target: ${target[x]}') and not(contains(@style,'Lucida Grande'))]")==1,"Error - Incorrect Target Benefit for ${year}"}
                }                     
            }
        }     
    }
}