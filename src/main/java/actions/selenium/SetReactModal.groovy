package actions.selenium;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Exists
import actions.selenium.SetCombobox
import actions.selenium.SetFocus

class SetReactModal{
    public static void setModalRadioButtonWithInput(def params){
        //sets radio button and the text input next to it; Send to Whiteboard, Send to Project Room, Send to Smart
        //Section xPath - path to the modal (helpful on VI3), or path to the modal section we are setting
        //Radio Option - Existing, New, etc Label next to the radio
        //Title - of the whiteboard, etc
       
        //select radio option in the given section
        if(params."Section xPath"==null){params."Section xPath"=""}
        if(params."Radio Option"){
            Click.run(ID:params."Section xPath"+"//*[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'${params."Radio Option".toUpperCase()}')]/../DIV", "Handle Stale Element":true)
			Click.run(ID:params."Section xPath"+"//*[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'${params."Radio Option".toUpperCase()}')]/../DIV", "Handle Stale Element":true)
        	sleep(500)
        }
        if(Exists.run(ID:params."Section xPath"+"//DIV[contains(@class,'f-combobox-input')]")>0){
            println("Selecting Existing...")
            SetCombobox.run(ID:params."Section xPath"+"//INPUT[contains(@class,'f-combobox-input')]", Option:params."Title")
        }else{
			println("Selecting New...")
            SetText.run(ID:params."Section xPath"+"//INPUT[contains(@id,'name') and (contains(@placeholder,'title') or contains(@placeholder,'Name')) ]",Text:params."Title")
        }
    }
    
    public static void setModalActionButton(def params){
        //clicks on Submit or Cancel button in the modal footer
        //Modal xpath - path to the modal most upper div (helpful on VI3); in most cases it is DIV with class containing modal name
        //Action - action button to click
        if(params."Modal xPath"==null){params."Modal xPath"=""}
        if(params.Action!="Cancel"){
            SetFocus.run(ID:params."Modal xPath"+"//*[contains(@class,'footer')]//BUTTON[contains(@class,'f-btn-primary')]")
            Click.run(ID:params."Modal xPath"+"//*[contains(@class,'footer')]//BUTTON[contains(@class,'f-btn-primary')]")
            
        }else if (params.Action=="Cancel") {
            Click.run(ID:params."Modal xPath"+"//*[contains(@class,'footer')]//*[contains(@class,'f-btn-subtle') and .='Cancel']")
        }
    }
    
    public static void setModalWithOneInputField(def params){
        // sets text in the input field
        // Text - input text
        if(params.'Order Num' == null){ params.'Order Num'="1" }
        Click.run(ID:"//DIV[contains(@class,'modal')]//DIV[contains(@class,'modal-body')]//DIV[contains(@class,'fractal-input') and position()='${params.'Order Num'}']//INPUT")
        SetText.run(ID:"//DIV[contains(@class,'modal')]//DIV[contains(@class,'modal-body')]//DIV[contains(@class,'fractal-input') and position()='${params.'Order Num'}']//INPUT", "Text":params."Text")
    }
}