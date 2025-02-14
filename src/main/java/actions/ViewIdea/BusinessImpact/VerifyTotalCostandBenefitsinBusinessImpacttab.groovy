package actions.ViewIdea.BusinessImpact;

import actions.selenium.Exists

class VerifyTotalCostandBenefitsinBusinessImpacttab{
    public void run(def params){

        params."Year".split(";").eachWithIndex{ year, x -> 
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
            if (params."Projected Net Benefit") {
                def path = "//*[@id='financial-table-footer-row-0-cell-${y*2+1}']/SPAN"
                def totalProjected = params."Projected Net Benefit".split(";")
                if(totalProjected[x].contains("-")) { 
                    String negativeNetProjected = totalProjected[x].replaceAll("-","")
                    assert Exists.run(ID:"${path}[@class='financial-impact-results negative-result' and text()='${negativeNetProjected}']")==1,"Error - Incorrect Projected Net Benefit for ${year}"
                } else if(totalProjected[x] == "<EMPTY>"){
                    assert Exists.run(ID:"${path}[@class='financial-impact-results empty-result']")==1,"Error - Projected Net Benefit not null for ${year}"
                } else {
                    assert Exists.run(ID:"${path}[@class='financial-impact-results' and text()='${totalProjected[x]}']")==1,"Error - Incorrect Projected Net Benefit for ${year}"
                }                      
            }
            if (params."Actual Net Benefit") {
                def path = "//*[@id='financial-table-footer-row-0-cell-${y*2+2}']/SPAN"
                def totalActual = params."Actual Net Benefit".split(";")
                if(totalActual[x].contains("-")) { 
                    String negativeNetActual = totalActual[x].replaceAll("-","")
                    assert Exists.run(ID:"${path}[@class='financial-impact-results negative-result' and text()='${negativeNetActual}']")==1,"Error - Incorrect Actual Net Benefit for ${year}"
                } else if(totalActual[x] == "<EMPTY>"){
                    assert Exists.run(ID:"${path}[@class='financial-impact-results empty-result']")==1,"Error - Actual Net Benefit not null for ${year}"
                } else { 
                    assert Exists.run(ID:"${path}[@class='financial-impact-results' and text()='${totalActual[x]}']")==1,"Error - Incorrect Actual Net Benefit for ${year}"
                }                      
            }
            if (params."Total Projected Cost") {
                def totalProjectedCost = params."Total Projected Cost".split(";")
                def path = "//*[@id='financial-table-costs-summary-row-0-cell-${y*2+1}']/SPAN"
                if(totalProjectedCost[x] =="<EMPTY>"){
                    assert Exists.run(ID:"${path}[@class='financial-impact-results empty-result']")==1,"Error - Total Projected Cost value not null for ${year}" 
                } else {
                    assert Exists.run(ID:"${path}[text()='${totalProjectedCost[x]}']")==1,"Error - Incorrect Total Projected Cost for ${year}"
                }
            } 
            if (params."Total Actual Cost") {
                def totalActualCost = params."Total Actual Cost".split(";")
                def path = "//*[@id='financial-table-costs-summary-row-0-cell-${y*2+2}']/SPAN"
                if(totalActualCost[x] =="<EMPTY>"){
                    assert Exists.run(ID:"${path}[@class='financial-impact-results empty-result']")==1,"Error - Total Actual Cost value not null for ${year}" 
                } else {
                    assert Exists.run(ID:"${path}[text()='${totalActualCost[x]}']")==1,"Error - Incorrect Total Actual Cost for ${year}"
                } 
            }
            if (params."Total Projected Benefit") {
                def path = "//*[@id='financial-table-benefits-summary-row-0-cell-${y*2+1}']/SPAN"
                def totalProjectedBenefit = params."Total Projected Benefit".split(";")
                if(totalProjectedBenefit[x] =="<EMPTY>"){
                    assert Exists.run(ID:"${path}[@class='financial-impact-results empty-result']")==1,"Error - Total Projected Benefit value not null for ${year}" 
                } else {
                    assert Exists.run(ID:"${path}[text()='${totalProjectedBenefit[x]}']")==1,"Error - Incorrect Total Projected Value for ${year}"
                } 
            }
            if (params."Total Actual Benefit") {
                def path = "//*[@id='financial-table-benefits-summary-row-0-cell-${y*2+2}']/SPAN"
                def totalActualBenefit = params."Total Actual Benefit".split(";")
                if(totalActualBenefit[x] =="<EMPTY>"){
                    assert Exists.run(ID:"${path}[@class='financial-impact-results empty-result']")==1,"Error - Total Actual Benefit value not null for ${year}" 
                } else {
                    assert Exists.run(ID:"${path}[text()='${totalActualBenefit[x]}']")==1,"Error - Incorrect Total Actual Value for ${year}"
                } 
            }
        }
    }
}