package actions.PipelineDashBoard;

import actions.selenium.*
import java.awt.Robot
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import java.time.temporal.ChronoUnit
import java.time.LocalDate
import org.openqa.selenium.interactions.Actions
import java.text.DecimalFormat;

class VerifyAverageDaysPerStepinOverallTabinPipelineDashboard{
    public void run(def params){

        params."Step".split(",").eachWithIndex{ step, x ->
            Click.run(ID:"//*[@id='wrap-fractal-dashboard-overall']//SPAN[@class='f-section-title' and text()='Average Days per Step']")
            WebElement element = Elements.find(ID:"//*[contains(@class,'fractal-highchart-base days-in-step-chart')]/*[contains(@id,'highcharts')]//*[contains(@class,'highcharts-axis-labels highcharts-xaxis-labels')]/*[.='${step}']",Browser.Driver)
            SetFocus.run(ID:"//*[@id='days-in-step-chart']/*[contains(@id,'highcharts')]//*[@class='highcharts-series-group']")
//            new Robot().mouseMove(element.getLocation().getX()-50,element.getLocation().getY()-100)
            new Actions(Browser.Driver).moveToElement(element, 0, -100).build().perform()
            LocalDate startDate = LocalDate.parse("2016-10-12")
            LocalDate endDate = LocalDate.now()
            int n = params."Number of Ideas".toInteger()
            final long days = ChronoUnit.DAYS.between(startDate,endDate)
            println(days)
            final long noOfDates = (days*3)/n
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
      		String numberAsString = decimalFormat.format(noOfDates);
            println(numberAsString)
            assert Exists.run(ID:"//*[contains(@style,'opacity: 1')]//*[@class='tooltip-point' and contains(.,'${numberAsString}')]/../*[@class='tooltip-title' and .='${step}']")==1,"Error - Incorrect average days ${numberAsString}"
        }          
    }
}