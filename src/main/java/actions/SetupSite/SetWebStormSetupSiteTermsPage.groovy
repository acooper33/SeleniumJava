package actions.SetupSite;

import actions.common.SetupCommon
import actions.selenium.*
import screens.ReactFormDifferentFieldLocators
import screens.common.ModalButtonLocators

class SetWebStormSetupSiteTermsPage{
    public void run(def params){
        SetupCommon.NavigateTab(Tab:"Site",Section:"Terms")

        
        if(params."Terms and Conditions"){
            def fieldParams = [
                    'Field Value': params."Terms and Conditions"
                ]
            ReactFormDifferentFieldLocators.run(fieldParams)
            if (params."Terms and Conditions" in ["System Terms and Conditions", "Initative Terms and Conditions"]) {
                Click.run("ID Type": "By", By: ReactFormDifferentFieldLocators.radioButtonWithoutFieldName);
            }
        }
         if(params."Initiative Terms and Conditions Description Field"){
            if(params."Click on Initiative Terms and Conditions Description Field"==true){
                SetFocus.run(ID:"//*[@id='f-f-terms-conditions']/../DIV[2]")
            }            
            SetText.run(ID:"//*[@id='f-f-terms-conditions']/../DIV[2]",Text:params."Initiative Terms and Conditions Description Field","Type of Clear":"None")
            sleep(3000)
        }
        
        if(params."Require scroll through all terms"){
            def fieldParams = [
                    'Field Value': "Require scroll through all terms"
                ]
            ReactFormDifferentFieldLocators.run(fieldParams)
            if(params."Require scroll through all terms"==true) {
            	Click.run("ID Type":"By", By:ReactFormDifferentFieldLocators.multiChoiceWithoutFieldNameCheckboxUnChecked)
        	} else {
            	Click.run("ID Type":"By", By:ReactFormDifferentFieldLocators.multiChoiceWithoutFieldNameCheckboxChecked)
        	}
        }
        if(params."Reset Terms for All Users"){
            if(params."Reset Terms for All Users"==true) {
            	Click.run(ID:"//BUTTON[@data-tooltip-id='f-terms-tooltip']")
                ModalButtonLocators.run(params) 
                if(params."Reset Terms for All Users Action"=="Reset Terms"){
                     Click.run("ID Type":"By", By:ModalButtonLocators.confirmOKButton)
                } else {
                    Click.run("ID Type":"By", By:ModalButtonLocators.confirmCancelButton)
                }
        	}
        }
        if(params."Action"=="Save Changes"){
            Click.run(ID:"//*[contains(@class,'f-terms-submit')]")
        }        
        sleep(1000)
    }
} 
