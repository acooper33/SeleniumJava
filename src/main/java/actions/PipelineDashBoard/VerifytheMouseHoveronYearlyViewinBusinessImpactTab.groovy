//Dont use this script
package actions.PipelineDashBoard;

import actions.selenium.*
import java.awt.Robot
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class VerifytheMouseHoveronYearlyViewinBusinessImpactTab{
    public void run(def params){

        SelectItem.run(ID:"//*[@id='select-gross-benefits-chart-type']","Visible Text":"Yearly")        
        sleep(7000)
        if(params."Year"){
            params."Year".split(",").eachWithIndex{ year, x ->
                Click.run(ID:"//*[@id='chart-projected-total']")
                WebElement element = Elements.find(ID:"//*[contains(@id,'highcharts')]//*[@class='highcharts-series highcharts-series-1 highcharts-tracker']/*[@fill='#1abc9c'][${x+1}]",Browser.Driver)
                SetFocus.run(ID:"//*[contains(@id,'highcharts')]//*[@class='highcharts-series highcharts-series-1 highcharts-tracker']/*[@fill='#1abc9c'][${x+1}]")
                //new Robot().mouseMove(element.getLocation().getX(),element.getLocation().getY())
				new Actions(Browser.Driver).moveToElement(element, 0, 0).build().perform()
                if(params."Projected"){
                    def projected = params."Projected".split(";")
                    assert Exists.run(ID:"//*[@class='highcharts-tooltip']//*[contains(.,'Projected: ${projected[x]}')]")==1,"Error - Incorrect Projected Benefit for ${year}"}
                if(params."Actual"){
                    def actual  = params."Actual".split(";")
                    assert Exists.run(ID:"//*[@class='highcharts-tooltip']//*[contains(.,'Actuals: ${actual[x]}')]")==1,"Error - Incorrect Actual Benefit for ${year}"}
                if(params."Target"){
                    def target  = params."Target".split(";")
                    assert Exists.run(ID:"//*[@class='highcharts-tooltip']//*[contains(.,'Target: ${target[x]}')]")==1,"Error - Incorrect Target Benefit for ${year}"}
            }
        }     
    }
}
