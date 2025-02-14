package actions.ProjectRoom;

import actions.selenium.Click

class ProjectRoomSetTaskNoteSection{
    public void run(def params){
        def xpath
        
        if(params.Close){Click.run(ID:"//DIV[@class='f-notes-flyover-heading']//DIV[@class='f-close-button']")}
        
        if(params."Task" && params."What link text should say? (optional)"){
            xpath = "//*[contains(@class,'fractal-input')]/*[@value='${params."Task"}']/../../../..//SPAN[contains(@class,'add-note') and .='${params."What link text should say? (optional)"}']"
        }else if(params."Task Title"){
            xpath = "//*[contains(@class,'fractal-input')]/*[@value='${params."Task"}']/../../../..//SPAN[contains(@class,'add-note')']"
        }else{
          	xpath = "//*[contains(@class,'fractal-input')]/../../..//SPAN[contains(@class,'add-note')']"
        }
        
        if(params.Open){Click.run(ID:xpath)}
    }
}