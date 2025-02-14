package actions.ViewIdea30;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetText

class SetSubmitterinViewIdea3{
    public void run(def params){
        
        Click.run(ID:"//*[contains(@class,'f-hover-submitter')]/I","Type of Click":"Javascript")
        
        SetText.run(ID:"//*[@id='team-name-input']",Text:params."Submission Team Name","Type of Clear":"Cut")
        if(params."User"){
            params."User".split(",").eachWithIndex{ name, x ->
                if(params."Add or Remove or Set Owner".split(",")[x]=="Add"){
                    def user = params."User Name on the List".split(",")
                	SetText.run(ID:"//*[@id='team-members-search']",Text:name,"Type of Clear":"Cut")
                	Click.run(ID:"//*[contains(@class,'team-list team-list-left')]//*[text()='${user[x]}']","Type of Click":"Javascript")                
                }
                else if(params."Add or Remove or Set Owner".split(",")[x]=="Remove"){
                    Click.run(ID:"//*[@class='member-name' and text()='${name}']/..//I[contains(@class,'far fa-times')]")
                } else{
                	sleep(1000)
                	Click.run(ID:"//*[@class='member-name' and text()='${name}']/..//I[contains(@class,'fa fa-key')]")
                }
            }
        }
        if(params."Action"){
            if(params."Action" == "Update"){Click.run(ID:"//*[@id='team-members-save']")}
            else if(params."Action" == "Cancel"){Click.run(ID:"//*[@id='team-members-cancel']")}
            else {Click.run(ID:"//*[contains(@class,'wrapper-inner')]//*[@class='close-buttons']//I")}
        }
        sleep(5000)
    } 
}
