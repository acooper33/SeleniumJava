//Dont use this script
package actions.PipelineDashBoard;

import actions.selenium.*
import java.awt.Robot
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class VerifyMouseoverontheCumulativeViewonBusinessImpacttab{
    public void run(def params){

        if(params."Year"){
            params."Year".split(",").eachWithIndex{ year, x ->
                //ExecuteJavascript.run(Code:"window.focus();")
                Click.run(ID:"//*[@class='chart-title']/SPAN")
                WebElement element = Elements.find(ID:"//*[contains(@id,'highcharts')]//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[@text-anchor='middle'][${x+1}]/*[text()='${year}']",Browser.Driver)
                SetFocus.run(ID:"//*[contains(@id,'highcharts')]")
//                new Robot().mouseMove(element.getLocation().getX()+20, element.getLocation().getY()-200)
                new Actions(Browser.Driver).moveToElement(element, 0, -200).build().perform()
                if(params."Projected"){
                    def projected = params."Projected".split(";")
                    assert Exists.run(ID:"//*[contains(@style,'opacity: 1')]//*[@class='tooltip-point' and contains(.,'${projected[x]}')]/*[@class='tooltip-series' and text()='Projected:']")==1,"Error - Incorrect Projected Benefit for ${year}"}
                if(params."Actual"){
                    def actual = params."Actual".split(";")
                    assert Exists.run(ID:"//*[contains(@style,'opacity: 1')]//*[@class='tooltip-point' and contains(.,'${actual[x]}')]/*[@class='tooltip-series' and text()='Actuals:']")==1,"Error - Incorrect Actual Benefit for ${year}"}
                if(params."Target"){
                    def target = params."Target".split(";")
                    assert Exists.run(ID:"//*[contains(@style,'opacity: 1')]//*[@class='tooltip-point' and contains(.,'${target[x]}')]/*[@class='tooltip-series' and text()='Target:']")==1,"Error - Incorrect Target Benefit for ${year}"}
            }
        }     
    }
}
