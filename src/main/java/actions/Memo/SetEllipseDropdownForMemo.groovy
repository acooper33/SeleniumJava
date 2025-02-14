package actions.Memo;

import actions.selenium.Click
import actions.selenium.SetFocus
import actions.selenium.ExplicitWait

class SetEllipseDropdownForMemo{
    public void run(def params){
        
        ExplicitWait.run(ID:"//*[@class='f-memo-thumbnail-title' and .='${params."Memo Title (Required)"}']")
        SetFocus.run(ID:"//*[@class='f-memo-thumbnail-title' and .='${params."Memo Title (Required)"}']")
        if(params."Click Open Document (for VI3)"){
            Click.run(ID:"//*[@class='f-memo-thumbnail-title' and .='${params."Memo Title (Required)"}']/../../..//*[contains(@class,'f-memo-thumbnail-actions')]/BUTTON")
        }else if(params."Click Ellipse Menu"){
            Click.run(ID:"//*[@class='f-memo-thumbnail-title' and .='${params."Memo Title (Required)"}']/../../..//*[contains(@class,'f-dropdown-defaults')]/DIV")
        }
        if(params."Menu Item"){
            Click.run(ID:"//UL[contains(@class,'f-dropdown-options') and contains(@style,'display: block')]/LI//SPAN[contains(.,'${params."Menu Item"}')]")
        }
        if(params."Delete Action"){
            if(params."Delete Action"=="Delete"){
                Click.run(ID:"//BUTTON[@id='clickToConfirmOkButton']")
            } else if(params."Delete Action"=="Cancel"){
                Click.run(ID:"//BUTTON[@id='clickToConfirmCancelButton']")
            }
            sleep(1000)
        }
    }
}
