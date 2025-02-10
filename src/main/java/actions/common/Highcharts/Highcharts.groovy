package actions.common.Highcharts;

import actions.selenium.Browser
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import java.time.format.DateTimeFormatter
import java.time.ZonedDateTime 
import java.time.ZoneOffset
import java.time.temporal.ChronoUnit
import java.time.LocalDate

class Highcharts{
    
    protected WebElement chart;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions performAction;
    private List<WebElement> xAxisLabels;
    private WebElement tooltip;
    private WebElement legend; 
    private String actualLabelText;
    private WebElement actualHoverLabel;
    private int xOffSet;
    
    public Highcharts(WebDriver driver, String chartStr){
        
        this.driver = driver;
        this.chart = driver.findElement(By.xpath("//*[contains(@id,'${chartStr}')]"));
        int waitTimeoutInSeconds = 15;
        wait = new WebDriverWait(driver, waitTimeoutInSeconds, 100);
        performAction = new Actions(this.driver);
        xAxisLabels = this.chart.findElements(By.xpath(".//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[@text-anchor='middle']"))  
        xOffSet = 0
        
   	}
    
    protected boolean HoverOverColumnWithLabelText(String myText){
        getActualHoverLabel(myText)
        performAction.moveToElement(actualHoverLabel,xOffSet,-205).build().perform()
    }
    
    protected boolean isTooltipDisplayed(){
        try{
            tooltip = this.chart.findElement(By.xpath(".//DIV/DIV[contains(@class,'highcharts-tooltip')]"))
            return true
        }catch (NoSuchElementException e){
            return false
        }
    }  
    
    protected boolean isLegendDisplayed(){
        try{
            legend = this.chart.findElement(By.xpath(".//*[contains(@class,'highcharts-legend')]"))
            return true
        }catch (NoSuchElementException e){
            return false
        }
    }
    
    protected String getTextFromTooltip(){
        String myStr = getTextFrom(tooltip)
        println("New Method Tooltip Text Wihtout Spec Chars: ${cleanFromSpecialChars(myStr)}")
        return myStr
    }
    
    protected String getTextFromLegend(){
    	return getTextFrom(legend)
    }
    
    protected String getTextFrom(WebElement element){
        String myStr = element.getText()
        return cleanFromSpecialChars(myStr)
    }
        
    private void setFocus(WebElement element){
        new Actions(this.driver).moveToElement(element).perform();
    }
    private void setFocusOnChart(){
        new Actions(this.driver).moveToElement(this.chart).perform();
    }
    
    private WebElement getLastXLabel(){
        return getXLabel(xAxisLabels.size())
    }
    
    private WebElement getXLabel(int labelNo){
        return xAxisLabels[labelNo-1]
    } 
    private boolean getActualHoverLabel(String myText){
        //actualLabelText = myText 
        formatLabelTextToDate(myText, 0, 0, 0)
        int j = 0
        while(j<=5){
           // formatLabelTextToDate(actualLabelText, j, 0, 0)  
            int i = 0
        	while (i< xAxisLabels.size()) {
        		println("Our current label: ${xAxisLabels[i].getText()} ")
       			println("We are looking for label: ${actualLabelText}")
            	if(xAxisLabels[i].getText().equals(actualLabelText)){
            		println("Found")
                    actualHoverLabel = xAxisLabels[i]
                    return true
            	} 
            	i++
        	}
            formatLabelTextToDate(actualLabelText, 1, 0, 0)
            j++
            xOffSet = xOffSet+70 //if there is no label with the text, we will find the closest label and move to the right. 
        }
      	return false
    }
   
    //highchart helper methods
    private String cleanFromSpecialChars(String myStr){
        return myStr.replaceAll("[^a-zA-z\\d()?!%//]", "")
	}
    
    private String substractDateForTooltip(int daysToSubstract, int monthsToSubsract, int yearsToSubstract){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy")
        ZonedDateTime today= ZonedDateTime.now(ZoneOffset.UTC).minus(daysToSubstract,ChronoUnit.DAYS).minus(monthsToSubsract,ChronoUnit.MONTHS).minus(yearsToSubstract,ChronoUnit.YEARS)
        String dateStr = dateFormat.format(today)
        println("Formatted: ${dateStr}")
        return dateStr;
    }
    
    private void formatLabelTextToDate(String myDate, int daysToSubstract, int monthsToSubsract, int yearsToSubstract){
        println("myDate is ${myDate}")
        DateTimeFormatter dateFormat
        ZonedDateTime today= ZonedDateTime.now(ZoneOffset.UTC).minus(daysToSubstract,ChronoUnit.DAYS).minus(monthsToSubsract,ChronoUnit.MONTHS).minus(yearsToSubstract,ChronoUnit.YEARS)
        if(myDate.contains("today")){
            dateFormat = DateTimeFormatter.ofPattern("MMM-d-yy")
            actualLabelText = dateFormat.format(today)
        }else if(myDate.contains("days passed")){
            dateFormat = DateTimeFormatter.ofPattern("d")
            actualLabelText = dateFormat.format(today.minus(1,ChronoUnit.DAYS)) //labels show the day before since it is the number of days passed
            println("Days passed Label to look for is ${actualLabelText}")
        }else if(myDate.contains("month")){
            dateFormat = DateTimeFormatter.ofPattern("MM")
            actualLabelText = dateFormat.format(today)
        }else if(myDate.contains("year")){
            dateFormat = DateTimeFormatter.ofPattern("yyyy")
            actualLabelText = dateFormat.format(today)
        }else if(myDate.matches("[0-9]+")){
            actualLabelText = String.valueOf(myDate.toInteger()-daysToSubstract)
            println("(only nums) Label to look for is ${actualLabelText}")
        }else if(myDate.matches(".*[a-z].*")){
            dateFormat = DateTimeFormatter.ofPattern("MMM-d-yy")
            LocalDate atualDate = LocalDate.parse(myDate, dateFormat).minus(daysToSubstract,ChronoUnit.DAYS).minus(monthsToSubsract,ChronoUnit.MONTHS).minus(monthsToSubsract,ChronoUnit.YEARS);
            actualLabelText = dateFormat.format(atualDate)
            println("(nums & letters) Label to look for is ${actualLabelText}")
        }

    }
}
