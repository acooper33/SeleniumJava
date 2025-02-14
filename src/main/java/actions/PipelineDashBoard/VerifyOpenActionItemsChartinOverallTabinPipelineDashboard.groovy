package actions.PipelineDashBoard;

import actions.selenium.*
import java.awt.Robot
import java.awt.MouseInfo
import org.openqa.selenium.interactions.Actions
import actions.selenium.utils.Elements
import actions.selenium.Browser
import java.time.format.DateTimeFormatter
import org.openqa.selenium.WebElement
//import java.time.LocalDate
//import java.util.Date
import java.time.ZonedDateTime 
import java.time.ZoneOffset
import org.openqa.selenium.Point

class VerifyOpenActionItemsChartinOverallTabinPipelineDashboard{
    public void run(def params){

        SelectItem.run(ID:"//*[@id='pipeline-activity-select-timeframe']","Visible Text":params."View")  
        ZonedDateTime endDate= ZonedDateTime.now(ZoneOffset.UTC)
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd")      
        println(dateFormat.format(endDate))
        long number = Long.parseLong("${params."Number of Days Before"}")
        println(dateFormat.format(endDate.minusDays(number)))
        Click.run(ID:"//*[@id='open-actionitems-chart']/*[contains(@id,'highcharts')]//*[@class='highcharts-title']")
        sleep(3000)
        WebElement element = Elements.find(ID:"//*[@id='open-actionitems-chart']/*[contains(@id,'highchart')]//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[.='${dateFormat.format(endDate.minusDays(number))}']",Browser.Driver)
        //Click.run(ID:"//*[@id='open-actionitems-chart']/*[contains(@id,'highchart')]//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[.='${dateFormat.format(endDate.minusDays(number))}']")
        SetFocus.run(ID:"//*[@id='open-actionitems-chart']/*[contains(@id,'highchart')]//*[@class='highcharts-series-group']")
        Click.run(ID:"//*[@id='open-actionitems-chart']/*[contains(@id,'highchart')]//*[@class='highcharts-series-group']")
        sleep(2000)
        new Robot().mouseMove(element.getLocation().getX()+96,element.getLocation().getY()-26)
        Point p = MouseInfo.getPointerInfo().getLocation()
        int xcord = point.getX()
        System.out.println("Element's Position from left side Is "+xcord +" pixels.")
        int ycord = point.getY();
        System.out.println("Element's Position from top side Is "+ycord +" pixels.")
        //new Actions(Browser.Driver).moveToElement(element,0,-40).click().build().perform()
        assert Exists.run(ID:"//*[contains(@style,'opacity: 1')]//*[@class='tooltip-point' and contains(.,'${params."Open Action Items"}')]")==1,"Error - Incorrect Open Action Item count"
        //assert Exists.run(ID:"//*[contains(@style,'opacity: 1')]//*[@class='tooltip-point' and contains(.,'${params."Open Action Items"}')]/../*[@class='tooltip-title' and .='${dateFormat.format(endDate.minusDays(number))}']")==1,"Error - Incorrect Open Action Item count"
    }   
}
