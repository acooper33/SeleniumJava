package actions.PipelineDashBoard;

import actions.selenium.*
import java.awt.Robot
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class VerifyCurrentIdeasPerSteponOveralltabinPipelineDashboard{
    public void run(def params){

        params."Step".split(",").eachWithIndex{ step, x ->
            def ideas = params."Number of Ideas".split(",")
            Click.run(ID:"//*[@id='wrap-fractal-dashboard-overall']//SPAN[@class='f-section-title' and text()='Current Ideas Per Step']")
            WebElement element = Elements.find(ID:"//*[contains(@class,'fractal-highchart-base ideas-in-step-chart')]/*[contains(@id,'highcharts')]//*[contains(@class,'highcharts-axis-labels highcharts-xaxis-labels')]/*[.='${step}']",Browser.Driver)
            SetFocus.run(ID:"//*[@id='ideas-in-step-chart']/*[contains(@id,'highcharts')]//*[@class='highcharts-series-group']")
            //new Robot().mouseMove(element.getLocation().getX()-26,element.getLocation().getY()-100)
             new Actions(Browser.Driver).moveToElement(element, -26, -100).build().perform()
            assert Exists.run(ID:"//*[contains(@style,'opacity: 1')]//*[@class='tooltip-point' and contains(.,'${ideas[x]}')]/../*[@class='tooltip-title' and .='${step}']")==1,"Error - Incorrect Number of years for ${step}"
        }          
    }
}

