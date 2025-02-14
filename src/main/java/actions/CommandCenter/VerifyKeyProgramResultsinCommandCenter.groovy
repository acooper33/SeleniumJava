package actions.CommandCenter;

import actions.selenium.Exists
import actions.selenium.utils.Elements
import actions.selenium.Browser
import actions.selenium.GetText


class VerifyKeyProgramResultsinCommandCenter{
    public void run(def params){
        
        sleep(3000)
        if (params."Unique Participants"){
            assert(Exists.run(ID:"//*[@class='key-metrics-panel']/SPAN[@class='key-metrics-title' and text()='Unique Participants']/following-sibling::SPAN[normalize-space(.)='${params."Unique Participants"}']", "Timeout":60)>0), "Error - Unexpected Number of Unique Participants"
        }
        if(params."Opportunities Created"){
            assert(Exists.run(ID:"//*[@class='key-metrics-panel']/SPAN[@class='key-metrics-title' and text()='Opportunities Created']/following-sibling::SPAN[normalize-space(.)='${params."Opportunities Created"}']", "Timeout":60)>0), "Error - Unexpected Number of Opportunities Created"
        }
        if(params."Projected Net Benefit"){
            assert(Exists.run(ID:"//*[@class='key-metrics-panel']/SPAN[@class='key-metrics-title' and text()='Projected Net Benefit']/following-sibling::SPAN[normalize-space(.)='${params."Projected Net Benefit"}']", "Timeout":60)>0), "Error - Unexpected Projected Net Benefit"
        }
        if(params."Non-Financial Benefits"){
            assert(Exists.run(ID:"//*[@class='key-metrics-panel']/SPAN[@class='key-metrics-title' and text()='Non-Financial Benefits']/following-sibling::SPAN[normalize-space(.)='${params."Non-Financial Benefits"}']", "Timeout":60)>0), "Error - Unexpected Non-Financial Benefits"
        }
        if(params."Actual Benefits"){
            assert(Exists.run(ID:"//*[@class='key-metrics-panel']/SPAN[@class='key-metrics-title' and text()='Actual Benefits']/following-sibling::SPAN[normalize-space(.)='${params."Actual Benefits"}']", "Timeout":60)>0), "Error - Unexpected Actual Benefits"
        }
    }
}