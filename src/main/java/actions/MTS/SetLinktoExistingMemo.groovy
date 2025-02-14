package actions.MTS;

import actions.selenium.*

class SetLinktoExistingMemo{
    public void run(def params){
        
        SetText.run(ID:"//*[@id='fractal-add-existing-input']",Text:params."Link")
        sleep(2000)
        if(params."Action"){
            if(params."Action"=="Confirm"){
                Click.run(ID:"//*[@data-test='modal-footer-submit']")
            } else {
                 Click.run(ID:"//*[@data-test='modal-footer-cancel']")
            }
        }
        
    }
}