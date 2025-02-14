package actions.ViewIdea;

import actions.selenium.SetText
import actions.selenium.Click

class SetOwnerinViewIdeaPage{
    public void run(def params){
       Click.run(ID:"//*[contains(@class,'inline-edit-icon fa fa-pencil')]","Type of Click":"Javascript")

        params."User".split(",").eachWithIndex{ user, x ->
            if(params."User Add or Remove".split(",")[x]=="Add"){
                SetText.run(ID:"//*[@id='available-user-search']",Text:user)
                Click.run(ID:"//*[@class='member-list member-list-left']//*[text()='${user}']")
            }
            else {
                Click.run(ID:"//*[@class='member-list member-list-right']//*[text()='${user}']/../I","Type of Click":"Javascript")
            }
        }
        Click.run(ID:"//*[starts-with(@class,'fractal-button')]/*[text()='${params."Action"}']")
        sleep (2000)
    } 
} 
