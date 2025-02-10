package actions.PipelineStepsView;

import actions.selenium.SendKeys
import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.Exists

class AddAdminIdeaTaginPipelineStepspage{
    public void run(def params){
        if(Exists.run(ID:"//*[@id='actions_dropdown']")==1){
            Click.run(ID:"//*[@id='actions_dropdown']")  
        	Click.run(ID:"//*[@id='action-admin_label']")
        }
        if(params."Tag Name"){
            params."Tag Name".split(",").eachWithIndex{name, x ->
                if(params."Tag Add or Remove".split(",")[x]=="Add"){
                    SetText.run(ID:"//*[@class='react-tags__combobox-input']",Text:name)
                    sleep(2000)
                    SendKeys.run(ID:"//*[@class='react-tags__combobox-input']",Key:"ENTER")
                }
                else{
                    Click.run(ID:"//*[contains(@class,'react-tags__tag')]//SPAN[text()='${name}']/..//*[contains(@class,'f-rmv-tag')]")
                }
            }
        }
        if(params."Remove All Existing Tags"){Click.run(ID:"//*[@class='f-tags-remove-all']/DIV/DIV/DIV")}
		if(params.Action=="Add Admin Tags"){Click.run(ID:"//*[@data-test='modal-footer-submit']")}
        else{Click.run(ID:"//*[@class='f-footer']//*[text()='${params.Action}']")}
        if(params."Remove All Existing Tags Action"=="Submit"){
           Click.run(ID:"//BUTTON[contains(@class,'f-submit-btn')]") 
        }
    }
}