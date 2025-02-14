package actions.PipelineTopIdeas;

import java.lang.String
import java.util.ArrayList
import actions.selenium.Browser
import actions.selenium.utils.Elements
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.Keys
import actions.selenium.Click


class SelectIdeasInTopIdeas{
    public void run(def params){
        if(params."Idea Title(s)".size() > 1){
            println("Selecting multple ideas")
            println("Size: ${params."Idea Title(s)".size()}")
            Actions act = new Actions(Browser.Driver)
            //act.keyDown(Keys.SHIFT).perform()
            params."Idea Title(s)".each{
                act.keyDown(Keys.SHIFT).perform()
                println("Clicking on ${it}")
                //Click.run(ID:"//*[contains(@class,'f-idea')]//*[@class='f-idea-title ']/SPAN[contains(.,'${it}')]")
                //Click.run(ID:"//*[contains(@class,'f-idea-large')]//*[.='${it}']/../../..//*[contains(@class,'f-status-indicator-outline')]")
                Click.run(ID:"//*[contains(@class,'f-idea-large')]//*[contains(@class,'f-idea-title')]/SPAN[contains(.,'${it}')]/../../../DIV[contains(@class,'f-card-row')]/*[contains(@class,'f-status-indicator-outline')]")
                sleep(1000)
                act.keyUp(Keys.SHIFT).perform()
            }
            //act.keyUp(Keys.SHIFT).perform()
        }
        else if (params."Idea Title(s)".size() == 1){
            println("Selecting singluar idea")
            def ideaTitle = params."Idea Title(s)"[0] 
            //Click.run(ID:"//*[contains(@class,'f-idea')]//*[@class='f-idea-title ']/SPAN[contains(.,'${ideaTitle}')]")  
            Click.run(ID:"//*[contains(@class,'f-idea-large')]//*[contains(@class,'f-idea-title')]/SPAN[contains(.,'${ideaTitle}')]/../../../DIV[contains(@class,'f-card-row')]/*[contains(@class,'f-status-indicator-outline')]")
        }
    }
}