package actions.SetupBI;

import actions.selenium.Click

class SetRestoreSubmissions{
    public void run(def params){
        
        if(params."Step"){
           Click.run(ID:"//*[@class='f-confirm-restore']//*[contains(@class,'fractal-clickoutside')][1]//*[contains(@data-test,'f-test-dropdown')]")
           Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'block')]//*[text()='${params."Step"}']")
       }
       if(params."Category"){
           Click.run(ID:"//*[@class='f-confirm-restore']//*[contains(@class,'fractal-clickoutside')][2]//*[contains(@data-test,'f-test-dropdown')]")
           Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'block')]//*[text()='${params."Category"}']")
       }
       if(params."Status"){
           Click.run(ID:"//*[@class='f-confirm-restore']//*[contains(@class,'fractal-clickoutside')][3]//*[contains(@data-test,'f-test-dropdown')]")
           Click.run(ID:"//*[contains(@class,'f-dropdown-options') and contains(@style,'block')]//*[text()='${params."Status"}']")
       }
        if(params."Action"){
            if(params."Action"=="Restore Submission"){
              Click.run(ID:"//*[@id='f-modal-submit']")  
            } else {
              Click.run(ID:"//*[@data-test='modal-footer-cancel']")  
            }
        }
    }
}