package actions.PipelineTopIdeas;

import actions.selenium.*
import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

class VerifySmartMatrixinTopIdeas{
    public void run(def params){
        
        def path
        path = "//*[contains(@class ,'f-best-idea-stack')]//DIV[contains(@class,'f-idea')]//DIV[contains(@class,'f-idea-title')]/SPAN[contains(.,'${params."Idea"}')]"
        SetFocus.run(ID:"${path}")
        WebElement element = Elements.find(ID:"//*${path}/../..//*[@class='f-eval-results-square']",Browser.Driver)
        Actions a = new Actions(Browser.Driver)
        a.moveToElement(element, 0, 1).build().perform()
        
       if(params."Score"){
           assert Exists.run(ID:"${path}/../..//*[contains(@class,'react-tooltip__show')]//P[1][.='Score: ${params."Score"}']")==1, "Error - 'Incorrect score displayed"
        }else{
            assert Exists.run(ID:"${path}/../..//*[contains(@class,'react-tooltip__show')]//P[1][.='Score: ${params."Score"}']")==0, "Error - 'Score should not be displayed"            
        }
       
        if(params."X Axis"){
            assert Exists.run(ID:"${path}/../..//*[contains(@class,'react-tooltip__show')]//P[2][.='${params."X Axis"}: ${params."X coordinate"}']")==1, "Error - 'Incorrect X coordinate displayed"
        }else{
            assert Exists.run(ID:"${path}/../..//*[contains(@class,'react-tooltip__show')]//P[2][.='${params."X Axis"}: ${params."X coordinate"}']")==0, "Error - 'X axis and coordinate should not be displayed"            
        }
        
         if(params."Y Axis"){
            assert Exists.run(ID:"${path}/../..//*[contains(@class,'react-tooltip__show')]//P[3][.='${params."Y Axis"}: ${params."Y coordinate"}']")==1, "Error - 'Incorrect Y coordinate displayed"
        }else{
            assert Exists.run(ID:"${path}/../..//*[contains(@class,'react-tooltip__show')]//P[3][.='${params."Y Axis"}: ${params."Y coordinate"}']")==0, "Error - 'Y axis and coordinate should not be displayed"            
        }
        
        if(params."Click on Smart Matrix" == true){
            Click.run(ID:"${path}/../..//*[@class='f-matrix-link']")           
        }
    }
}