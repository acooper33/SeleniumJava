package actions.ViewIdea.BusinessImpact;

import actions.selenium.Click
import actions.selenium.SetText
import actions.selenium.Exists

class SetCostsinBusinessImpacttab{
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
            def rowNumber = params."Row Number".split(",")
            def action = params."Add or Edit Costs".split(",")
            if (action[x]=="Add") {
                if (Exists.run(ID:"//*[@id='financial-table-costs-row-${rowNumber[x].toInteger() - 1}-cell-${y*2+2}-input']") == 0) {
                    Click.run(ID:"//*[@id='financial-impact-add-cost']")}}
            if (params."Cost Title"){
                def title = params."Cost Title".split(",")
                if (Exists.run(ID:"//*[@id='financial-table-costs-row-${rowNumber[x].toInteger() - 1}-cell-0-input' and @value='${title[x]}']") == 0) {
                    SetText.run(ID:"//*[@id='financial-table-costs-row-${rowNumber[x].toInteger() - 1}-cell-0-input']",Text:title[x],"Type of Clear":"Cut")}
            }
            if(params."Actual Cost"){
                def actual = params."Actual Cost".split(",")
                SetText.run(ID:"//*[@id='financial-table-costs-row-${rowNumber[x].toInteger() - 1}-cell-${y*2+2}-input']",Text:actual[x],"Type of Clear":"Cut")}
            if(params."Projected Cost"){
                def projected = params."Projected Cost".split(",")
                SetText.run(ID:"//*[@id='financial-table-costs-row-${rowNumber[x].toInteger() - 1}-cell-${y*2+1}-input']",Text:projected[x],"Type of Clear":"Cut")}
        }
    }
}
