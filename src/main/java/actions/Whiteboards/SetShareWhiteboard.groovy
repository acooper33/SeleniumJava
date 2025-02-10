package actions.Whiteboards;

import actions.selenium.SendKeys
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetFocus
import actions.selenium.SelectItem
//import actions.common.AppsCommon
import org.openqa.selenium.StaleElementReferenceException;
import actions.selenium.SetReactTags

class SetShareWhiteboard{
    public void run(def params){
        if(params."Click Share Button"==true){
            Click.run(ID:"//*[@class='f-canvas-top-bar-right']//BUTTON[@id='f-share-dialog-btn']")
        }        
        if(params."User(s)"){
            SetReactTags.setMemberTagsWithAddRemove("Field Name":"",User:params."User(s)","Add or Remove":params."User Add or Remove")
            //AppsCommon.NewUserPickerAddRemoveInSetupWizard("Field Name":"",User:params."User(s)","Add or Remove":params."User Add or Remove")
        }         
        if(params."Send Invite"==true){
            Click.run(ID:"//*[contains(@class,'f-send-invite') and .='Send Invite']")
            sleep(5000)
        }        
        if(params."User to Remove"){
            params."User to Remove".split(',').each{participant -> 
               Click.run(ID:"//*[@class='f-member']/SPAN[contains(.,'${participant}')]/../../DIV[contains(@class,'f-member-attr')]/BUTTON")

            }
            sleep(2000)
        }     
        if(params."Toggle anyone with link"== true){Click.run(ID:"//DIV[contains(@class, 'f-toggle-off')]")} 
        if(params."Toggle anyone with link"== false){Click.run(ID:"//DIV[contains(@class, 'f-toggle-on')]")}
        if(params."Anyone with link..."){
            Click.run(ID:"//INPUT[@id='f-member-share-toggle']/..//DIV[contains(@class,'fractal-dropdown')]//*[contains(@class,'f-wb-share-options')]", "Type of Click":"Javascript")
            Click.run(ID:"//INPUT[@ID='f-member-share-toggle']/..//DIV[contains(@class,'fractal-dropdown')]//UL[contains(@class,'f-dropdown-options')]/LI/DIV[contains(.,'${params."Anyone with link..."}')]")
        }
        if(params."Link to selected object"){
            try {
                 Click.run(ID:"//*[contains(@class,'f-footer')]//DIV[contains(@class,'f-select-object-checkbox')]")
            }catch (StaleElementReferenceException e){
            	System.out.println("Stale element encountered. Retrying...") 
               	sleep(1000)
             	Click.run(ID:"//*[contains(@class,'f-footer')]//DIV[contains(@class,'f-select-object-checkbox')]")
            }
        }
        if(params."Copy Link"){Click.run(ID:"//P[@class='f-canvas-copy-link']/A")}
        if(params.Action=='Close'){
            Click.run(ID:"//DIV[@class='close-button']/I", "Type of Click":"Javascript")
            println("Closed the Share dialog")
            sleep(1000)
        }
    }
}