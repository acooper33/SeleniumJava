package actions.ProjectRoom;

import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import actions.selenium.*
    
class VerifyLanderonProjectRoom{
    public void run(def params){
        
        sleep(3000)
        if(params."Empty State" ==true){
             assert Exists.run(ID:"//*[@id='f-project-room-task-stat-chart']")==0, "Error - 'Empty state not displayed"
        } else {
            assert Exists.run(ID:"//*[@id='f-project-room-task-stat-chart']")==1, "Error - 'Empty state displayed"
            Actions a = new Actions(Browser.Driver)
            if(params."Status"){
                params."Status".split(",").eachWithIndex{ status, x ->
                    SetFocus.run(ID:"//*[contains(@id,'highcharts')]")
                	WebElement element = Elements.find(ID:"//*[contains(@id,'highcharts')]//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[${x+1}][@text-anchor='middle' and text()='${status}']",Browser.Driver)
                	a.moveToElement(element, 0, -75).build().perform()
                	List <WebElement> elementList = Elements.findAll(ID:"//*[contains(@id,'highcharts')]//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/*[@text-anchor='middle']",Browser.Driver)
                	elementList.each{item -> 							
                	println("label text: ${item.getText()}")
                    if(item.getText().contains(status)){
                        a.moveToElement(item, 0, -75).build().perform()}
                    }
                    sleep(2000)
                	if(params."Tasks Count"){
                    def count = params."Tasks Count".split(",")
                    println("Count: ${count[x]}")
                    assert Exists.run(ID:"//*[contains(@class,'highcharts-tooltip')]//*[contains(.,'${status}${count[x]}') and not(contains(@style,'Lucida Grande'))]")==1,"Error - In correct Task count for ${status}"}
                }   
            }
        }
    }
}