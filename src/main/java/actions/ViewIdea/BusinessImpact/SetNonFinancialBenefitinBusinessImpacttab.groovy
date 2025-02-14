package actions.ViewIdea.BusinessImpact;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SelectItem
import actions.selenium.Exists

class SetNonFinancialBenefitinBusinessImpacttab{
    public void run(def params){

        if(Exists.run(ID:"//*[@id='business-impact-tab-non-financial']/I[contains(@class,'fa-plus-square-o')]")==1){ 
            Click.run(ID:"//*[@id='business-impact-tab-non-financial']/I[contains(@class,'fa-plus-square-o')]")
        } 
        if (params."Add or Edit"=="Add") {
            Click.run(ID:"//*[@class='tab-body non-financial-impact']/DIV//DIV[@class='add-button']")
            SetText.run(ID:"//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-0-input']",Text:params."Benefit Title")}
        else { 
            SetText.run(ID:"//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-0-input']",Text:params."Benefit Title","Type of Clear":"Cut")}
        if (params."Benefit Type"){
            SelectItem.run(ID:"//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-1-select']","Visible Text":params."Benefit Type")}
        if (params."Start Date"){
            SetText.run(ID:"//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-2-datepicker']",Text:params."Start Date","Type of Clear":"Cut")
            Click.run(ID:"//*[@id='non-financial-table-header-row-0-cell-0']/SPAN")}
        if(params."End Date"){
            SetText.run(ID:"//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-3-datepicker']",Text:params."End Date","Type of Clear":"Cut")
            Click.run(ID:"//*[@id='non-financial-table-header-row-0-cell-0']")}
        if(params."Description"){
            SetText.run(ID:"//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-4-textarea']",Text:params."Description","Type of Clear":"Cut")
        }
    }
}
