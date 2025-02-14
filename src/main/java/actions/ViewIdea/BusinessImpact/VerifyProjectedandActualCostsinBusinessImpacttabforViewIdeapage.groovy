package actions.ViewIdea.BusinessImpact;

import actions.selenium.Exists
import actions.selenium.*

class VerifyProjectedandActualCostsinBusinessImpacttabforViewIdeapage{
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
            def rowNumber = params."Row Number".split(";")
            if (params."Cost Title") {
                def title = params."Cost Title".split(";")
                assert Exists.run(ID:"//*[@id='financial-table-costs-row-${rowNumber[x].toInteger() - 1}-cell-0']/SPAN[text()='${title[x]}']")==1,"Error - Incorrect Title on Row ${rowNumber[x]}"
            }
            if (params."Projected Cost") {
                def projected = params."Projected Cost".split(";")
                def path = "//*[@id='financial-table-costs-row-${rowNumber[x].toInteger() - 1}-cell-${y*2+1}']"
                if(projected[x] =="<EMPTY>"){
                    assert Exists.run(ID:"${path}[.='']")==1,"Error - Projected Cost value not null for ${year}" 
                } else {
                    assert Exists.run(ID:"${path}/SPAN[text()='${projected[x]}']")==1,"Error - Incorrect Projected Cost ${projected[x]} for ${year}"
                }
            }
            if (params."Actual Cost") {                
                def actual = params."Actual Cost".split(";")
                def path = "//*[@id='financial-table-costs-row-${rowNumber[x].toInteger() - 1}-cell-${y*2+2}']"
                if(actual[x] =="<EMPTY>"){
                    assert Exists.run(ID:"${path}[.='']")==1,"Error - Actual Cost value not null for ${year}" 
                } else {
                    assert Exists.run(ID:"${path}/SPAN[text()='${actual[x]}']")==1,"Error - Incorrect Actual Cost ${actual[x]} for ${year}"
                }
            }  
        }
    }
}