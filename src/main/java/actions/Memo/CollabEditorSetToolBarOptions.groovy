package actions.Memo;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SendKeys
import actions.selenium.SetFocus


import actions.selenium.utils.Elements
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import org.openqa.selenium.Keys

import org.openqa.selenium.interactions.Actions

class CollabEditorSetToolBarOptions{
    public void run(def params){
        if(params."Undo or Redo"=="Undo"){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Undo']")}
        if(params."Undo or Redo"=="Redo"){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Redo']")}
        
        if(params."Text Font"){ //OK
            Click.run(ID:"//INPUT[@id='f-slate-font-select']")
            sleep(1000)
            Click.run(ID:"//*[contains(@id,'f-combobox-list') and not(contains(@style,'none'))]/DIV[contains(@class,'f-combobox-list-item')]//SPAN[.='${params."Text Font"}']")
            sleep(1000)
            Click.run(ID:"//DIV[@role='textbox']/P")
            sleep(5000)
        }
        if(params."Text Format"){ //ok
            Click.run(ID:"//INPUT[@id='f-slate-format-select']/../BUTTON")
            sleep(1000)
            Click.run(ID:"//*[contains(@id,'f-combobox-list') and (contains(@style,'flex'))]/DIV[contains(@class,'f-combobox-list-item')]//SPAN[.='${params."Text Format"}']")
            sleep(1000)
            Click.run(ID:"//DIV[@role='textbox']/P")
            sleep(3000)
        }
        if(params."Font Size"){ //broken right now, tiket filed
            Click.run(ID:"//INPUT[@id='f-slate-font-size-input']")
            sleep(500)
            Click.run(ID:"//*[contains(@id,'f-combobox-list') and not(contains(@style,'none'))]//*[contains(text(),'${params."Font Size"}')]")
            Click.run(ID:"//DIV[@role='textbox']/P")
            sleep(1000)
        }
        if(params."Bold, Italic, Underlined etc"){
            println("Bold, Italic, Underlined etc is ${params."Bold, Italic, Underlined etc"}")
            if(params."Bold, Italic, Underlined etc".contains("Bold")){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Bold']")}
        	else if(params."Bold, Italic, Underlined etc".contains("Italic")){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Italic']")}
        	else if(params."Bold, Italic, Underlined etc".contains("Underlined")){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Underlined']")}
        	else if(params."Bold, Italic, Underlined etc".contains("Strikethrough")){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Strikethrough']")}
        }
        if(params."Hex Font Color"){ //OK
            Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Font Color']")
            SetFocus.run(ID:"//INPUT[contains(@id,'rc-editable-input')]")
            SetText.run(ID:"//INPUT[contains(@id,'rc-editable-input')]", "Type of Clear":"Backspace", Text:params."Hex Font Color")
            Click.run(ID:"//DIV[contains(@class,'f-status-indicator')]")
            sleep(2000)
        }
        if(params."Hex Color for Font Highlight"){ //OK
            Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Font Highlight']")
            SetFocus.run(ID:"//INPUT[contains(@id,'rc-editable-input')]")
            SetText.run(ID:"//INPUT[contains(@id,'rc-editable-input')]","Type of Clear":"Backspace", Text:params."Hex Color for Font Highlight")
            Click.run(ID:"//DIV[contains(@class,'f-status-indicator')]")
            sleep(2000)
        }
        if(params."Align"){
            if(params."Align".contains("Left")){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Left Align']")}
            else if(params."Align".contains("Right")){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Right Align']")}
            else if(params."Align".contains("Center")){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Center Align']")}
        }
        if(params."Numbered List or Bullet List"=="Numbered"){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Numbered List']")}
        if(params."Numbered List or Bullet List"=="Bullet"){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Bullet List']")}
        if(params."Hyperlink"){
            Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Hyperlink']")
            Click.run(ID:"//INPUT[@id='f-slate-link-input']")
            SetText.run(ID:"//INPUT[@id='f-slate-link-input']", Text:params."Hyperlink")
            sleep(1000)
            Click.run(ID:"//INPUT[@id='f-slate-link-input']/../../BUTTON")
            sleep(5000)
        }
        if(params."Indent"){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Indent']", "Handle Stale Element": true)}
        if(params."Outdent"){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Outdent']", "Handle Stale Element": true)}
        if(params."Insert Image"){Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Insert or Generate Image']", "Handle Stale Element": true)}
        if(params."Brightidea AI"!=null){
            switch (params."Brightidea AI"){
                case "Main Button":
                Click.run(ID:"//BUTTON[contains(@class,'f-ai-btn')]")
                break;
                default:
                Click.run(ID:"//BUTTON[contains(@class,'f-ai-btn')]/../..//DIV[contains(@class,'fractal-dropdown')]")
                Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]//*[contains(.,'${params."Brightidea AI"}')]")
                break;
            }
        }
        if(params."Comments"){
            SetFocus.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Comments']")
            Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Comments']")}
        if(params."Export"){
            Click.run(ID:"//DIV[contains(@class,'f-slate-toolbar')]/BUTTON[@data-tooltip-content='Export']", "Handle Stale Element": true)
        	sleep(5000)
        }
        sleep(2000)
    }
}