package actions.ViewIdea;
import actions.selenium.Exists
import actions.selenium.Click

class VerifyProjectionsinProjectionstab{
    public void run(def params){

        if(params."Current or History" == "past") {
            if (Exists.run(ID:"//*[@class='past-projections']//*[@class='fractal-widget-projections-list-item-v1']//SPAN[contains(text(),'${params."Date"}')]") == 1) {
                Click.run(ID:"//*[@class='past-projections']//*[@class='fractal-widget-projections-list-item-v1']//SPAN[contains(text(),'${params."Date"}')]/../../../..//I")   
            }
        }

        if(params."Date") {assert Exists.run(ID:"//*[@id='projections-content']//*[contains(@class,'${params."Current or History"}-projection')]//*[@class='fractal-widget-projections-list-item-v1']//DIV[@class='false']/..//SPAN[position()=1][text()='${params."Date"}']") == 1,"Error - Date Incorrect"}

        if(params."No of Years") {assert Exists.run(ID:"//*[@id='projections-content']//*[contains(@class,'${params."Current or History"}-projection')]//*[@class='fractal-widget-projections-list-item-v1']//DIV[@class='false']/..//SPAN[contains(text(),'${params."No of Years"}')]") == 1,"Error - No of yrs incorrect"}

        params."Year".split(",").eachWithIndex{ name, x ->
            if(params."Cost") {
                def cost  = params."Cost".split(",")
                assert Exists.run(ID:"//*[@id='projections-content']//*[contains(@class,'${params."Current or History"}-projection')]//*[@class='fractal-widget-projections-list-item-v1']//DIV[@class='false']//SPAN[contains(.,'Year')][contains(.,'${name}')]/../..//*[contains(@id,'cost-${name}') and contains(text(),'${cost[x]}')]") == 1,"Error - Cost for ${name} incorrect"}

            if(params."Revenue Savings") {
                def revenue = params."Revenue Savings".split(",")
                assert Exists.run(ID:"//*[@id='projections-content']//*[contains(@class,'${params."Current or History"}-projection')]//*[@class='fractal-widget-projections-list-item-v1']//DIV[@class='false']//SPAN[contains(.,'Year')][contains(.,'${name}')]/../..//*[contains(@id,'revenue-${name}') and contains(text(),'${revenue[x]}')]")== 1,"Error - Revenue for ${name} incorrect"}

            if(params."Net Profit") { 
                def netProfit = params."Net Profit".split(",")
                if(netProfit[x].contains("-")) { 
                    String negativeNetprofit = netProfit[x].replaceAll("-","")
                    assert Exists.run(ID:"//*[@id='projections-content']//*[contains(@class,'${params."Current or History"}-projection')]//*[@class='fractal-widget-projections-list-item-v1']//DIV[@class='false']//SPAN[contains(.,'Year')][contains(.,'${name}')]/../..//SPAN[@class='negative-value']//*[contains(@id,'net-${name}') and contains(text(),'${negativeNetprofit}')]") == 1,"Error - Net projected profit for ${name} incorrect"}
                else { assert Exists.run(ID:"//*[@id='projections-content']//*[contains(@class,'${params."Current or History"}-projection')]//*[@class='fractal-widget-projections-list-item-v1']//DIV[@class='false']//SPAN[contains(.,'Year')][contains(.,'${name}')]/../..//SPAN[not(contains(@class,'negative-value'))]//*[contains(@id,'net-${name}') and contains(text(),'${netProfit[x]}')]") == 1,"Error - Net projected profit for ${name} incorrect"}
            }

            if(params."Total Projected Profit"){
                if(params."Total Projected Profit".contains("-")){
                    String negativeTotalProfit = params."Total Projected Profit".replaceAll("-","")
                    assert Exists.run(ID:"//*[@id='projections-content']//*[contains(@class,'${params."Current or History"}-projection')]//*[@class='fractal-widget-projections-list-item-v1']//SPAN[@class='negative-value']//*[contains(@id,'total') and contains(text(),'${negativeTotalProfit}')]")==1,"Error - Total profit incorrect"
                } else { assert Exists.run(ID:"//*[@id='projections-content']//*[contains(@class,'${params."Current or History"}-projection')]//*[@class='fractal-widget-projections-list-item-v1']//SPAN[not(contains(@class,'negative-value'))]//*[contains(@id,'total') and contains(text(),'${params."Total Projected Profit"}')]")==1,"Error - Total profit incorrect"
                       }
            }          
        }
        if(params."Notes") {assert Exists.run(ID:"//*[@id='projections-content']//*[contains(@class,'${params."Current or History"}-projection')]//*[@class='fractal-widget-projections-list-item-v1']//DIV[@class='false']//*[@class='projection-notes' and text()='${params."Notes"}']") == 1,"Error - Failed to find notes"}
    }
}


