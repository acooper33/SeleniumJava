package actions.SetupIdeas;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.ExecuteJavascript
import actions.common.SetupCommon
import actions.selenium.SelectItem
import actions.selenium.Exists
import java.lang.*

class SetWebstormSetupStatusesforIdeasTab{
    public void run(def params){
        
        SetupCommon.NavigateTab(Tab:"Ideas",Section:"Statuses")
        
        if(params."Status to Remove"){
            Click.run(ID:"//input[starts-with(@id,'custom-status-description') and @value='${params."Status to Remove"}']/../../..//td/div[starts-with(@id, 'delete_t')]")
            sleep(1000)
            if (params."Status to switch ideas to"){
                if(Exists.run(ID:"//BUTTON[@id='f-modal-submit']")>0){
                    Click.run(ID:"//*[@id='f-status-assign']//*[contains(@class,'f-dropdown-btn')]")
                    Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]//LI//*[starts-with(.,'${params."Status to switch ideas to"}')]")
                }else{
                    SelectItem.run(ID: "//div[@id='delete_custom_idea_status_popup']//select[@id='status-dropdown']", "Visible Text":params."Status to switch ideas to")
                    Click.run(ID:"//UL[contains(@class,'f-dropdown-options')]")
                }
            }
            sleep(2000)
            if(params."Action"=="Delete Status"){
                //if(Exists.run(ID:"//BUTTON[@id='f-modal-submit']")>0){Click.run(ID:"//BUTTON[@id='f-modal-submit']")}
                if(Exists.run(ID:"//*[contains(@class,'fractal-modal-header')]")>0){
                    println("'fractal-modal-header found")
                    Click.run(ID:"//BUTTON[@id='f-modal-submit']")
                }
                //else {Click.run(ID:"//BUTTON[@id='f-modal-submit']//span[text()='Delete Status']")}
                else {Click.run(ID:"//div[@id='delete_custom_idea_status_popup']//span[@class='green_btn_center' and text()='Delete Status']")}
            }
            if(params."Action"=="Cancel"){
                if(Exists.run(ID:"//*[contains(@class,'fractal-modal-header')]")>0){Click.run(ID:"//BUTTON[@data-test='modal-footer-cancel']")}
                else {Click.run(ID:"//div[@id='delete_custom_idea_status_popup']//a[text()='Cancel']")}
            }
        }
        sleep(3000)
        ExecuteJavascript.run(Code:"window.scrollTo(0, 0);")
    }
}