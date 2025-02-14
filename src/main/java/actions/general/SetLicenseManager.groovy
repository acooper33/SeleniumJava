package actions.general;

import actions.selenium.Click
import actions.selenium.SetCheckBox
import actions.selenium.SetText
import actions.selenium.ExecuteJavascript
import actions.selenium.Browser
import org.openqa.selenium.WebElement
import actions.selenium.utils.Elements
import actions.selenium.VerifyText

class SetLicenseManager{
    public static void run(def params){
        
        def system
        def modMsg1 = "Users whose Moderator licenses have been revoked will be "
        def modMsg2 = "automatically granted Brightidea Administrator licenses"
        def modMsg3 = "and will maintain their software role assignments. If no Brightidea Administrator licenses are available, additional “Overage” licenses will be automatically added."
        
        system = params."System".substring(params."System".indexOf("https:") + 8, params."System".indexOf("."))
        
        SetText.run(Text:system,ID:"//*[@id='select-affiliate-combobox']")
        Click.run(ID:"//*[@id='f-combobox-list']//*[contains(text(),'${system}')]")
        sleep(5000)
        //setting licensing model - BI Admin License
        if(params."Licensing Model"=="Standard Licensing Model"){
            Click.run(ID:"//INPUT[@id='f-model-option-standard']/..", "Type of Click":"Javascript")
            Click.run(ID:"//button[@id='clickToConfirmOkButton']")
            sleep(1000)
            if(params."Unlimited Brightidea Administrator License Type"){
            	Click.run(ID:"//DIV[contains(@class,'f-admin-license-area')]//INPUT[@id='f-admin-unlimited']/..")
            }else if(params."Brightidea Administrator License Type Purchased Count"){
                SetText.run(ID:"//DIV[contains(@class,'f-admin-license-area')]//INPUT[contains(@class,'f-license-input')]", Text:params."Brightidea Administrator License Type Purchased Count")
            }
        }
        //setting licensing model - Idea Box License
        if(params."Unlimited Idea Box Manager License Type"||params."Idea Box Manager License Type Purchased Count"){
            Click.run(ID:"//DIV[contains(@class,'f-license-row')]//INPUT[@id='f-standard-idea-box-model']/..")
            if(params."Unlimited Idea Box Manager License Type"){
                Click.run(ID:"//DIV[@class='f-standard-license ']//INPUT[@id='f-idea-box-unlimited']/..", "Type of Click":"Move to Element")
            }else if(params."Idea Box Manager License Type Purchased Count"){
                SetText.run(ID:"//DIV[@class='f-standard-license ']//INPUT[contains(@class,'f-license-input')]", Text:params."Idea Box Manager License Type Purchased Count")
            }
        }
        
        WebElement moderatorSection = Elements.find(ID:"//*[contains(@class,'f-license-moderator-row')]//INPUT[@id='f-standard-moderator']",Browser.Driver)
        ExecuteJavascript.run(Code:"arguments[0].scrollIntoView(true);", "Arguments":moderatorSection)
        
        if(params."Enable Brightidea Moderator License Type"==true){
            SetCheckBox.run(ID:"//DIV[contains(@class,'f-license-moderator-row')]//INPUT[@id='f-standard-moderator']/..", Check:params."Enable Brightidea Moderator License Type")
        }else if (params."Enable Brightidea Moderator License Type"==false){
            Click.run(ID:"//DIV[contains(@class,'f-license-moderator-row')]//INPUT[@id='f-standard-moderator']/..")
            if(params."Verify Disable Moderator License Message"){VerifyText.run(ID:"//DIV[contains(@class,'fractal-modal-body ')]", "Contains Text":params."Verify Disable Moderator License Message")}
            Click.run(ID:"//button[@id='clickToConfirmOkButton']")
        }
        SetCheckBox.run(ID:"//DIV[contains(@class,'f-moderator-license-area')]//INPUT[@id='f-idea-box-unlimited']/..", Check:params."Unlimited Moderator Licenses")
        SetText.run(ID:"//DIV[contains(@class,'f-moderator-license-area')]//INPUT[@class='f-license-input']", Text:params."Purchased Moderator Licenses")
        
        ExecuteJavascript.run(Code:"window.scrollTo(0, document.body.scrollHeight)")
        SetCheckBox.run(ID:"//*[@id='f-standard-idea-box-sys-manager']/..", Check:params."Enable IT System Admin role overlay")

        if(params."Require min one user assigned as IT System Admin"==true || params."Require min one user assigned as IT System Admin"==false){
          Click.run(ID:"//*[@id='f-it-manager-requirement']/../I")  
        }
        SetCheckBox.run(ID:"//INPUT/../../../../*[contains(@class,'f-whiteboard-checkbox')]", Check:params."Enable Whiteboard License")
        SetText.run(Text:params."Unlimited Board Creation",ID:"//*[@data-tooltip-id='whiteboard-license-tooltip']/../..//INPUT[contains(@class,'f-license-input')]")
        SetText.run(Text:params."Unlicensed Board limit count",ID:"//*[@data-tooltip-id='whiteboard-limit-count']/../..//INPUT[contains(@class,'f-license-input')]")
        Click.run(ID:"//*[@id='save-licenses']")
        sleep(2000)
    }
}