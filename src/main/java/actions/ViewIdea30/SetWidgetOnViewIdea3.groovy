package actions.ViewIdea30;

import actions.selenium.Click
import actions.selenium.SetText


class SetWidgetOnViewIdea3{
    public void run(def params){
        if(params."Widget Title"){
            def xpath = "//DIV[contains(@class,'f-component')]//SPAN[contains(@class,'f-component-title') and starts-with(.,'${params."Widget Title"}')]/.."
            if(params."Remove"){
                Click.run(ID:xpath+"//DIV[contains(@class,'f-component-edit-hover')]//BUTTON[@data-tooltip-content='Remove']")
            }else if(params."Configure"){
                Click.run(ID:xpath)
                Click.run(ID:xpath+"//DIV[contains(@class,'f-component-edit-hover')]//BUTTON[@data-tooltip-content='Configure']")
                if(params."Toggle Title On/Off"){
                    Click.run(ID:xpath+"//DIV[contains(@class,'f-component-edit')]//DIV[contains(@class,'f-checkbox')]")
                }
                if(params."Title"){
                    SetText.run(ID:xpath+"//DIV[contains(@class,'f-component-edit')]//INPUT[@id='f-component-title']", Text:params."Title")
                }
                if(params."Action"=="Cancel"){
                    Click.run(ID:xpath+"//DIV[contains(@class,'f-component-edit')]//DIV[contains(@class,'f-edit-buttons')]/A")
                }
                else if(params."Action"=="Save"){
                    Click.run(ID:xpath+"//DIV[contains(@class,'f-component-edit')]//DIV[contains(@class,'f-edit-buttons')]/BUTTON")
                }
                else if(params."Action"=="Close"){
                    Click.run(ID:xpath+"//DIV[contains(@class,'f-component-edit')]//DIV[contains(@class,'f-edit-buttons')]/following-sibling::BUTTON[contains(@class,'f-close-button')]")
                }                
            }
        }
    }
}