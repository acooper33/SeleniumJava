package actions.PipelineTopIdeas;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCombobox

class TopIdeasChangeStatusViaRightClickMenu{
    public void run(def params){
        //Click.run(ID:"//UL[@class='f-best-idea-right-click-menu']/LI[contains(.,'Change Status')]")
        if(params."Choose Status"){
            Click.run(ID:"//DIV[@class='fractal-modal-header ']/SPAN[@class='title' and .='Change Status']/../..//DIV[contains(@class,'f-modal-body')]//*[@id='f-select-status']")
        	sleep(1000)
        	SetCombobox.run(ID:"//DIV[@class='fractal-modal-header ']/SPAN[@class='title' and .='Change Status']/../..//DIV[contains(@class,'f-modal-body')]//*[@id='f-select-status']", Option: params."Choose Status")
            //SetText.run(ID:"//DIV[@class='fractal-modal-header ']/SPAN[@class='title' and .='Change Status']/../..//DIV[contains(@class,'f-modal-body')]//*[@id='f-select-status']", Text: params."Choose Status")
            //Click.run(ID:"//*[contains(@id,'f-combobox-list')]/DIV[contains(@class,'f-combobox-list-item') and contains(.,'${params."Choose Status"}')]")
        }
        if(params.Action=="Save"){
            Click.run(ID:"//*[@class='f-footer ']/BUTTON[contains(@data-test,'submit')]")
        }
        else if(params.Action=="Cancel"){
            Click.run(ID:"//*[@class='f-footer ']/BUTTON[contains(@data-test,'cancel')]")
        }
    }
}