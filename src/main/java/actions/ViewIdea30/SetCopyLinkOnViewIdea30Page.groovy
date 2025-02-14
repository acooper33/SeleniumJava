package actions.ViewIdea30;

import actions.selenium.Click
import actions.selenium.Exists

class SetCopyLinkOnViewIdea30Page{
    public void run(def params){
       
        Click.run(ID:"//*[@data-test='f-test-idea-page-Dropdown-links']")
        if(params."Should the option be displayed"==true){
            assert Exists.run(ID:"//*[contains(@class,'fractal-dropdown')]//*[contains(@class,'f-dropdown-options')]//*[text()='${params."Menu Option Name"}']")==1, "Error - ${params."Menu Option Name"} option is not displayed"
        } else if (params."Should the option be displayed"==false){
           assert Exists.run(ID:"//*[contains(@class,'fractal-dropdown')]//*[contains(@class,'f-dropdown-options')]//*[text()='${params."Menu Option Name"}']")==0, "Error - ${params."Menu Option Name"} option is displayed" 
        }
        if(params."Click the Option"==true){
            Click.run(ID:"//*[contains(@class,'fractal-dropdown')]//*[contains(@class,'f-dropdown-options')]//*[contains(.,'${params."Menu Option Name"}')]")  
        }
    }
}