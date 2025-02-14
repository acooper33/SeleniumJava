package actions.ViewIdea.BusinessImpact;

import actions.selenium.*
    
class DeleteFinancialorNonFinancialBenefitandCostinBusinessImpacttab{
    public void run(def params){

        if(params."Type" == "Financial Benefits") {
            MouseOver.run(ID:"//*[@id='financial-table-benefits-row-${params."Row Number".toInteger() - 1}-cell-0-select']")
            Click.run(ID:"//*[@id='financial-table-benefits-row-${params."Row Number".toInteger() - 1}-delete']/i")
        } else  if(params."Type" == "Financial Cost") {
            MouseOver.run(ID:"//*[contains(@id,'financial-table-costs') and @value='${params."Title"}']")
            Click.run(ID:"//*[@class='table-row-delete']/i")
        } else {
            MouseOver.run(ID:"//*[contains(@id,'non-financial-table-impact') and @value='${params."Title"}']")
            Click.run(ID:"//*[@class='table-row-delete']/i") 
        }
    }
}