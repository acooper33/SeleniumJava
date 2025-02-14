package actions.ViewIdea3Fields;

import actions.selenium.Click

class SetViewIdea3DropdownTextField{
    public void run(def params){
        
        def path
        if(params."Column"=="Left"){
            Click.run(ID:"//*[contains(@class,'f-component-title') and .='${params."Field Name"}']/../..//*[@class='far fa-pencil']","Type of Click":"Javascript")
        } else{
            Click.run(ID:"//*[contains(@class,'f-component-title') and text()='${params."Field Name"}']/..//*[@class='far fa-pencil']","Type of Click":"Javascript")
        }
        
        sleep(2000)
        Click.run(ID:"//*[contains(@class,'f-dropdown-options')]/..//*[contains(@class,'f-dropdown-options')]//*[text()='${params."Field Value"}']") 
        sleep(2000)
    }
}