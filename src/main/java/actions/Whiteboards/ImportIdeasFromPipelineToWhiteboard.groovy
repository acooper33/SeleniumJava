package actions.Whiteboards;

import actions.selenium.Click
import actions.selenium.SendKeys
import actions.selenium.SetText
import actions.selenium.SetCombobox

class ImportIdeasFromPipelineToWhiteboard{
    public void run(def params){
        if(params."Choose pipeline"){
            Click.run(ID:"//INPUT[@id='f-canvas-select-initiative']")
            SetCombobox.run(ID:"//INPUT[@id='f-canvas-select-initiative']", Option:params."Choose pipeline")
            //SetText.run(ID:"//INPUT[@id='f-canvas-select-initiative']", Text:params."Choose pipeline")
            //Click.run(ID:"//*[@id='f-combobox-list']/DIV[contains(@class,'f-combobox-list-item')]/SPAN[contains(.,'${params."Choose pipeline"}')]")         
        }  
        if(params."Choose idea(s) to import"){
            params."Choose idea(s) to import".split(',').eachWithIndex{name, x ->
                Click.run(ID:"//DIV[contains(@class,'f-idea-list')]/DIV[contains(@class,'f-idea-list-item')]/SPAN[starts-with(.,'${name}')]")
            }
        }
        if(params."Advanced Settings"){
            Click.run(ID:"(//DIV[contains(@class,'f-tabs-header')]/BUTTON[contains(@class,'fractal-button')])[2]")
            if(params."Sort by"){
                Click.run(ID:"//DIV[@class='f-advanced-options']/UL/LI/DIV[@class='f-import-list-item']//P[@class='f-import-radio-title' and text()='${params."Sort by"}']/../DIV[contains(@class,'f-radio-wrapper')]")
            }
            if(params."Organized in"){
                Click.run(ID:"//DIV[@class='f-advanced-options']/UL/LI/DIV[@class='f-import-list-item']//P[@class='f-import-radio-title' and text()='${params."Organized in"}']/../DIV[contains(@class,'f-radio-wrapper')]")
            }
        }
        if(params.Action=='Cancel'){Click.run(ID:"//BUTTON[@id='pipeline-idea-cancel']")}
        else if(params.Action=='Submit'){Click.run(ID:"//BUTTON[@id='pipeline-idea-save']")}
    }
}