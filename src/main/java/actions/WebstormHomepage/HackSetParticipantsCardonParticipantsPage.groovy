package actions.WebstormHomepage;

import actions.selenium.Click
import actions.selenium.SetReactDropdown

class HackSetParticipantsCardonParticipantsPage{
    public void run(def params){
        def xpath = "//DIV[contains(@class,'ideas-view-grid')]/DIV[contains(@class,'f-participant-card')]//DIV[contains(@class,'f-participant-name-header')]/*[normalize-space(.)='${params."Username"}']"
        if(params."Click Edit your profile"){Click.run(ID:xpath+"/../A[text()='Edit your profile']")}
        if(params."Toggle Available to join teams"=="ON"){
         	Click.run(ID:xpath+"/../../../..//DIV[@class='f-participant-actions']//DIV[contains(@class,'f-toggle-off')]")   
        }else if (params."Toggle Available to join teams"=="OFF"){
            Click.run(ID:xpath+"/../../../..//DIV[@class='f-participant-actions']//DIV[contains(@class,'f-toggle-on')]") 
        }
        if(params."Leave Event"){
            Click.run(ID:xpath+"/../../../..//DIV[@class='f-participant-actions']//DIV[contains(@class,'fractal-dropdown')]")
            Click.run(ID:xpath+"/../../../..//DIV[@class='f-participant-actions']//DIV[contains(@class,'fractal-dropdown')]//UL/LI/P[starts-with(.,'Update or leave event...')]")
            sleep(2000)
        }
        if(params.Actions){
            Click.run(ID:xpath+"/../../../..//DIV[@class='f-participant-actions']//DIV[contains(@class,'fractal-dropdown')]")
            SetReactDropdown.run("Option":params.Actions)
        }
        if(params."Click on Project title"){Click.run(ID:xpath+"/../../../../..//DIV[contains(@class,'f-participant-projects')]/P/A[starts-with(.,'${params."Click on Project title"}')]")}
        if(params."Click on the participant card"){Click.run(ID:xpath+"/../../../../DIV")}
    }
}