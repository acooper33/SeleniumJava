package actions.Enterprise.UserHomepage;

import actions.selenium.SetText
import actions.selenium.Click
import actions.selenium.SetFocus

class SetViewMyIdeaTextField{
    public void run(def params){

        def id
        if(params."Field Name"=="Title"){
            id = "//*[@class='f-spark-edit-title']"
            Click.run(ID:id)
            SetText.run(Text:params."Field Value",ID:"//*[@id='fractal-edit-spark-title']","Type of Clear":"Cut")
        }

        if(params."Field Name"=="Description"){
            Click.run(ID:"//*[@id='edit-spark-description']")
            SetText.run(Text:params."Field Value",ID:"//*[contains(@class,'redactor-styles redactor-in redactor-in')]","Type of Clear":"Cut")
        }
        Click.run(ID:"//*[@class='f-spark-edit-header' and text()='Attachments']")
       	sleep(2000)
    }
}