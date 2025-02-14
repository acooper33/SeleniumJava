package actions.PipelineTopIdeas;

import actions.selenium.Click
import actions.selenium.SetText

class SetListinTopIdeas{
    public void run(def params){
        if(params."Select Action"=="Delete"){
            Click.run(ID:"//DIV[@class='f-list-container']/UL/LI[contains(@class,'f-list-item')]/SPAN[@class='f-list-item-name' and contains(.,'${params."List to perform action on"}')]/../DIV[contains(@class, 'fractal-clickoutside')]")
        	Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI/SPAN[contains(.,'Delete')]")
        }else{
            if(params."Select Action"=="Add New List"){
            	Click.run(ID:"//DIV[contains(@class,'f-best-idea-left-wing')]//BUTTON[@data-tooltip-content='Add new List']")
        	}else if(params."Select Action"=="Rename"){
            	Click.run(ID:"//DIV[@class='f-list-container']/UL/LI[contains(@class,'f-list-item')]/SPAN[@class='f-list-item-name' and contains(text(),'${params."List to perform action on"}')]/../DIV[contains(@class, 'fractal-clickoutside')]")
        		Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]/LI/SPAN[contains(.,'Rename')]")
        	}
            if(params."New List Name"){
                SetText.run(ID:"//INPUT[@id='f-add-list-item']", Text:params."New List Name")
            }
            if(params."Action" == "Save"){
            	Click.run(ID:"//INPUT[@id='f-add-list-item']/../../BUTTON[@data-tooltip-content='Save']")                
            }else if(params."Action" == "Cancel"){
                Click.run(ID:"//INPUT[@id='f-add-list-item']/../../BUTTON[@data-tooltip-content='Close']") 
            }
            
        }
        sleep(1000)
    }
}