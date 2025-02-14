package actions.ViewIdea.BusinessImpact;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.SelectItem
import actions.selenium.Exists

class SetBenefitsinBusinessImpacttab{
   public void run(def params){

        params."Year".split(",").eachWithIndex{ year, x ->  
            int y
            if(year.contains("Q")){
                int yearOfQuarter = year.split(" ")[1].toInteger()
                int yearOfcurrentYear = params."Current Year".split(" ")[1].toInteger()
                int yearDifference = yearOfQuarter - yearOfcurrentYear
                println(yearDifference)
                def quarterOfCurrentYear = (params."Current Year".split(" ")[0]).charAt(1)
                def quarterOfNextYear = (year.split(" ")[0]).charAt(1)
                
                y = 4*yearDifference+[quarterOfNextYear-quarterOfCurrentYear]
            } else {
               y = year.toInteger() - params."Current Year".toInteger() 
            }
            
            def rowNumber = params."Row Number of the Benefit".split(",")
            def action = params."Add or Edit Benefits".split(",")
            if (action[x]=="Add") {
                if (Exists.run(ID:"//*[@id='financial-table-benefits-row-${rowNumber[x].toInteger() - 1}-cell-${y*2+2}-input']") == 0) {
                    Click.run(ID:"//*[@id='financial-impact-add-benefit']")}}
            if (params."Benefit Type"){
                def benefitType = params."Benefit Type".split(",")
                SelectItem.run(ID:"//*[@id='financial-table-benefits-row-${rowNumber[x].toInteger() - 1}-cell-0-select']","Visible Text":benefitType[x],"Type of Clear":"Cut")}
            if(params."Actual Benefit"){
                def actual = params."Actual Benefit".split(",")
                SetText.run(ID:"//*[@id='financial-table-benefits-row-${rowNumber[x].toInteger() - 1}-cell-${y*2+2}-input']",Text:actual[x],"Type of Clear":"Cut")}
            if(params."Projected Benefit"){
                def projected = params."Projected Benefit".split(",")
                SetText.run(ID:"//*[@id='financial-table-benefits-row-${rowNumber[x].toInteger() - 1}-cell-${y*2+1}-input']",Text:projected[x],"Type of Clear":"Cut")}
        }
    }
}
