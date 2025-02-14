package actions.PipelineDashBoard;

import actions.selenium.Exists

class VerifyBenefitsOverTimeStats{
    public void run(def params){
        
        if(params."Total Projected Benefits"){
            assert Exists.run(ID:"//*[@id='chart-projected-total' and text()='${params."Total Projected Benefits"}']")==1,"Error - Incorrect Total Projected Benefits"}
         if(params."Total Actual Benefits"){
            assert Exists.run(ID:"//*[@id='chart-actual-total' and text()='${params."Total Actual Benefits"}']")==1,"Error - Incorrect Total Actual Benefits"}   
        if(params."Total Actual Benefits"){
            if(params."Total Target Benefits"=="<EMPTY>"){
                assert Exists.run(ID:"//*[@id='f-chart-total-text text-actual' and text()='Total Target Benefits']")==0,"Error - Total Targets should not be displayed"
            } else {
                assert Exists.run(ID:"//*[@id='chart-target-total' and text()='${params."Total Target Benefits"}']")==1,"Error - Incorrect Total Target Benefits"} 
            }         
    }
}