package actions.Memo;

import actions.selenium.Click

class SetActionMenuonMemoCard{
    public void run(def params){
        
        Click.run(ID:"//*[@class='f-memo-thumbnail-title' and text()='${params."Memo Title"}']/../../..//*[contains(@class,'f-btn-standard fa-ellipsis-h')]")
        if(params."Menu Option"){
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]//SPAN[contains(text(),'${params."Menu Option"}')]")
        }
        if(params."Delete Action"){
            if(params."Delete Action"=="Delete"){
                Click.run(ID:"//BUTTON[@id='clickToConfirmOkButton']")
            } else if(params."Delete Action"=="Cancel"){
                Click.run(ID:"//BUTTON[@id='clickToConfirmCancelButton']")
            }
        }
    }
}