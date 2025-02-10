package actions.selenium;

import actions.selenium.Click
import actions.selenium.ExecuteJavascript
import actions.selenium.Exists
import java.io.*


class VerticalScrollUntilExists{
    public static boolean run(def params){
        //boolean success = false
        def y = 200
        while(y<1000){
            
                println("We are in while loop")
                ExecuteJavascript.run(Code:"window.scrollTo(0, ${y});")
                if(Exists.run(ID:params.ID)>0){
                    return true
                }else{y+=${params."Y-axis interval".toInteger()}}
               
                
                //Click.run(ID:"//*[@class='f-question-wrapper ']/DIV[contains(@class,'f-question-header')]/DIV/H3[normalize-space()='${params."Question"}']/../../DIV[contains(@class,'f-question-header-actions')]//DIV[@class='f-question-action' and normalize-space()='${params."Edit or Hide or Remove"}' ]")
            	//HandleWarningPopUp(params."Action on Edit, Hide or Remove")
                
            
        }
                return false

        
    }
}