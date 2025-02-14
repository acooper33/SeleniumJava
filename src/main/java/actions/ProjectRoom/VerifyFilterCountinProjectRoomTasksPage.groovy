package actions.ProjectRoom;

import actions.selenium.Exists
import actions.selenium.Click

class VerifyFilterCountinProjectRoomTasksPage{
    public void run(def params){
        
        if(params."Message"){
            if(params."Message Displayed"==true){
                assert Exists.run(ID:"//*[contains(@class,'f-tasks-filter-group')]/*[text()='${params."Message"}']")==1, "Error - 'Filter is not applied"
                assert Exists.run(ID:"//*[contains(@class,'f-btn-standard f-btn-align-center f-dropdown-btn f-has-filter')]")==1, "Error - 'Filter is not applied on the button"
            } else {
            	assert Exists.run(ID:"//*[contains(@class,'f-tasks-filter-group')]/*[text()='${params."Message"}']")==0, "Error - 'Filter should not be applied but is applied"  
                assert Exists.run(ID:"//*[contains(@class,'f-btn-standard f-btn-align-center f-dropdown-btn f-has-filter')]")==0, "Error - 'Filter is applied on the button"
            }
        }
        if(params."Clear Filter"==true){
            Click.run(ID:"//*[contains(@class,'f-tasks-filter-group')]/BUTTON[contains(@class,'f-btn-link-style')]")
            sleep(3000)
        }        
    }
}