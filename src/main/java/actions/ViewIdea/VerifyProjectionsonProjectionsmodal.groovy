package actions.ViewIdea;

import actions.selenium.Exists
import actions.selenium.VerifyText

class VerifyProjectionsonProjectionsmodal{
    public void run(def params){

        if (params."Year") {
            params."Year".split(",").eachWithIndex{ name, x ->
                def netProfit = params."Net Profit".split(",")
                if(netProfit[x].contains("-")) {
                    String negativeNetProfit = netProfit[x].replaceAll("-","")
                    assert Exists.run(ID:"//*[@class='grid-placeholder negative-value']/SPAN[@id='projections-net-${name}' and contains(text(),'${negativeNetProfit}')]")==1,"Error - Net profit not in negative for year ${name}"
                } else { assert Exists.run(ID:"//*[@class='grid-placeholder ']/SPAN[@id='projections-net-${name}' and contains(text(),'${netProfit[x]}')]")==1,"Error - Net profit incorrect for year ${name}" }
            }
        }
        if(params."Total Projected Profit"){
            if(params."Total Projected Profit".contains("-")){
                String negativeTotalProjectedProfit = params."Total Projected Profit".replaceAll("-","")
                assert Exists.run(ID:"//*[@class='negative-value']/SPAN[@id='projections-current-total' and contains(text(),'${negativeTotalProjectedProfit}')]")==1,"Error - Total profit incorrect or not negative"
            } else { assert Exists.run(ID:"//*[not(contains(@class,'negative-value'))]/SPAN[@id='projections-current-total'and contains(text(),'${params."Total Projected Profit"}')]")==1,"Error - Total profit incorrect or is negative"}
        }
        if(params."ROI"){
            if(params."ROI".contains("-")){
                String negativeROI = params."ROI".replaceAll("-","")
                assert Exists.run(ID:"//*[@class='negative-value']/SPAN[@id='projections-current-roi' and starts-with(text(),'${negativeROI}')]")==1,"Error - ROI incorrect"
            } else { assert Exists.run(ID:"//*[not(contains(@class,'negative-value'))]/SPAN[@id='projections-current-roi' and starts-with(text(),'${params."ROI"}')]")==1,"Error - ROI incorrect"}
        }
    }
}
