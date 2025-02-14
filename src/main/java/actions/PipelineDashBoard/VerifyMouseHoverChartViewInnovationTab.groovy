package actions.PipelineDashBoard;

import actions.selenium.*
import actions.common.Highcharts.Highcharts
import java.awt.Robot
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException;



class VerifyMouseHoverChartViewInnovationTab{
    
    protected Highcharts highchart;
    protected List<String> lines = new ArrayList<String>();
    protected String unmatchedLine;
    protected String displayedText;
        
    public void run(def params) throws NoSuchElementException{
        
        
        //switch chart view if provided
        if(params."Chart View"){
            println("Will select chart view: ${params."Chart View"}")
            SelectItem.run(ID:"//*[@id='chart-date-picker']","Visible Text":params."Chart View")
        	sleep(1000)
        	Click.run(ID:"//DIV[@id='top-region']//*[contains(@class,'sub-header')]")
        }	
        if(params."Previous Period View"){
            println("Will select chart view: ${params."Previous Period View"}")
            SelectItem.run(ID:"//*[@id='prev-date-picker']","Visible Text":params."Previous Period View")
            sleep(1000)
            Click.run(ID:"//DIV[@id='top-region']//*[contains(@class,'sub-header')]")
        }
        
        //what chart we testing?
        if(params."What Chart?"){
            switch(params."What Chart?"){
                case "Innovations Submitted over Time":
                    highchart = new Highcharts(Browser.Driver, 'overall-chart')
                    break
                case "Innovations Created in Period vs. Prior Period":
                    highchart = new Highcharts(Browser.Driver, 'comparative-chart')
                    break
                case "Innovations Submitted by Department":
                    highchart = new Highcharts(Browser.Driver, 'departments-chart')
                    break
                case "Innovations Submitted by Location":
                    highchart = new Highcharts(Browser.Driver, 'locations-chart')
                    break
                case "Innovations Submitted by Initiative":
                    highchart = new Highcharts(Browser.Driver, 'challenges-chart')
                    break
                case "Innovations by Status":
                    highchart = new Highcharts(Browser.Driver, 'overall-status-chart')
                break
        	}
        	highchart.setFocusOnChart()
        }
        
        
        //what column should we mouse over?
        if(params."What column to hover over?"){highchart.HoverOverColumnWithLabelText(params."What column to hover over?")}

        if(params."Tooltip Text"){
            if(highchart.isTooltipDisplayed()){displayedText = highchart.getTextFromTooltip()}
            else{throw new NoSuchElementException("Tooltip is not displayed!")}
            
            //format expected text to compare with the displayed text
            if(params."Tooltip Text".contains("today last month")){params."Tooltip Text" = params."Tooltip Text".replace("today last month", highchart.substractDateForTooltip(0,1,0))}
            if(params."Tooltip Text".contains("today last year")){
                println("Contains last year")
                params."Tooltip Text" = params."Tooltip Text".replace("today last year", highchart.substractDateForTooltip(0,0,1))}
            if(params."Tooltip Text".contains("today")){params."Tooltip Text" = params."Tooltip Text".replace("today",highchart.substractDateForTooltip(0,0,0))}
            println("Our formatted tooltip to seach for: ${params."Tooltip Text"}")
            
            assert (displayedText.equals(params."Tooltip Text".replace(" ",""))), "Displayed tooltip '${displayedText}' does not match expected '${params."Tooltip Text".replace(" ","")}'."
            
        }
        if(params."Legend to Verify"){
            if(highchart.isLegendDisplayed()){
                displayedText = highchart.getTextFromLegend()
                println("Verifying displayed legend: '${displayedText}'...")
            }else{throw new NoSuchElementException("Legend is not displayed!")}
           	
            assert (displayedText.equals(params."Legend to Verify".replace(" ","").replace(",",""))), "Displayed legend '${displayedText}' does not match expected '${params."Legend to Verify".replace(" ","")}'."
        }
    }    
}