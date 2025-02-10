package actions.Whiteboards;

import actions.selenium.Click

class SetToolkitfromleftToolbar{
    public void run(def params){
        
        if(params."Toolkit Option"){
            Click.run(ID:"//*[contains(@class,'f-btn-sm f-btn-subtle')]//*[text()='${params."Toolkit Option"}']")
            sleep(2000)
        }    
    }
}