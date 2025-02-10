package actions.PipelineStepsView;

import java.lang.String
import actions.selenium.Browser
import actions.selenium.utils.Elements
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.By
import org.openqa.selenium.Keys

import java.awt.Robot;
import java.awt.event.KeyEvent
import java.awt.event.InputEvent



class SelectTwoIdeasinPipelineStepspage{
    public void run(def params){
        Actions builder = new Actions(Browser.Driver)
        def foundElements = []
        foundElements = Browser.Driver.findElements(By.xpath("//SPAN[@class='step_header_name' and contains(text(),'${params."Step Name idea belongs to"}')]/../../../*[contains(@id,'step-content')]//*[@class='active-ideas']/DIV"))
		//println(params."Step Name idea belongs to")
        //println(foundElements.size())
        //println(foundElements.getClass())
        def ideas = []
        foundElements.each{elem ->
            params."Idea Name".each{name ->
                if(elem.getAttribute("innerHTML").contains("${name}")){
                    ideas.add(elem)
                    println("Class of elem: ${elem.getClass()}")
                }
        	}
        }
        println("Ideas size: ${ideas.size()}")
        //Action act = builder.keyDown(Keys.SHIFT).build()
        Robot robot = new Robot()
        //robot.keyPress(KeyEvent.VK_SHIFT)
        //robot.delay(1500)
            
        
        ideas.each{idea->
            //Browser.Driver.click(idea)
            //println("Class of idea: ${idea.getClass()}")
            //builder.keyDown(Keys.SHIFT).build().perform()
            idea.click()
            robot.keyPress(KeyEvent.VK_SHIFT)
            //robot.mouseMove(idea.getLocation().getX(), idea.getLocation().getY())
            //println("printing X: ")
            //println(idea.getLocation().getX())
            //println("printing Y: ")
            //println(idea.getLocation().getY())
            //robot.delay(1500)
            //robot.mousePress(InputEvent.BUTTON1_MASK)
            //robot.delay(1500)
            //robot.mouseRelease(InputEvent.BUTTON1_MASK)
            //robot.delay(1500) 
            println("Clicked on Idea")
            //robot.keyRelease(KeyEvent.VK_SHIFT)
        }
        robot.keyRelease(KeyEvent.VK_SHIFT)
    }
}