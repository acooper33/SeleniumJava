package actions.Rules;

import actions.selenium.*
import actions.selenium.Exists
import actions.selenium.ExplicitWait
    
class SetAddCreateRule{
    public void run(def params){
        //Click.run(ID:"//*[contains(@class,'f-rules-actions-dropdown')]/BUTTON")
        
        if(Exists.run(ID: "//*[contains(@class,'f-rules-actions-dropdown')]/BUTTON")){           
        	Click.run(ID:"//*[contains(@class,'f-rules-actions-dropdown')]/BUTTON")
        }else{
        	Click.run(ID:"//*[@id='rule-action-btn']")
        	Click.run(ID:"//*[@id='actions-list']/LI/A[@id='action-add-rule']")            
        }
        
        // Supports the two version of the rules dialog box
		ExplicitWait.run(ID:"//*[@id='bitop-header'][.='Create Rule'] | //*[@class='f-rules-content']")
		

    }
}