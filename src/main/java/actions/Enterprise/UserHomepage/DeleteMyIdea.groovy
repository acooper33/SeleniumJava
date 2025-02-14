package actions.Enterprise.UserHomepage;

import actions.selenium.*

class DeleteMyIdea{
    public void run(def params){

        MouseOver.run(ID:"//*[@class='fractal-table-cell f-sparks-table-title']//*[contains(.,'${params."Title"}')]")
        Click.run(ID:"//*[@class='fractal-table-cell f-sparks-table-title']//*[contains(.,'${params."Title"}')]/../..//I[contains(@class,'trash')]")
        Click.run(ID:"//button[@id='clickToConfirmOkButton']")
        sleep(2000)
    }
}