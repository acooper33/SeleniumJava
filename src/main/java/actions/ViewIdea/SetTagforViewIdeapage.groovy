package actions.ViewIdea;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SendKeys
import actions.selenium.MouseOver

import org.openqa.selenium.JavascriptExecutor
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class SetTagforViewIdeapage{
    public void run(def params){
        if(params."Tag Name"){
            params."Tag Name".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove"){
                    if(params."Add or Remove".split(",")[x]=="Add"){
                        SetText.run(ID:"//*[@id='add-tag-input']",Text:name)
                        sleep(3000)
                        SendKeys.run(ID:"//*[@id='add-tag-input']",Key:"ENTER")
                    }
                    else{
                        Click.run(ID:"//*[@id='idea-tags-wrapper']//*[text()='${name}']/../../SPAN[@class='tag_right']")
                    }
                }
                sleep(1000)
                if(params."Subscribe or Unsubscribe"){
                	MouseOver.run(ID:"//*[@class='tag_left']/A[text()='${name}']")
                    Click.run(ID:"//*[@id='tag-fly-btn' and text()='${params."Subscribe or Unsubscribe"}']")
                    sleep(3000) 
                    
                
                }
            }
        }
    }
}