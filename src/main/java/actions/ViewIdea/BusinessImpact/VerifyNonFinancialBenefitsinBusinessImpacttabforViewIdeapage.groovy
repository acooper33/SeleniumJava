package actions.ViewIdea.BusinessImpact;

import actions.selenium.Exists
import actions.selenium.Click
import actions.selenium.*

class VerifyNonFinancialBenefitsinBusinessImpacttabforViewIdeapage{
    public void run(def params){
        
        if(params."Expand the Result"==true){
            Click.run(ID:"//*[@class='collapsible-header-section' and .='Non-Financial Summary']/..//*[contains(@class,'fa fa-plus-square-o')]")
            sleep(2000)
        }
        assert Exists.run(ID:"//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-0']/SPAN[text()='${params."Benefit Title"}']")==1,"Error - Incorrect Title ${params."Benefit Title"} on Row ${params."Row Number"}"
        if (params."Benefit Type") {
            assert Exists.run(ID:"//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-1']/SPAN[text()='${params."Benefit Type"}']")==1,"Error - Incorrect Benefit Type on Row ${params."Row Number"}"
        }
        if (params."Start Date") {
            assert Exists.run(ID:"//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-2']/SPAN[text()='${params."Start Date"}']")==1,"Error - Incorrect Start Date on Row ${params."Row Number"}"
        }
        if (params."End Date") {                
            assert Exists.run(ID:"//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-3']/SPAN[text()='${params."End Date"}']")==1,"Error - Incorrect End Date Value on Row ${params."Row Number"}"
        }  
        if (params."Description") {
            def path = "//*[@id='non-financial-table-impact-row-${params."Row Number".toInteger() - 1}-cell-4']/SPAN"
            if(params."Description" == "<EMPTY>"){
                ExplicitWait.run(ID:"${path}[not(text())]")
                assert Exists.run(ID:"${path}[not(text())]")==1,"Error - Description for ${params."Benefit Title"} on Row ${params."Row Number"} is not null"    
            } else {
                assert Exists.run(ID:"${path}[text()='${params."Description"}']")==1,"Error - Incorrect Description for ${params."Benefit Title"} on Row ${params."Row Number"}"
            }
        } 
    }
}
