package actions.ViewIdea.BusinessImpact;

import actions.selenium.Exists

class VerifyProjectedandActualBenefitsinBusinessImpacttabforViewIdeapage{
    public void run(def params){

        sleep(3000)
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
            
            def rowNumber = params."Row Number of the Benefit".split(";")
            if (params."Benefit Type") {
                def benefitType = params."Benefit Type".split(";")
                assert Exists.run(ID:"//*[@id='financial-table-benefits-row-${rowNumber[x].toInteger() - 1}-cell-0']/SPAN[text()='${benefitType[x]}']")==1,"Error - Incorrect Benefit Type on Row ${rowNumber[x]}"
            }
            if (params."Projected Benefit") {
                def projected = params."Projected Benefit".split(";")
                def path = "//*[@id='financial-table-benefits-row-${rowNumber[x].toInteger() - 1}-cell-${y*2+1}']"
                if(projected[x] =="<EMPTY>"){
                    assert Exists.run(ID:"${path}[.='']")==1,"Error - Projected Benefit value not null for ${year}" 
                } else {
                    assert Exists.run(ID:"${path}/SPAN[text()='${projected[x]}']")==1,"Error - Incorrect Projected Value ${projected[x]} for ${year}"
                }
            }
            if (params."Actual Benefit") {                
                def actual = params."Actual Benefit".split(";")
                def path = "//*[@id='financial-table-benefits-row-${rowNumber[x].toInteger() - 1}-cell-${y*2+2}']"
                if(actual[x] =="<EMPTY>"){
                    assert Exists.run(ID:"${path}[.='']")==1,"Error - Actual Benefit value not null for ${year}" 
                } else {
                    assert Exists.run(ID:"${path}/SPAN[text()='${actual[x]}']")==1,"Error - Incorrect Actual Value ${actual[x]} for ${year}"
                }
            }  
        }
    }
}