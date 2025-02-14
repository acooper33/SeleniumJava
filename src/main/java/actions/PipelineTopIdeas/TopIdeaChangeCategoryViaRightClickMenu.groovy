package actions.PipelineTopIdeas;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetCombobox


class TopIdeaChangeCategoryViaRightClickMenu{
    public void run(def params){
        //Click.run(ID:"//UL[@class='f-best-idea-right-click-menu']/LI[contains(.,'Change Category')]")
        if(params."Choose Category"){
            Click.run(ID:"//DIV[@class='fractal-modal-header ']/SPAN[@class='title' and .='Change Category']/../..//DIV[contains(@class,'f-modal-body')]//*[@id='f-select-category']")
            //SetCombobox.run(ID:"//DIV[@class='fractal-modal-header ']/SPAN[@class='title' and .='Change Category']/../..//DIV[contains(@class,'f-modal-body')]//*[@id='f-select-category']", Option: params."Choose Category", "Type of Clear":"Cut")
            SetText.run(ID:"//DIV[@class='fractal-modal-header ']/SPAN[@class='title' and .='Change Category']/../..//DIV[contains(@class,'f-modal-body')]//*[@id='f-select-category']", Text: params."Choose Category")
            Click.run(ID:"//*[contains(@id,'f-combobox-list')]/DIV[contains(@class,'f-combobox-list-item') and contains(.,'${params."Choose Category"}')]")
        }
        if(params.Action=="Save"){
            Click.run(ID:"//*[@class='f-footer ']/BUTTON[contains(@data-test,'submit')]")
        }
        else if(params.Action=="Cancel"){
            Click.run(ID:"//*[@class='f-footer ']/BUTTON[contains(@data-test,'cancel')]")
        }
    }
}