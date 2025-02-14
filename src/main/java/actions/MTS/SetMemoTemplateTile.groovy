package actions.MTS;

import actions.selenium.*
import actions.WebstormHomepage.SetActionOnChangeBackgroundModal

class SetMemoTemplateTile{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-template-title') and text()='${params."Template"}']/../..")
        SetActionOnChangeBackgroundModal.setAction(Action:params."Action")
    }
}